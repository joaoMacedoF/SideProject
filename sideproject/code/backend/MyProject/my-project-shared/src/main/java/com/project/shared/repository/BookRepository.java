package com.project.shared.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shared.domain.tables.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query("Select b "
			+ " From Book b")
	
	List<Book> getBooks();
	

}
