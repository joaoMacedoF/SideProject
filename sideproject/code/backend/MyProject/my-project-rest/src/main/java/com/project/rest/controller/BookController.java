package com.project.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.LibraryApi;
import com.project.api.LibraryApiDelegate;
import com.project.model.Book;
import com.project.model.ResponseDtoListBookDto;
import com.project.rest.converters.BookConverter;
import com.project.rest.utils.ResponseUtils;
import com.project.shared.dto.data.BooksDto;
import com.project.shared.dto.response.BaseResponseDto;
import com.project.shared.service.BookService;

@Service
public class BookController implements LibraryApiDelegate{
	
	@Autowired
	private BookService bookService;

	@Override
	public ResponseEntity<ResponseDtoListBookDto> getAllBooksInLibraryUsingGET() {
		HttpStatus responseStatus = HttpStatus.OK;
		ResponseDtoListBookDto apiResponseDto = new ResponseDtoListBookDto();
		try {
			BaseResponseDto<List<BooksDto>> books = bookService.getBooks();
			responseStatus=ResponseUtils.fillErrorData(apiResponseDto, books);
			apiResponseDto.setResponse(BookConverter.convertDtoToModel(books.getResponse()));
			
		}catch(Exception e) {
			e.printStackTrace();
			responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(apiResponseDto, responseStatus);
	}	
	

}
