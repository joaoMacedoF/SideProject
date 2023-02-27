package com.project.shared.dto.data;

public class BooksDto {
	
	private Integer id;
	private String name;
	private String BookAuthor;
	
	
	
	
	public BooksDto() {
		super();
	}




	public BooksDto(Integer id, String name, String bookAuthor) {
		super();
		this.id = id;
		this.name = name;
		BookAuthor = bookAuthor;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBookAuthor() {
		return BookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	
	
	
	
}
