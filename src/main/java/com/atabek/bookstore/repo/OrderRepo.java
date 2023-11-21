package com.atabek.bookstore.repo;

import com.atabek.bookstore.data.Postgres;
import com.atabek.bookstore.model.Order;
import com.atabek.bookstore.model.OrderItem;
import com.atabek.bookstore.repo.interfaces.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;

@Component
public class OrderRepo implements IOrderRepo {

    private final JdbcTemplate jdbcTemplate;
    private final Postgres postgres;

    @Autowired
    public OrderRepo(JdbcTemplate jdbcTemplate, Postgres postgres) {
        this.jdbcTemplate = jdbcTemplate;
        this.postgres = postgres;
    }

    @Override
    public void save(Order order) {
        String orderInsertSql = "INSERT INTO orders (total_amount, customer_id, order_date) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(orderInsertSql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, order.getTotalAmount());
            ps.setLong(2, order.getCustomerId());
            ps.setTimestamp(3, Timestamp.valueOf(order.getOrderDate()));
            return ps;
        }, keyHolder);

        // Get the generated order_id
        long orderId = keyHolder.getKey().longValue();

        // Save the order items
        String orderItemInsertSql = "INSERT INTO order_items (order_id, book_id, quantity, subtotal) VALUES (?, ?, ?, ?)";
        for (OrderItem orderItem : order.getOrderItems()) {
            jdbcTemplate.update(orderItemInsertSql,
                    orderId,
                    orderItem.getBookId(),
                    orderItem.getQuantity(),
                    orderItem.getSubtotal());
        }
    }
}
