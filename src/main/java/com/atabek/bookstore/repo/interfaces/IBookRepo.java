package com.atabek.bookstore.repo.interfaces;

import com.atabek.bookstore.model.Book;

import java.util.List;

public interface IBookRepo {
    List<Book> getAllBooks();

    void addBook(Book book);

    Book getBook(int id);

    void editBook(Book book, int id);

    void removeBook(int id);
}
