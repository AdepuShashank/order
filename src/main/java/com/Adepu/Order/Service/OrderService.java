package com.Adepu.Order.Service;


//import com.Adepu.ecom.Repository.OrderRepository;
//import com.Adepu.ecom.models.Order;

import com.Adepu.Order.Exceptions.OrderNotFoundException;
import com.Adepu.Order.Feign.ProductFeignClient;
import com.Adepu.Order.Feign.UserFeignClient;
import com.Adepu.Order.Repository.OrderRepository;
import com.Adepu.Order.model.Order;
import com.Adepu.Order.model.OrderStatus;
import com.Adepu.Order.model.Product;
import com.Adepu.Order.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

	@Autowired
	private UserFeignClient userFeignClient;
	@Autowired
	private ProductFeignClient productFeignClient;


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
	
	public Long CreateOrder(Long userId, List<Long> productIds) {
		User user = userFeignClient.getSingleUser(userId);

		List<Product> products = productIds.stream()
				.map(productFeignClient::getProduct)
				.collect(Collectors.toList());

		Double totalamount = products.stream()
				.mapToDouble(Product::getPrice)
				.sum();

		Order order = new Order();

//		Double totalamount = 0.0;
//		for(Product p : products) {
//			totalamount += p.getPrice();
//
//		}
		order.setUserId(user.getId());
		order.setProducts(productIds);
		order.setPrice(totalamount);
		order.setOrderstatus(OrderStatus.CREATED);

		Order savedOrder = orderRepository.save(order);

		return savedOrder.getId();
	}
}
