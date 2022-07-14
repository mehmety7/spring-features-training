package com.trial.springaop.repository;

import com.trial.springaop.data.BooksDummy;
import com.trial.springaop.model.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositorySpecification {

    private final List<Book> data;

    public BookRepositorySpecification() {
        this.data = BooksDummy.createBooksData();
    }

    public Optional<Book> getBook(Long id) {
        if (id > 20) {
            return Optional.empty();
        }
        return Optional.of(data.get(Math.toIntExact(id) - 1));
    }

}
