package com.newton.aaw.livro.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.newton.aaw.livro.domain.entity.Book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
	private String id;
	private String titulo;
	private String autor;
	private String editora;
	private LocalDate dataDePublicacao;
	private Integer status;
	private LocalDateTime createAt;
	private LocalDateTime modifiedAt;
	
	public BookDto(Book livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.autor = livro.getAutor();
		this.editora = livro.getEditora();
		this.dataDePublicacao = livro.getDataDePublicacao();
		this.status = livro.getStatus();
		this.createAt = livro.getCreateAt();
		this.modifiedAt = livro.getModifiedAt();
	}
}
