package com.atabek.bookstore.controller;

import com.atabek.bookstore.dao.BookDAO;
import com.atabek.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dashboard")
public class AdminController {
    private final BookDAO bookDAO;

    @Autowired
    public AdminController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(){
        return "dashboard/index";
    }

    @GetMapping("/books")
    public String books(Model model){
        model.addAttribute("books", bookDAO.getAllBooks());
        return "dashboard/books";
    }

    @GetMapping("/books/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "dashboard/new_book";
    }

    @PostMapping("/books")
    public String addBook(@ModelAttribute("book") Book book){
        bookDAO.addBook(book);
        return "redirect:/dashboard/books";
    }

    @GetMapping("/books/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookDAO.getBook(id));
        model.addAttribute("book_id", id);
        return "dashboard/edit_book";
    }

    @PatchMapping("/books/{id}")
    public String update(@ModelAttribute("book") Book book, @PathVariable int id,
                           @RequestParam(value = "_method", required = false) String method) {
        if("PATCH".equalsIgnoreCase(method)){
            bookDAO.editBook(book, id);
            return "redirect:/dashboard/books";
        }
        return null;
    }

    @GetMapping("/books/{id}/remove")
    public String remove(@PathVariable("id") int id){
        bookDAO.removeBook(id);
        return "redirect:/dashboard/books";
    }
}
