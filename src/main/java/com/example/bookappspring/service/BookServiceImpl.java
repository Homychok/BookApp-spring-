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
        bookDAO.addBook(book);
    }

    @Transactional
    public void updateBook(String bookName, String bookAuthor, int bookYear) {
        bookDAO.updateBook(bookName, bookAuthor, bookYear);

    }

    @Override
    @Transactional
    public void deleteBookByIsbn(int isbn) {
        Book book = bookDAO.getBookByIsbn(isbn);
        if (book == null) {
            throw new BookException("Book with isbn=" + book.getIsbn() + "doesn't exist");
        }
        bookDAO.deleteBookByIsbn(isbn);
    }
}
