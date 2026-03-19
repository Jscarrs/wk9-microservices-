package com.lab.fees.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab.fees.model.FeeLog;
import com.lab.fees.model.FeeResponse;
import com.lab.fees.service.FeeCalculatorService;
import com.lab.fees.service.FeeLogService;

@RestController
@RequestMapping("/fees")
public class FeeController {

	@Autowired
	private FeeCalculatorService feeCalculatorService;

	@Autowired
	private FeeLogService feeLogService;

	// Operation 1: Calculate fee for an order
	@GetMapping("/calculate")
	public FeeResponse calculateFee(@RequestParam String stockSymbol, @RequestParam int quantity,
			@RequestParam(defaultValue = "STANDARD") String feeType) {
		return feeCalculatorService.calculateFee(stockSymbol, quantity, feeType);
	}

	// Operation 2: Get all available fee rules
	@GetMapping("/rules")
	public Map<String, Double> getFeeRules() {
		return feeCalculatorService.getAllFeeRules();
	}

	@PostMapping("/logs")
	public FeeLog createFeeLog(@RequestBody FeeLog feeLog) {
		return feeLogService.save(feeLog);
	}

	@GetMapping("/logs")
	public List<FeeLog> getAllFeeLogs() {
		return feeLogService.findAll();
	}

	@GetMapping("/logs/order/{orderId}")
	public List<FeeLog> getFeeLogsByOrderId(@PathVariable Integer orderId) {
		return feeLogService.findByOrderId(orderId);
	}
}
