package com.Adepu.Order.Controller;


import com.Adepu.Order.Service.OrderService;
import com.Adepu.Order.model.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
	
	OrderService OrderService;
	public OrderController(OrderService OrderService) {
		this.OrderService = OrderService;
	}
	
	
	@GetMapping("/order/{id}")
	public Order GetSingleOrder(@PathVariable("id") long id) {
		Order SingleOrder;
		SingleOrder = OrderService.GetSingleOrder(id);
		return SingleOrder;  
	}
	
	@GetMapping("/order")
	public List<Order> GetAllOrders(){
		List<Order> allorders = OrderService.GetAllOrders();
		return allorders;
	}
	@PostMapping("/order")
	public Long CreateOrder(@RequestBody Order order) {
		return OrderService.CreateOrder(order.getUser(),order.getProducts());
	}
}
