package com.newton.aaw.livro.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.newton.aaw.livro.api.BookDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	private String id;
	private String titulo;
	private String autor;
	private String editora;
	private LocalDate dataDePublicacao;
	private Integer status;
	private LocalDateTime createAt;
	private LocalDateTime modifiedAt;
	
	public Book(BookDto livro) {
		this.titulo = livro.getTitulo();
		this.autor = livro.getAutor();
		this.editora = livro.getEditora();
		this.dataDePublicacao = livro.getDataDePublicacao();
		this.status = livro.getStatus();
	}
}
