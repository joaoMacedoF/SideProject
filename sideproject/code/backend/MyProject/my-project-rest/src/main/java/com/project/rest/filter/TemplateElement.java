package com.project.rest.filter;

public class TemplateElement {
	private String path;
	private String label;
	private TransformerEnum transformer;
	private Integer order;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public TransformerEnum getTransformer() {
		return transformer;
	}

	public void setTransformer(TransformerEnum transformer) {
		this.transformer = transformer;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}


}
