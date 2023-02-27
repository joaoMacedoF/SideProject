package com.project.shared.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project.shared.converters.BookConverter;
import com.project.shared.domain.tables.Book;
import com.project.shared.dto.data.BooksDto;
import com.project.shared.dto.response.BaseResponseDto;
import com.project.shared.enums.ErrorCodeEnum;
import com.project.shared.repository.BookRepository;
import com.project.shared.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
//	@CrossOrigin(origins = "*")
	public BaseResponseDto<List<BooksDto>> getBooks() {
		BaseResponseDto<List<BooksDto>> response = new BaseResponseDto<>();
		try {
			List<Book> book = bookRepository.getBooks();
			response.setResponse(BookConverter.converListBookToListDto(book));

			response.setError(ErrorCodeEnum.OK.getErrorCode());
		}catch(Exception e) {
			response.setError(ErrorCodeEnum.OK.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}
	

//	@Override
//	public List<BooksDto> getBooks() {
//		List<BooksDto> books = new ArrayList<>();
//		books.add(new BooksDto("123", "123"));
//		return books;
//	}

	
//	List<BooksDto> books = new ArrayList<>();
//	books.add(new BooksDto("123", "123"));
//	books.add(new BooksDto("1", "13"));
//	books.add(new BooksDto("3", "13"));
//	books.add(new BooksDto("123", "1"));
//	response.setResponse(books);
}
