package com.trial.springmodules.service;

import com.trial.springmodules.model.entity.Book;

import java.util.Optional;

public interface BookService {

    Optional<Book> getBook(Long id);

    boolean createBook(Book book);

}
