package com.lab.fees.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lab.fees.model.FeeResponse;

@Service
public class FeeCalculatorService {

	// Mocked fee rules database
	private static final Map<String, Double> FEE_RULES = new HashMap<>();

	static {
		FEE_RULES.put("STANDARD", 0.01); // 1% fee
		FEE_RULES.put("PREMIUM", 0.005); // 0.5% fee
		FEE_RULES.put("BASIC", 0.02); // 2% fee
	}

	public FeeResponse calculateFee(String stockSymbol, int quantity, String feeType) {
		double rate = FEE_RULES.getOrDefault(feeType.toUpperCase(), 0.01);
		double totalFee = quantity * rate;
		return new FeeResponse(stockSymbol, quantity, rate, totalFee, feeType);
	}

	public Map<String, Double> getAllFeeRules() {
		return FEE_RULES;
	}
}
