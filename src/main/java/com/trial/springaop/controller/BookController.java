package com.trial.springaop.controller;

import com.trial.springaop.controller.endpoint.BookControllerEndpoint;
import com.trial.springaop.model.entity.Book;
import com.trial.springaop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping(value = BookControllerEndpoint.BASE_URI)
    public ResponseEntity<Book> getBook(@RequestParam Long id){
        return ResponseEntity.ok(bookService.getBook(id).orElse(Book.builder().build()));
    }

    @PostMapping(value = BookControllerEndpoint.BASE_URI)
    public ResponseEntity<Boolean> createBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }
}
