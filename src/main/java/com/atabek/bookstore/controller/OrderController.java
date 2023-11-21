package com.atabek.bookstore.controller;

import com.atabek.bookstore.dao.BookDAO;
import com.atabek.bookstore.dao.OrderDAO;
import com.atabek.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    private final BookDAO bookDAO;
    private final OrderDAO orderDAO;

    @Autowired
    public OrderController(BookDAO bookDAO, OrderDAO orderDAO) {
        this.bookDAO = bookDAO;
        this.orderDAO = orderDAO;
    }

    @PostMapping("/books/{book_id}/add-to-cart")
    public String addToCart(@PathVariable int book_id, int quantity) {
        Book book = bookDAO.getBook(book_id);

        if (book != null) {
            orderDAO.addOrderItem(book, quantity);
            return "redirect:/books/" + book_id;
        } else {
            return "redirect:/books/";
        }
    }
}
