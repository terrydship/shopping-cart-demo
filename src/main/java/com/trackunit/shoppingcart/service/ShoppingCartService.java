package com.trackunit.shoppingcart.service;

import com.trackunit.shoppingcart.dto.CartDTO;
import com.trackunit.shoppingcart.model.Cart;

/**
 * @author Terry Deng
 */

public interface ShoppingCartService {
    Cart getCart(String userId);
    Cart addItemToCart(String userId, CartDTO cartDTO);
    Cart updateCartItem(String userId, String itemId, CartDTO cartDTO);
    boolean deleteCartItem(String userId, String itemId);
}
