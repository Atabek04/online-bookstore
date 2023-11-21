package com.atabek.bookstore.model;

public class OrderItem {
    private Long orderItemId;
    private Book book;
    private int quantity;
    private double subtotal;
    private int book_id;

    public OrderItem(Long orderItemId, Book book, int quantity, double subtotal) {
        this.orderItemId = orderItemId;
        this.book = book;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public OrderItem() {

    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getBookId() {
        if(book != null){
            return book.getId();
        }
        return -1;
    }

    public void setBookId(int book_id) {
        this.book_id = book_id;
    }
}
