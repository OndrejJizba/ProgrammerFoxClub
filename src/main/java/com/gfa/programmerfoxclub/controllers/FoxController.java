package com.gfa.programmerfoxclub.controllers;

import com.gfa.programmerfoxclub.services.FoodAndDrinkService;
import com.gfa.programmerfoxclub.services.FoxService;
import com.gfa.programmerfoxclub.services.TrickService;
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

    private TrickService trickService;

    @Autowired
    public FoxController(FoodAndDrinkService foodAndDrinkService, FoxService foxService, TrickService trickService){
        this.foodAndDrinkService = foodAndDrinkService;
        this.foxService = foxService;
        this.trickService = trickService;
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
        String currentFox = foxService.getCurrentFox();
        return "redirect:/?name=" + currentFox;
    }

    @GetMapping("/trickCenter")
    public String getTrickCenter(Model model){
        model.addAttribute("trickList", trickService.getTrickList());
        model.addAttribute("listOfNotLearntTrick", trickService.getTrickList());
        return "tricks";
    }

    @PostMapping("/trickCenter")
    public String setTrick(@RequestParam String trick){
        trickService.addTrickToLearnt(trick);
        String currentFox = foxService.getCurrentFox();
        return "redirect:/?name=" + currentFox;
    }
}
