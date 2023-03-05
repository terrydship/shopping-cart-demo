package com.trackunit.shoppingcart;

import com.trackunit.shoppingcart.controller.ShoppingCartController;
import com.trackunit.shoppingcart.model.Cart;
import com.trackunit.shoppingcart.model.CartItem;
import com.trackunit.shoppingcart.model.Product;
import com.trackunit.shoppingcart.service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * @author Terry Deng
 */

@SpringBootTest
class ShoppingCartControllerTest {

    @Mock
    private ShoppingCartService shoppingCartService;

    @InjectMocks
    private ShoppingCartController shoppingCartController;

    @Test
    public void testGetCartItems() {
        Cart mockCart = new Cart();
        List<CartItem> cartItemList = new ArrayList<>();

        Product product_1 = new Product();
        product_1.setName("Pen");
        product_1.setPrice(BigDecimal.TEN);

        CartItem cartItem_1 = new CartItem();
        cartItem_1.setProduct(product_1);
        cartItem_1.setQuantity(10);

        Product product_2 = new Product();
        product_2.setName("Ink");
        product_2.setPrice(BigDecimal.ONE);

        CartItem cartItem_2 = new CartItem();
        cartItem_2.setProduct(product_2);
        cartItem_2.setQuantity(5);

        cartItemList.add(cartItem_1);
        cartItemList.add(cartItem_2);
        mockCart.setCartItemList(cartItemList);

        when(shoppingCartService.getCartItems(anyString())).thenReturn(mockCart);

        Cart cart = shoppingCartController.getCart(anyString());
        verify(shoppingCartService, times(1)).getCartItems(anyString());
        assertEquals(2, cart.getCartItemList().size());
        assertEquals(BigDecimal.valueOf(105), cart.getTotal());
    }

    @Test
    public void testAddItemToCart() {
        Cart mockCart = new Cart();
        List<CartItem> cartItemList = new ArrayList<>();

        Product product = new Product();
        product.setName("Pen");
        product.setPrice(BigDecimal.TEN);

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(5);

        cartItemList.add(cartItem);
        mockCart.setCartItemList(cartItemList);

        when(shoppingCartService.addItemToCart(anyString(), any())).thenReturn(mockCart);

        Cart cart = shoppingCartController.addItemToCart(anyString(), any());
        verify(shoppingCartService, times(1)).addItemToCart(anyString(), any());
        assertEquals(BigDecimal.valueOf(50), cart.getTotal());
    }

}
