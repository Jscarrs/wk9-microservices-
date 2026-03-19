package com.lab.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.orders.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
