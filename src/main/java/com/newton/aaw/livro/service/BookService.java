package com.newton.aaw.livro.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newton.aaw.livro.domain.entity.Book;
import com.newton.aaw.livro.domain.repository.BookRepository;
import com.newton.aaw.livro.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {
	private final BookRepository bookRepository;
	
	public Book create(Book livro) {
		var now = LocalDateTime.now();
		
		//Pra quando for feita alteracao no livro
		livro.setCreateAt(now);
		livro.setModifiedAt(now);
		
		bookRepository.save(livro);
		
		return livro;
	}
	
	public Book update(String id, Book livro) {
		var existing = get(id);
		//Fazendo a atualizacao dos conteudo do livro
		existing.setTitulo(livro.getTitulo());
		existing.setAutor(livro.getAutor());
		existing.setEditora(livro.getEditora());
		existing.setDataDePublicacao(livro.getDataDePublicacao());
		existing.setStatus(livro.getStatus());
		existing.setModifiedAt(livro.getModifiedAt());
		
		bookRepository.save(existing);
		return existing;
	}

	public Book get(String id) {
		var book = bookRepository.findById(id);
		
		if(book.isEmpty()) {
			throw new NotFoundException("Livro de ID " + id + " não encontrado");
		}
		return book.get();
	}
	
	public List<Book> getAll() {
		return bookRepository.findAll();
	}
	
	public void delete(String id) {
		get(id);
		bookRepository.deleteById(id);
	}
}
