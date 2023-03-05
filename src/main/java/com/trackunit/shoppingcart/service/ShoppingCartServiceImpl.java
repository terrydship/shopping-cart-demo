package com.trackunit.shoppingcart.service;

import com.trackunit.shoppingcart.dto.CartDTO;
import com.trackunit.shoppingcart.model.Cart;
import org.springframework.stereotype.Service;

/**
 * @author Terry Deng
 */

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Override
    public Cart getCartItems(String userId) {
        return new Cart();
    }

    @Override
    public Cart addItemToCart(String userId, CartDTO cartDTO) {
        return new Cart();
    }

    @Override
    public Cart updateCartItem(String userId, String itemId, CartDTO cartDTO) {
        return new Cart();
    }

    @Override
    public boolean deleteCartItem(String userId, String itemId) {
        return true;
    }
}
