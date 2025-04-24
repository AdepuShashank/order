package com.Adepu.Order.Service;


//import com.Adepu.ecom.Repository.OrderRepository;
//import com.Adepu.ecom.models.Order;

import com.Adepu.Order.Exceptions.OrderNotFoundException;
import com.Adepu.Order.Repository.OrderRepository;
import com.Adepu.Order.model.Order;
import com.Adepu.Order.model.OrderStatus;
import com.Adepu.Order.model.Product;
import com.Adepu.Order.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
	OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;

	}
	
	public Order GetSingleOrder(long id) throws OrderNotFoundException {
		Optional<Order> GetASingleOrderById;
		GetASingleOrderById = orderRepository.findById(id);
		
		Order od;
		
		if(GetASingleOrderById.isEmpty()) {
			throw new OrderNotFoundException("No orders are found");
		}
		else {
			od = GetASingleOrderById.get();
		}
			
		return od;
		
	}
	
	public List<Order> GetAllOrders() {
		List<Order> allorders = orderRepository.findAll();
		
		return allorders;
	}
	
	public Long CreateOrder(User user, List<Product> products) {
		Order order = new Order();

		Double totalamount = 0.0;
		for(Product p : products) {
			totalamount += p.getPrice();

		}
		order.setUser(user);
		order.setProducts(products);
		order.setPrice(totalamount);
		order.setOrderstatus(OrderStatus.CREATED);

		Order savedOrder = orderRepository.save(order);

		return savedOrder.getId();
	}
}
