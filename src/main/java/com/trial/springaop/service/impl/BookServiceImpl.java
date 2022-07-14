package com.trial.springaop.service.impl;

import com.trial.springaop.model.entity.Book;
import com.trial.springaop.repository.BookRepositorySpecification;
import com.trial.springaop.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepositorySpecification bookRepository;

    public BookServiceImpl(BookRepositorySpecification bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return bookRepository.getBook(id);
    }

}
