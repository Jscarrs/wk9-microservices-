package com.lab.orders.controller;

import com.lab.orders.model.Order;
import com.lab.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Operation 1: Place a new order
    @PostMapping("/orders/place")
    public Order placeOrder(@RequestParam String accountId,
                            @RequestParam String stockSymbol,
                            @RequestParam int quantity,
                            @RequestParam String orderType) {
        return orderService.placeOrder(accountId, stockSymbol, quantity, orderType);
    }

    // Operation 2: Get all orders
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Operation 3: Get order by ID
    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable String orderId) {
        return orderService.getOrderById(orderId);
    }

    // Operation 4: Cancel an order
    @PostMapping("/orders/cancel/{orderId}")
    public Order cancelOrder(@PathVariable String orderId) {
        return orderService.cancelOrder(orderId);
    }
}
