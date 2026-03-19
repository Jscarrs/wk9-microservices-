package com.ae.week9.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ae.week9.microservices.model.AccountTransaction;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
	List<AccountTransaction> findByOrderId(Integer orderId);
}
