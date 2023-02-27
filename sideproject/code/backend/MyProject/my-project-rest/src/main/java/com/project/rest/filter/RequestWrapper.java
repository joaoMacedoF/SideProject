package com.project.rest.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper {

	private final Map<String, String[]> modifiableParameters;
	private Map<String, String[]> allParameters = null;
	private Map<String, String> headerMap;

	/**
	 * Create a new request wrapper that will merge additional parameters into the
	 * request object without prematurely reading parameters from the original
	 * request.
	 * 
	 * @param request
	 * @param additionalParams
	 */
	public RequestWrapper(final HttpServletRequest request, final Map<String, String[]> additionalParams) {
		super(request);
		modifiableParameters = new TreeMap<>();
		modifiableParameters.putAll(additionalParams);
		headerMap = new HashMap<>();
	}

	@Override
	public String getParameter(final String name) {
		String[] strings = getParameterMap().get(name);
		if (strings != null) {
			return strings[0];
		}
		return super.getParameter(name);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		if (allParameters == null) {
			allParameters = new TreeMap<>();
			allParameters.putAll(super.getParameterMap());
			allParameters.putAll(modifiableParameters);
		}
		// Return an unmodifiable collection because we need to uphold the interface
		// contract.
		return Collections.unmodifiableMap(allParameters);
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(getParameterMap().keySet());
	}

	public void addHeader(String name, String value) {
		headerMap.put(name, new String(value));
	}

	public void removeHeader(String name) {
		headerMap.remove(name);
	}

	@Override
	public Enumeration<String> getHeaderNames() {
		List<String> list = new ArrayList<>();
		list.addAll(headerMap.keySet());
		return Collections.enumeration(list);
	}

	@Override
	public String getHeader(String name) {
		Object value;
		value = headerMap.get(name);
		if (name.compareTo("Accept") == 0)
			return value==null? "" :value.toString();
		else
			return ((HttpServletRequest) getRequest()).getHeader(name);
	}

}
