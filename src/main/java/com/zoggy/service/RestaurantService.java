package com.zoggy.service;

import com.zoggy.dto.RestaurantDto;
import com.zoggy.model.Restaurant;
import com.zoggy.model.User;
import com.zoggy.request.CreateRestaurantRequest;

import java.util.List;


public interface RestaurantService {
    public Restaurant createRestaurant(CreateRestaurantRequest req, User user);

    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws Exception;

    public void deleteRestaurant(Long restaurantId) throws Exception;

    public List<Restaurant> getAllRestaurant();

    public List<Restaurant> searchRestaurant(String keyword);

    public Restaurant findRestaurantById(Long Id) throws Exception;

    public Restaurant getRestaurantByUserId(Long userId) throws Exception;

    public RestaurantDto addToFavorites(Long restaurant, User user) throws Exception;

    public Restaurant updateRestaurantStatus(Long id) throws Exception;
}
