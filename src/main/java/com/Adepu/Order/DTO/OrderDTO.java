package com.Adepu.Order.DTO;

import java.util.List;

public class OrderDTO {
    private Long userId;
    private List<Long> productIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public List<Long> getProductIds() {
        return productIds;
    }
    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
