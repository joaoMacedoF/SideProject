package com.project.rest.filter;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.project.shared.enums.SimNaoEnum;
import com.project.shared.utils.DateUtils;

@Order(1)
public class ExportRequestFilter implements Filter {
	
	private static final String EXPORT_FORMAT_PARAMETER = "export";
	private static final String EXPORT_TARGET_FORMAT = "csv";
	private static final String LABEL = "label";
	private static final String ORDER = "order";
	private static final String TRANSFORMER = "transformer";
	private static final String RESPONSE = "response";
	//private static final String ELEMENTS = "elements";
	private static final String CONTENT = "content";
	private static final String DATA = "data";

	@Autowired
	private MessageSource messageSource;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		messageSource = WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext())
				.getBean(MessageSource.class);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		if (StringUtils.isNotBlank(req.getParameter(EXPORT_FORMAT_PARAMETER)) && req.getParameter(EXPORT_FORMAT_PARAMETER).compareTo(EXPORT_TARGET_FORMAT) == 0) {
			String url = req.getRequestURI().substring(req.getContextPath().length());

			if (url.contains("size")) {
				url = url.replaceAll("(size=)[^&]*", "$1" + String.valueOf(Integer.MAX_VALUE));
			} else {
				url += url.contains("?") ? "&" : "?";
				url = url.concat("size=" + Integer.MAX_VALUE);
			}
			
			if (url.contains("page")) {
				url = url.replaceAll("(page=)[^&]*", "$1" + "0");
			} else {
				url += url.contains("?") ? "&" : "?";
				url = url.concat("page=0");
			}

			ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) response);
			String configurationName =  StringUtils.substringAfterLast(StringUtils.substringBefore(url, "?"), "/");
			
			String fileName = StringUtils.substringAfterLast(StringUtils.substringBefore(url, "?"), "/") + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			
			responseWrapper.setHeader(HttpHeaders.CONTENT_DISPOSITION,
					"attachment; filename=\"" +fileName+"."+ EXPORT_TARGET_FORMAT + "\"");
			
			responseWrapper.setHeader(HttpHeaders.CONTENT_TYPE, "text/csv");

			req.getRequestDispatcher(url).include(req, responseWrapper);

			String responseContent = new String(responseWrapper.getDataStream());

			JsonObject output;
			String csv = "";
			try {
				output = JsonParser.parseString(responseContent).getAsJsonObject();
				
				JsonObject responseObject = output.getAsJsonObject(RESPONSE);
				
				JsonElement responseElement = responseObject.get(DATA);
				JsonArray content = null;
				
				if(responseElement.isJsonObject()) {
					responseObject=responseElement.getAsJsonObject();
					content= responseObject.getAsJsonArray(CONTENT);
				}else {
					content= responseElement.getAsJsonArray();
				}
				
				JsonArray newContent = getNewContent(content, configurationName);

				csv = getJsonArrayAsCsv(newContent);
			} catch (JSONException e) {
				e.printStackTrace();
			}

			responseWrapper.getResponse().getOutputStream().write(csv.getBytes("cp1252"));

		} else {
			chain.doFilter(request, response);
		}

	}

	private JsonArray getNewContent(JsonArray content, String context) throws JsonSyntaxException, IOException {
		InputStream inputStream = this.getClass().getResourceAsStream("/csv-mapper.json");
		
		JsonObject json = JsonParser.parseString(IOUtils.toString(inputStream,"UTF-8")).getAsJsonObject();
		
		Template template = new Template();
		template.setCsvName(context);
		
		JsonObject jsonObject = json.getAsJsonObject(context);
		
		List<TemplateElement> templateElements = new ArrayList<TemplateElement>();

		Set<String> keys = jsonObject.keySet();
		for (String key : keys) {
			JsonArray elements = jsonObject.getAsJsonArray(key);

			JsonObject element = elements.get(0).getAsJsonObject();

			TemplateElement templateElement = new TemplateElement();
			templateElement.setPath(key);
			templateElement.setTransformer(TransformerEnum.getTransformer(element.get(TRANSFORMER).getAsString()));
			templateElement.setLabel(element.get(LABEL).getAsString());
			templateElement.setOrder(element.get(ORDER).getAsInt());
			templateElements.add(templateElement);
		}
		templateElements.sort((o1,o2)->o1.getOrder().compareTo(o2.getOrder()));

		template.setElements(templateElements);

		JsonArray newContent = new JsonArray();

		for (JsonElement o : content) {
			if (o instanceof JsonObject) {
				JsonObject crt = (JsonObject) o;
				JsonObject newJsonObject = new JsonObject();
				for (TemplateElement t : templateElements) {
					JsonObject tmp = crt;
					JsonElement newPath = calculatePath(tmp, t);
					
					String transformedValue = transformValue(t.getTransformer(), newPath.isJsonNull()?null : newPath.getAsString());
					
					newJsonObject.addProperty(messageSource.getMessage(t.getLabel(), null, Locale.getDefault()),
							transformedValue);

				}
				newContent.add(newJsonObject);
			}
		}
		return newContent;
	}

	private String transformValue(TransformerEnum transformer, String value) {
		if (transformer != null) {
			if(transformer.name().equals(TransformerEnum.TEXT.name()))
			{
				String transformedValue = value;
				
				if(value == null)
					transformedValue = "";
				else
					transformedValue = "=\"\"" + transformedValue + "\"\""; // forcar o CSV a considerar como texto
				
				return transformedValue;
			}
			else if (value == null && transformer.name().equals(TransformerEnum.NULL_TO_EMPTY.name())) {
				return "";
			} else if (value != null && transformer.name().equals(TransformerEnum.CURRENCY.name())) {
				return value.replace(".", ",") + " €";
			} else if (transformer.name().equals(TransformerEnum.DATE.name())) {
				Date isoDate = DateUtils.isoStringToDate((String) value);
				String readableDate = DateUtils.convertDateToReadableString(isoDate);
				return readableDate;
			} else if (value != null && transformer.name().equals(TransformerEnum.BOOLEAN.name())) {
				return value.compareTo("false")== 0 ? String.valueOf(SimNaoEnum.NAO.getCode()) : String.valueOf(SimNaoEnum.SIM.getCode());
			}
		}
		return value;
	}
	
	private String getJsonArrayAsCsv(JsonArray array) {
		String csv = "";

		if (array.size() > 0) {
			List<String> keys = new ArrayList<String>(array.get(0).getAsJsonObject().keySet());
			for (int i = 0; i < keys.size(); i++) {
				csv += keys.get(i);
				if (i != keys.size() - 1) {
					csv += ";";
				} else {
					csv += "\n";
				}
			}
			for (JsonElement element : array) {
				for (int i = 0; i < keys.size(); i++) {
					JsonElement elem = element.getAsJsonObject().get(keys.get(i));
					if (!elem.isJsonNull()) {
						csv += "\"" + elem.getAsString() + "\"";
					} else {
						csv += "";
					}
					if (i != keys.size() - 1) {
						csv += ";";
					} else {
						csv += "\n";
					}
				}
			}
		}
		return csv;
	}
	
	private JsonElement calculatePath(JsonObject tmp, TemplateElement t) {

		String firstPath = t.getPath();
		String[] spl = firstPath.split("\\.");

		JsonElement result = tmp.get(spl[0]);

		for (int i = 1; i < spl.length; i++) {
			result = result.getAsJsonObject().get(spl[i]);
		}

		return result;
	}
	
}
