package com.project.rest.filter;

import java.util.List;

public class Template {
	
	private String csvName;
	private List<TemplateElement> elements;

	public String getCsvName() {
		return csvName;
	}

	public void setCsvName(String csvName) {
		this.csvName = csvName;
	}

	public List<TemplateElement> getElements() {
		return elements;
	}

	public void setElements(List<TemplateElement> elements) {
		this.elements = elements;
	}

}
