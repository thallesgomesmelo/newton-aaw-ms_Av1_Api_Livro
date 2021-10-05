package com.newton.aaw.livro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newton.aaw.livro.api.BookDto;
import com.newton.aaw.livro.domain.entity.Book;
import com.newton.aaw.livro.service.BookService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BookController {
	private final BookService bookService;
	
	@GetMapping("/books/{id}")
	public BookDto getById(@PathVariable String id) {
		var book = bookService.get(id);
		
		return new BookDto(book);
	}
	
	@GetMapping("/books")
	public List<BookDto> getAll() {
		var books = bookService.getAll();
		var bookDtos = new ArrayList<BookDto>();
		
		for(var book: books) {
			bookDtos.add(new BookDto(book));
		}
		
		return bookDtos;
	}
	
	@PostMapping("/books")
	public BookDto create(@RequestBody BookDto livro) {
		var book = new Book(livro);
		
		book = bookService.create(book);
		
		return new BookDto(book);
	}
	
	@PutMapping("/books/{id}")
	public BookDto update(@PathVariable String id, @RequestBody BookDto livro) {
		var book = new Book(livro);
		
		book = bookService.update(id, book);
		
		return new BookDto(book);
	}
	
	public ResponseEntity<Void> delete(@PathVariable String id) {
		bookService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
