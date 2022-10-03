package com.trial.springaop.service;

import com.trial.springaop.model.entity.Book;

import java.util.Optional;

public interface BookService {

    Optional<Book> getBook(Long id);

    boolean createBook(Book book);

}
