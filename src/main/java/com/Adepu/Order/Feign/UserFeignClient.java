package com.Adepu.Order.Feign;

import com.Adepu.Order.DTO.ProductDTO;
import com.Adepu.Order.model.User;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient("PRODUCT")
//public interface OrderInterface {
//    @GetMapping("/product/{id}")
//    public ProductDTO GetProduct(@PathVariable("id") Long id);
//
//}

@FeignClient("USER")

public interface UserFeignClient {
    @GetMapping("/user/{id}")
    public User getSingleUser(@PathVariable("id") long id);
}
