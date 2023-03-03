package com.example.bookappspring.dao;

import com.example.bookappspring.service.BookRowService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.example.bookappspring.entity.Book;

import javax.sql.DataSource;
import java.util.List;
@Component
public class BookDAOImpl implements BookDAO {
    private final JdbcTemplate template;

    public BookDAOImpl(@Lazy JdbcTemplate template) {
        this.template = template;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Override

    public void addBook(Book book) {
        template.update("INSERT INTO book VALUES (?, ?, ?, ?)",
                book.getBookName(), book.getBookName(), book.getBookYear(), book.getIsbn());
//        Session session = sessionFactory.getCurrentSession();
//        session.save(book);
    }
    @Override

    public void updateBook(String bookName, String bookAuthor, int bookYear) {
        template.update("UPDATE book SET bookName = ?, bookAuthor = ?, bookYear = ? WHERE isbn = ?");
//        Session session = sessionFactory.getCurrentSession();
//        session.update(bookName, bookAuthor);
//        session.update(bookYear);

    }

    @Override
    public void deleteBookByIsbn(int isbn) {
        template.update("DELETE FROM book WHERE isbn = ?", isbn);
    }
//    @Override
//
//    public void delete(int isbn) {

//        Session session = sessionFactory.getCurrentSession();
//        org.hibernate.query.Query<Book> query = session.createQuery("delete from Book where isbn=:isbn");
//        query.setParameter("isbn", isbn);
//        query.executeUpdate();
//    }
    @Override

    public Book getBookByIsbn(int isbn) {
        return template.query("SELECT * FROM book WHERE isbn = ?",
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(Book.class, isbn);    }
@Override
    public List<Book> getBook() {
        return template.query("SELECT * FROM book", new BookRowService());
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("From Book").list();
    }



}
