package com.ae.week9.microservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ae.week9.microservices.model.AccountTransaction;
import com.ae.week9.microservices.repository.AccountTransactionRepository;

@Service
public class AccountTransactionService {

	private final AccountTransactionRepository accountTransactionRepository;

	public AccountTransactionService(AccountTransactionRepository accountTransactionRepository) {
		this.accountTransactionRepository = accountTransactionRepository;
	}

	public AccountTransaction save(AccountTransaction accountTransaction) {
		return accountTransactionRepository.save(accountTransaction);
	}

	public List<AccountTransaction> findAll() {
		return accountTransactionRepository.findAll();
	}

	public List<AccountTransaction> findByOrderId(Integer orderId) {
		return accountTransactionRepository.findByOrderId(orderId);
	}
}
