package com.Adepu.Order.Feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("PRODUCT")
public interface OrderInterface {
}
