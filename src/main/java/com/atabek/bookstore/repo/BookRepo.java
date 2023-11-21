// BookRepo.java
package com.atabek.bookstore.repo;

import com.atabek.bookstore.data.Postgres;
import com.atabek.bookstore.model.Book;
import com.atabek.bookstore.repo.interfaces.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepo implements IBookRepo {

    private final JdbcTemplate jdbcTemplate;
    private Postgres postgres;

    @Autowired
    public BookRepo(JdbcTemplate jdbcTemplate, Postgres postgres) {
        this.jdbcTemplate = jdbcTemplate;
        this.postgres = postgres;
    }

    @Override
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Book book = new Book();
            book.setTitle(resultSet.getString("book_name"));
            book.setAuthor(resultSet.getString("book_author"));
            book.setPrice(resultSet.getInt("book_price"));
            book.setImageUrl(resultSet.getString("imageUrl"));
            book.setId(resultSet.getInt("book_id"));
            return book;
        });
    }

    @Override
    public void addBook(Book book) {
        String sql = "INSERT INTO book (book_name, book_author, book_price, \"imageUrl\") VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getImageUrl());
    }

    @Override
    public Book getBook(int id) {
        String sql = "SELECT * FROM book WHERE book_id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, rowNum) -> {
                Book book = new Book();
                book.setTitle(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("book_author"));
                book.setPrice(resultSet.getDouble("book_price"));
                book.setImageUrl(resultSet.getString("imageUrl"));
                book.setId(resultSet.getInt("book_id"));
                return book;
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void editBook(Book book, int id) {
        String sql = "UPDATE book SET book_name = ?, book_author = ?, book_price = ?, imageUrl = ? WHERE book_id = ?";
        try {
            jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setString(2, book.getAuthor());
                preparedStatement.setDouble(3, book.getPrice());
                preparedStatement.setString(4, book.getImageUrl());
                preparedStatement.setLong(5, id);
                return preparedStatement;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeBook(int id) {
        String sql = "DELETE FROM book WHERE book_id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



















