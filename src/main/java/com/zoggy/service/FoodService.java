package com.zoggy.service;

import com.zoggy.model.Category;
import com.zoggy.model.Food;
import com.zoggy.model.Restaurant;
import com.zoggy.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public List<Food> getAllFood();

    public Food findFoodById(Long foodId)throws Exception;
}
