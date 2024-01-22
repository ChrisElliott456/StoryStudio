package com.ss.StoryStudioApp.service;

import com.ss.StoryStudioApp.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book getBookById(Long id);

    Book addBook(Book book);

    void deleteBookById(Long id);

    Book updateBook(Long id, Book book);
}
