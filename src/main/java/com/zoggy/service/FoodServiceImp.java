package com.zoggy.service;

import com.zoggy.model.Food;
import com.zoggy.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class FoodServiceImp implements FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public void FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @Override
    public Food findFoodById(Long foodId) {
        // Use foodRepository to find Food by its ID
        Optional<Food> foodOptional = foodRepository.findById(foodId);

        // If Food exists, return it; otherwise, handle the case where it's not found
        return foodOptional.orElseThrow(() -> new RuntimeException("Food not found with id: " + foodId));
    }
}
