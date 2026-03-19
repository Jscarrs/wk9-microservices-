package com.lab.orders.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lab.orders.model.Order;
import com.lab.orders.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final OrderSyncService orderSyncService;

	public OrderService(OrderRepository orderRepository, OrderSyncService orderSyncService) {
		this.orderRepository = orderRepository;
		this.orderSyncService = orderSyncService;
	}

	public Order placeOrder(String accountId, String stockSymbol, BigDecimal price, int quantity, String orderType) {
		Order order = new Order(null, LocalDate.now(), accountId, stockSymbol, price, quantity, orderType, "PLACED");
		Order savedOrder = orderRepository.save(order);
		orderSyncService.syncOrder(savedOrder);
		return savedOrder;
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
}
