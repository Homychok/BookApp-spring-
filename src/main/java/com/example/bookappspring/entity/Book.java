package com.example.bookappspring.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbn")
    private int isbn;
    @Column(name = "Название книги")
    private String bookName;
    @Column(name = "Автор книги")
    private String bookAuthor;

    @Column(name = "Год издания книги")
    private int bookYear;

    public Book() {
    }

    public Book(int isbn, String bookName, String bookAuthor, int bookYear) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
    }

    public static void lengthIsbn(String isbn) {
        int sum = 0;
        String numberIsbn = isbn.replaceAll("[\\-\\s]", "");
        if (numberIsbn.length() != 13) {
            throw new IllegalArgumentException("ISBN не может быть короче 13 чисел!");
        }
        if (!numberIsbn.matches("[0-9]+")) {
            throw new IllegalArgumentException("ISBN может содержать только цифры!");
        }
        int[] strIsbn = Integer.toString(Integer.parseInt(numberIsbn)).chars().map(c -> c-'0').toArray();
        int[] coefficient = {1,3,1,3,1,3,1,3,1,3,1,3,1};
        for (int i = 0; i < 12; i++) {
            sum += strIsbn[i] * coefficient[i];
        }
        if (sum % 10 == 0) {
            strIsbn[12] = 10 - sum%10;}
        else{
       throw new IllegalArgumentException("неверная контрольная цифра ISBN!");}
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {

        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getIsbn() == book.getIsbn() && getBookYear() == book.getBookYear() && Objects.equals(getBookName(), book.getBookName()) && Objects.equals(getBookAuthor(), book.getBookAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn(), getBookName(), getBookAuthor(), getBookYear());
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookYear=" + bookYear +
                '}';
    }
}

