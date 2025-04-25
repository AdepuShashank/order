package com.Adepu.Order.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="\"Order\"")
public class Order extends BaseModel {
	private Long userId;


	private Double price;
	private OrderStatus orderstatus;

	@ElementCollection
	private List<Long> products;


	public Order(Long userId, Double price,OrderStatus orderstatus, List<Product> productIds) {
		this.userId = userId;
		this.price = price;
		this.orderstatus = orderstatus;
		this.products = products;
	}

	public Order() {

	}


	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public OrderStatus getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus;
	}

	public List<Long> getProducts() {
		return products;
	}

	public void setProducts(List<Long> products) {
		this.products = products;
	}

}
