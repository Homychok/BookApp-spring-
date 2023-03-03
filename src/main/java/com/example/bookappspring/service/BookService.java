package com.example.bookappspring.service;
import com.example.bookappspring.entity.Book;

import java.util.List;


public interface BookService {
    List<Book> getBook();
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBookByIsbn(int isbn);
}
