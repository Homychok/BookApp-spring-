package com.example.bookappspring.service;

import com.example.bookappspring.entity.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowService implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book newBook = new Book();
        newBook.setBookName(rs.getString("bookName"));
        newBook.setBookAuthor(rs.getString("bookAuthor"));
        newBook.setBookYear(rs.getInt("bookYear"));
        newBook.setIsbn(rs.getInt("isbn"));
        return newBook;
    }
}
