package com.example.bookappspring.dao;


import com.example.bookappspring.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookDAO {
    void addBook(Book book);
    void updateBook(String bookName, String bookAuthor, int bookYear);
    void deleteBookByIsbn(int isbn);
    Book getBookByIsbn(int isbn);
    List<Book> getBook();

}
