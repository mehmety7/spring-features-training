package com.trial.springmodules.service.impl;

import com.trial.springmodules.model.entity.Book;
import com.trial.springmodules.repository.BookRepository;
import com.trial.springmodules.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return Optional.of(bookRepository.getBookById(id));
    }

    @Override
    public boolean createBook(Book book) {
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
