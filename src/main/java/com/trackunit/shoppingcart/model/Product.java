package com.trackunit.shoppingcart.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private String name;
    private String shortDescription;
    private String longDescription;
    private BigDecimal price;
}
