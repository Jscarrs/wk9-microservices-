package com.lab.orders.service;

import com.lab.orders.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public Order placeOrder(String accountId, String stockSymbol, int quantity, String orderType) {
        String orderId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Order order = new Order(orderId, accountId, stockSymbol, quantity, orderType, "PLACED");
        orders.add(order);
        return order;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrderById(String orderId) {
        return orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .findFirst()
                .orElse(null);
    }

    public Order cancelOrder(String orderId) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setStatus("CANCELLED");
        }
        return order;
    }
}
