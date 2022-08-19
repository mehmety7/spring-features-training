package com.trial.springaop.repository;

import com.trial.springaop.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book getBookById(Long id);

}
