package com.atabek.bookstore.controller;

import com.atabek.bookstore.model.Book;
import com.atabek.bookstore.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BookController {

    private final BookDAO bookDAO;

    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model){
        return "index/index-3";
    }

    @GetMapping("/books")
    public String showBookList(Model model) {
        List<Book> booksFromDAO = bookDAO.getAllBooks();
        model.addAttribute("books", booksFromDAO);

        return "index/shop-grid-4-column";
    }

    @GetMapping("/books/{id}")
    public String showBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookDAO.getBook(id));
        return "index/product-details";
    }
}
