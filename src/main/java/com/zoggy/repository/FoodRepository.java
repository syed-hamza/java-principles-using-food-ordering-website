package com.zoggy.repository;

import com.zoggy.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {

    List<Food> findByRestaurantId(Long restaurantId);

    List<Food> findAll();

    List<Food> searchFoodByRestaurantId(Long restaurantId);

}
