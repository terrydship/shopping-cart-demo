package com.trackunit.shoppingcart.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItem {
    private Long id;
    private Product product;
    private Integer quantity;
    private BigDecimal subTotal;

    public BigDecimal getSubTotal() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}