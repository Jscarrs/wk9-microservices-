package com.ae.week9.microservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ae.week9.microservices.model.MarketTransaction;
import com.ae.week9.microservices.service.MarketTransactionService;

@RestController
@RequestMapping("/market-transactions")
public class MarketTransactionController {

	private final MarketTransactionService marketTransactionService;

	public MarketTransactionController(MarketTransactionService marketTransactionService) {
		this.marketTransactionService = marketTransactionService;
	}

	@PostMapping
	public MarketTransaction storeTransaction(@RequestBody MarketTransaction marketTransaction) {
		return marketTransactionService.save(marketTransaction);
	}

	@GetMapping
	public List<MarketTransaction> getAllTransactions() {
		return marketTransactionService.findAll();
	}

	@GetMapping("/order/{orderId}")
	public List<MarketTransaction> getTransactionsByOrderId(@PathVariable Integer orderId) {
		return marketTransactionService.findByOrderId(orderId);
	}
}
