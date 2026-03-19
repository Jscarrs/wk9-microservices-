package com.ae.week9.microservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ae.week9.microservices.model.AccountTransaction;
import com.ae.week9.microservices.service.AccountTransactionService;

@RestController
@RequestMapping("/account-transactions")
public class AccountTransactionController {

	private final AccountTransactionService accountTransactionService;

	public AccountTransactionController(AccountTransactionService accountTransactionService) {
		this.accountTransactionService = accountTransactionService;
	}

	@PostMapping
	public AccountTransaction storeTransaction(@RequestBody AccountTransaction accountTransaction) {
		return accountTransactionService.save(accountTransaction);
	}

	@GetMapping
	public List<AccountTransaction> getAllTransactions() {
		return accountTransactionService.findAll();
	}

	@GetMapping("/order/{orderId}")
	public List<AccountTransaction> getTransactionsByOrderId(@PathVariable Integer orderId) {
		return accountTransactionService.findByOrderId(orderId);
	}
}
