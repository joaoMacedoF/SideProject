package com.project.rest.converters;

import java.util.ArrayList;
import java.util.List;


import com.project.model.BookDto;
import com.project.shared.dto.data.BooksDto;

public class BookConverter {
	
	public static BookDto convertBookDtoToModel(BooksDto b) {
		BookDto bookModel = new BookDto();
		bookModel.setId(b.getId());
		bookModel.setName(b.getName());
		bookModel.setBookAuthor(b.getBookAuthor());
		
		return bookModel;
	}
	
	public static List<BookDto> convertDtoToModel(List<BooksDto> list){
		
		List<BookDto> model = new ArrayList<BookDto>();
		for(BooksDto book : list) {
			model.add(convertBookDtoToModel(book));
		}
		return model;
	}

}
