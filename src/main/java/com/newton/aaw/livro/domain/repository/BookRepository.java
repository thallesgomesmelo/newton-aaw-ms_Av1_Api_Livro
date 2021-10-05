package com.newton.aaw.livro.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newton.aaw.livro.domain.entity.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}
