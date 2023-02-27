package com.project.rest.translation;

import java.util.List;

public class SwaggerPageable {
	
	private Integer size;
	private Integer page;
	private List<String> sort;
	
	
	public Integer getSize() {
		return size;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}
	
	public Integer getPage() {
		return page;
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public List<String> getSort() {
		return sort;
	}
	
	public void setSort(List<String> sort) {
		this.sort = sort;
	}
	
	

}
