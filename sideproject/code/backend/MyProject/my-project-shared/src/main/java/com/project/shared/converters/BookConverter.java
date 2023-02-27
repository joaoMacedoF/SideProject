package com.project.shared.converters;

import java.util.ArrayList;
import java.util.List;

import com.project.shared.domain.tables.Book;
import com.project.shared.dto.data.BooksDto;

public class BookConverter {
	
	public static BooksDto convertBookToBookDto(Book book) {
		
		BooksDto dto = new BooksDto();
		
		dto.setId(book.getId());
		dto.setName(book.getName());
		dto.setBookAuthor(book.getBookAuthor());
		
		return dto;
		
	}
	
	public static List<BooksDto> converListBookToListDto(List<Book> lbook){
		List<BooksDto> listDto = new ArrayList<BooksDto>();
		for(Book book : lbook) {
			listDto.add(convertBookToBookDto(book));
		}
		return listDto;
	}

}
