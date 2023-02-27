package com.project.shared.service;

import java.util.List;

import com.project.shared.dto.data.BooksDto;
import com.project.shared.dto.response.BaseResponseDto;

public interface BookService {
	
	public BaseResponseDto<List<BooksDto>> getBooks();

}
