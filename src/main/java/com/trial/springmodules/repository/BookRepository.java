package com.trial.springmodules.repository;

import com.trial.springmodules.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book getBookById(Long id);

}
