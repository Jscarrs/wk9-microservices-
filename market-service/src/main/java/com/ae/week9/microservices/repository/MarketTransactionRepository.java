package com.ae.week9.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae.week9.microservices.model.MarketTransaction;

public interface MarketTransactionRepository extends JpaRepository<MarketTransaction, Long> {
	List<MarketTransaction> findByOrderId(Integer orderId);
}
