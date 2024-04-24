package com.zoggy.response;

import com.zoggy.model.CartItem;
import com.zoggy.model.Food;

import java.util.ArrayList;
import java.util.List;

public class cartItemResponse {
    private Long cartId;
    private List<CartItem> cartItems;
    private List<Food> foods;

    public cartItemResponse() {
        cartItems = new ArrayList<>();
        foods = new ArrayList<>();
    }

    // Method to push a CartItem to the cartItems list
    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    // Method to push a Food to the foods list
    public void addFood(Food food) {
        foods.add(food);
    }

    // Getters and Setters for cartItemId, cartItems, and foods
    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
