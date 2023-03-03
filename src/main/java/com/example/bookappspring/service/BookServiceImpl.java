package com.example.bookappspring.service;

import com.example.bookappspring.dao.BookDAO;
import com.example.bookappspring.entity.Book;
import com.example.bookappspring.exceptions.BookException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

private BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public List<Book> getBook() {
        return bookDAO.getBook();
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDAO.insert(book);

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBookByIsbn(int isbn) {

    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDAO.insert(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDAO.update(book);

    }

    @Override
    @Transactional
    public void deleteBookByIsbn(int id) {
        Book book = bookDAO.getBookByIsbn(book.getIsbn());
        if (book == null) {
            throw new BookException("Book with isbn=" + book.getIsbn() + "doesn't exist");
        }
        bookDAO.delete(book.getIsbn());
    }
}
