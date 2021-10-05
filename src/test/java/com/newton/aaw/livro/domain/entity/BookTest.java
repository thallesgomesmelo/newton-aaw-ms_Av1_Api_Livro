package com.newton.aaw.livro.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.newton.aaw.livro.api.BookDto;

public class BookTest {
	@Test
	void test_createFromDto_withValidDto_shouldCreateOk() {
		//Given
		var dto = new BookDto();
		dto.setTitulo("O Vendedor de Sonhos");
		dto.setAutor("Augusto Cury");
		dto.setEditora("Gustavo Giani");
		dto.setDataDePublicacao(LocalDate.of(2006, 10, 12));
		dto.setStatus(0);
		
		//test
		var result = new Book(dto);
		
		//assert
		assertEquals(dto.getTitulo(), result.getTitulo());
		assertEquals(dto.getAutor(), result.getAutor());
		assertEquals(dto.getEditora(), result.getEditora());
		assertEquals(dto.getDataDePublicacao(), result.getDataDePublicacao());
		assertEquals(dto.getStatus(), result.getStatus());
	}
}
