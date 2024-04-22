package com.zoggy.controller;

import com.zoggy.model.Address;
import com.zoggy.model.Food;
import com.zoggy.model.Restaurant;
import com.zoggy.model.User;
import com.zoggy.request.CreateFoodRequest;
import com.zoggy.service.FoodService;
import com.zoggy.service.RestaurantService;
import com.zoggy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/get-food")
    public ResponseEntity<?> getAllFood(@RequestHeader("Authorization") String jwt) {
        User user = userService.findUserByJwtToken(jwt);
        if(user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        List<Food> foods = foodService.getAllFood();
        return ResponseEntity.ok().body(foods);
    }

}
