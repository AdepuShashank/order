package com.Adepu.Order.Repository;


import com.Adepu.Order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
