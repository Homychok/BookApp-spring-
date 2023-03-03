package com.example.bookappspring.controller;

import com.example.bookappspring.entity.Book;
import com.example.bookappspring.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/com")
public class RestControllerNew {
    private BookService bookService;

    public RestControllerNew(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/book")
    public List<Book> getBook() {
        return bookService.getBook();

    }
    @PostMapping("/api/book")
    public Book addBook(@RequestBody Book book) {

        bookService.addBook(book);
        return book;
    }
    @PutMapping("/api/book")
    public Book updateBook(@RequestBody Book book) {

        bookService.updateBook(book.getBookName(), book.getBookAuthor(), book.getBookYear());
        return book;

    }
    @DeleteMapping("/api/book")
    public void deleteBook(@RequestParam int isbn) {

        bookService.deleteBookByIsbn(isbn);

    }
}
