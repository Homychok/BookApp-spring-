package com.example.bookappspring.dao;


import com.example.bookappspring.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookDAO {
    void insert(Book book);
    void update(String bookName, String bookAuthor, int bookYear);
    void delete(int isbn);
    Book getBookByIsbn(int isbn);
    List<Book> getBook();

}
