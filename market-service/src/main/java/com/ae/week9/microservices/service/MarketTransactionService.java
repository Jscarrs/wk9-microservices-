package com.ae.week9.microservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ae.week9.microservices.model.MarketTransaction;
import com.ae.week9.microservices.repository.MarketTransactionRepository;

@Service
public class MarketTransactionService {

	private final MarketTransactionRepository marketTransactionRepository;

	public MarketTransactionService(MarketTransactionRepository marketTransactionRepository) {
		this.marketTransactionRepository = marketTransactionRepository;
	}

	public MarketTransaction save(MarketTransaction marketTransaction) {
		return marketTransactionRepository.save(marketTransaction);
	}

	public List<MarketTransaction> findAll() {
		return marketTransactionRepository.findAll();
	}

	public List<MarketTransaction> findByOrderId(Integer orderId) {
		return marketTransactionRepository.findByOrderId(orderId);
	}
}
