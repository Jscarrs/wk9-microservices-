package com.lab.orders.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lab.orders.model.Order;
import com.lab.orders.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/page")
	public String showOrdersPage(Model model) {
		model.addAttribute("orders", orderService.getAllOrders());
		return "orders/index";
	}

	@PostMapping("/store")
	public String storeOrderFromPage(@RequestParam String accountId, @RequestParam String stockSymbol,
			@RequestParam BigDecimal price, @RequestParam int quantity, @RequestParam String orderType,
			RedirectAttributes redirectAttributes) {
		Order order = orderService.placeOrder(accountId, stockSymbol, price, quantity, orderType);
		redirectAttributes.addFlashAttribute("message", "Order stored successfully: " + order.getOrderId());
		return "redirect:/orders/page";
	}
}
