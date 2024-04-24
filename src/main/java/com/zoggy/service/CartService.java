package com.zoggy.service;

import com.zoggy.model.Cart;
import com.zoggy.model.CartItem;
import com.zoggy.request.AddCartItemRequest;

public interface CartService {
    public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception;

    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws Exception;

    public Cart removeItemFromCart(Long cartItemId, String jwt)throws Exception;

    public double calculateCartTotals(Cart cart);

    public Cart findCartById(Long id) throws Exception;

    public Cart findCartByUserId(Long userId);

    public String deleteCartItem(Long id);

    public Cart clearCart(Long userId)throws Exception;

}