package com.project.rest.configuration;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import springfox.documentation.RequestHandler;
import springfox.documentation.service.ResourceGroup;
import springfox.documentation.spi.service.contexts.ApiSelector;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spi.service.contexts.RequestMappingContext;
import springfox.documentation.spring.web.scanners.ApiListingReferenceScanResult;
import springfox.documentation.spring.web.scanners.ApiListingReferenceScanner;

public class CustomizedApiListingReferenceScanner extends ApiListingReferenceScanner {

	@Override
	public ApiListingReferenceScanResult scan(DocumentationContext context) {

	    Map<ResourceGroup, List<RequestMappingContext>> resourceGroupRequestMappings
	        = new HashMap<>();

	    int requestMappingContextId = 0;

	    ApiSelector selector = context.getApiSelector();
	    
	    Iterable<RequestHandler> matchingHandlers = context.getRequestHandlers().stream()
	        .filter(selector.getRequestHandlerSelector()).collect(toList());
	    
	    for (RequestHandler handler : matchingHandlers) {
	    	
	      @SuppressWarnings("deprecation")
		ResourceGroup resourceGroup = new ResourceGroup(
	    		  customizedGroupName(handler),
	          handler.declaringClass(),
	          0);

	      RequestMappingContext requestMappingContext
	          = new RequestMappingContext(
	          String.valueOf(requestMappingContextId),
	          context,
	          handler);

	      resourceGroupRequestMappings.putIfAbsent(
	          resourceGroup,
	          new ArrayList<>());
	      resourceGroupRequestMappings.get(resourceGroup).add(requestMappingContext);

	      ++requestMappingContextId;
	    }
	    return new ApiListingReferenceScanResult(resourceGroupRequestMappings);
	}
	
	private String customizedGroupName(RequestHandler handler)
	{
		final String groupName = handler.groupName().replace("-api-controller", "");
		
		String[] words = groupName.split("-");
		
		for(int i=0;i<words.length;i++)
		{
			words[i] = StringUtils.capitalize(words[i]);
		}
		
		return String.join("",words);
	}
	
}

