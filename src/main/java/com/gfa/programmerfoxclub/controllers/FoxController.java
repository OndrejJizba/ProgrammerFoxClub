package com.gfa.programmerfoxclub.controllers;

import com.gfa.programmerfoxclub.services.FoodAndDrinkService;
import com.gfa.programmerfoxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxController {

    private FoodAndDrinkService foodAndDrinkService;
    private FoxService foxService;

    @Autowired
    public FoxController(FoodAndDrinkService foodAndDrinkService, FoxService foxService){
        this.foodAndDrinkService = foodAndDrinkService;
        this.foxService = foxService;
    }

    @GetMapping("/nutritionStore")
    public String getNutrition(Model model){
        model.addAttribute("foodList", foodAndDrinkService.getFoodList());
        model.addAttribute("drinkList", foodAndDrinkService.getDrinkList());
        return "nutrition";
    }

    @PostMapping("/nutritionStore")
    public String setNutrition(@RequestParam String food, @RequestParam String drink){
        foodAndDrinkService.setCurrentFood(food);
        foodAndDrinkService.setCurrentDrink(drink);
        return "redirect:/?food=" + food + "&drink=" + drink;
    }
}