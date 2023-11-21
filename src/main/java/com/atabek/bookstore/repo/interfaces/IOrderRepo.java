package com.atabek.bookstore.repo.interfaces;

import com.atabek.bookstore.model.Order;

public interface IOrderRepo {
    void save(Order order);
}
