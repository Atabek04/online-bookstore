// BookDAO.java
package com.atabek.bookstore.dao;

import com.atabek.bookstore.model.Book;
import com.atabek.bookstore.repo.BookRepo;
import com.atabek.bookstore.repo.interfaces.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDAO {

    private final IBookRepo bookRepo;

    @Autowired
    public BookDAO(IBookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.getAllBooks();
    }


    public void addBook(Book book) {
        bookRepo.addBook(book);
    }

    public Book getBook(int id) {
        return bookRepo.getBook(id);
    }

    public void editBook(Book book, int id) {
        bookRepo.editBook(book, id);
    }

    public void removeBook(int id) {
        bookRepo.removeBook(id);
    }
}
