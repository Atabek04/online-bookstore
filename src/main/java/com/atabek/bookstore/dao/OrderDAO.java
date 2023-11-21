package com.atabek.bookstore.dao;

import com.atabek.bookstore.model.Book;
import com.atabek.bookstore.model.Order;
import com.atabek.bookstore.model.OrderItem;
import com.atabek.bookstore.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDAO {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderDAO(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void addOrderItem(Book book, int quantity) {
        // Assuming you have a logged-in user and a customer associated with the order
        // For simplicity, you may need to implement user authentication and customer handling

        Order order = new Order();
        OrderItem orderItem = new OrderItem();
        orderItem.setBook(book);
        orderItem.setQuantity(quantity);
        orderItem.setSubtotal(book.getPrice() * quantity);

        order.getOrderItems().add(orderItem);
        order.setTotalAmount(orderItem.getSubtotal());

        orderRepo.save(order);
    }
}
