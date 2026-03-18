package com.lab.fees.controller;

import com.lab.fees.model.FeeResponse;
import com.lab.fees.service.FeeCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/fees")
public class FeeController {

    @Autowired
    private FeeCalculatorService feeCalculatorService;

    // Operation 1: Calculate fee for an order
    @GetMapping("/calculate")
    public FeeResponse calculateFee(@RequestParam String stockSymbol,
                                    @RequestParam int quantity,
                                    @RequestParam(defaultValue = "STANDARD") String feeType) {
        return feeCalculatorService.calculateFee(stockSymbol, quantity, feeType);
    }

    // Operation 2: Get all available fee rules
    @GetMapping("/rules")
    public Map<String, Double> getFeeRules() {
        return feeCalculatorService.getAllFeeRules();
    }
}
