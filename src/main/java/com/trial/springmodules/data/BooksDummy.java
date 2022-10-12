package com.trial.springmodules.data;

import com.trial.springmodules.model.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksDummy {

    public static List<Book> createBooksData() {
        List<Book> books = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            books.add(
                    Book.builder()
                            .id(Integer.toUnsignedLong(i))
                            .name("Book" + i)
                            .isbn(i + "00000")
                            .build());
        }
        return books;
    }

}
