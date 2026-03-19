package com.lab.fees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.fees.model.FeeLog;

public interface FeeLogRepository extends JpaRepository<FeeLog, Long> {
	List<FeeLog> findByOrderId(Integer orderId);
}
