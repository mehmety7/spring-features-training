package com.trial.springaop.controller;

import com.trial.springaop.controller.endpoint.BookControllerEndpoint;
import com.trial.springaop.model.entity.Book;
import com.trial.springaop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping(value = BookControllerEndpoint.BASE_URI)
    public ResponseEntity<Book> getBook(@RequestParam Long id){
        return ResponseEntity.ok(bookService.getBook(id).orElse(Book.builder().build()));
    }

}
