package com.trackunit.shoppingcart.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private Long id;
    private Long userId;
    private List<CartItem> cartItemList = new ArrayList<>();
    private BigDecimal total;

    public BigDecimal getTotal() {
        return cartItemList.stream()
                .map(CartItem::getSubTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
