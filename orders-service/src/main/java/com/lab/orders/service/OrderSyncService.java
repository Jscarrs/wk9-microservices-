package com.lab.orders.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lab.orders.model.Order;

@Service
public class OrderSyncService {

	private final RestTemplate restTemplate = new RestTemplate();

	public void syncOrder(Order order) {
		postAccountTransaction(order);
		postFeeLog(order);
		postMarketTransaction(order);
	}

	private void postAccountTransaction(Order order) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("orderId", order.getOrderId());
		body.put("transactionDate", order.getOrderDate());
		body.put("stockQuote", order.getStockSymbol());
		body.put("price", order.getPrice());
		body.put("quantity", order.getQuantity());
		body.put("accountNumber", order.getAccountId());
		post("http://localhost:8082/account-transactions", body);
	}

	private void postFeeLog(Order order) {
		BigDecimal feeAmount = order.getPrice().multiply(BigDecimal.valueOf(order.getQuantity()))
				.multiply(BigDecimal.valueOf(0.01)).setScale(2, RoundingMode.HALF_UP);

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("orderId", order.getOrderId());
		body.put("feeDate", order.getOrderDate());
		body.put("feeAmount", feeAmount);
		body.put("totalFees", feeAmount);
		body.put("feeType", "STANDARD");
		body.put("customerId", order.getAccountId());
		post("http://localhost:8083/fees/logs", body);
	}

	private void postMarketTransaction(Order order) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("orderId", order.getOrderId());
		body.put("transactionDate", order.getOrderDate());
		body.put("stockQuote", order.getStockSymbol());
		body.put("price", order.getPrice());
		body.put("quantity", order.getQuantity());
		body.put("marketName", "NASDAQ");
		body.put("status", "PLACED");
		post("http://localhost:8084/market-transactions", body);
	}

	private void post(String url, Map<String, Object> body) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			restTemplate.postForEntity(url, new HttpEntity<>(body, headers), String.class);
		} catch (Exception exception) {
			System.out.println("Sync failed for " + url + ": " + exception.getMessage());
		}
	}
}
