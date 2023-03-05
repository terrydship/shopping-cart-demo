package com.trackunit.shoppingcart.controller;

import com.trackunit.shoppingcart.dto.CartDTO;
import com.trackunit.shoppingcart.model.Cart;
import com.trackunit.shoppingcart.service.ShoppingCartService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Terry Deng
 */

@RestController
@AllArgsConstructor
@RequestMapping("/cart-management")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @ApiOperation("Get shopping cart info for a given user.")
    @GetMapping("users/{userId}/cart")
    public Cart getCart(@PathVariable String userId) {
        return shoppingCartService.getCartItems(userId);
    }

    @ApiOperation("Add item to shopping cart for a given user.")
    @PostMapping("users/{userId}/cart")
    public Cart addItemToCart(@PathVariable String userId, @RequestBody CartDTO cartDTO) {
        return shoppingCartService.addItemToCart(userId, cartDTO);
    }

    @ApiOperation("Update shopping cart for a given user and the item.")
    @PutMapping("users/{userId}/cart/{itemId}")
    public Cart updateCartItem(@PathVariable String userId, @PathVariable String itemId, @RequestBody CartDTO cartDTO) {
        return shoppingCartService.updateCartItem(userId, itemId, cartDTO);
    }

    @ApiOperation("Delete the shopping cart item for a given user.")
    @DeleteMapping("users/{userId}/cart/{itemId}")
    public boolean deleteCartItem(@PathVariable String userId, @PathVariable String itemId) {
        return shoppingCartService.deleteCartItem(userId, itemId);
    }
}
