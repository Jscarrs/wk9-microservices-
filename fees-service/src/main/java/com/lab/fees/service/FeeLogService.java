package com.lab.fees.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lab.fees.model.FeeLog;
import com.lab.fees.repository.FeeLogRepository;

@Service
public class FeeLogService {

	private final FeeLogRepository feeLogRepository;

	public FeeLogService(FeeLogRepository feeLogRepository) {
		this.feeLogRepository = feeLogRepository;
	}

	public FeeLog save(FeeLog feeLog) {
		return feeLogRepository.save(feeLog);
	}

	public List<FeeLog> findAll() {
		return feeLogRepository.findAll();
	}

	public List<FeeLog> findByOrderId(Integer orderId) {
		return feeLogRepository.findByOrderId(orderId);
	}
}
