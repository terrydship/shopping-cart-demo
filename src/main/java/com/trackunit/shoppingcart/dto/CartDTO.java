package com.trackunit.shoppingcart.dto;

import lombok.Data;

@Data
public class CartDTO {
    private Long productId;
    private Integer quantity;
}
