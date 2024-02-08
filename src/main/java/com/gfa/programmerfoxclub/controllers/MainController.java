package com.gfa.programmerfoxclub.controllers;

import com.gfa.programmerfoxclub.models.Food;
import com.gfa.programmerfoxclub.models.Fox;
import com.gfa.programmerfoxclub.services.FoodAndDrinkService;
import com.gfa.programmerfoxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private FoxService foxService;
    private FoodAndDrinkService foodAndDrinkService;

    @Autowired
    public MainController(FoxService foxService, FoodAndDrinkService foodAndDrinkService) {
        this.foxService = foxService;
        this.foodAndDrinkService = foodAndDrinkService;
    }

    @GetMapping("/")
    public String getMainPage(@RequestParam (required = false) String name, @RequestParam (required = false) String food, @RequestParam (required = false) String drink, Model model){
        model.addAttribute("foxName", foxService.getCurrentFox());
        model.addAttribute("food", foodAndDrinkService.getCurrentFood());
        model.addAttribute("drink", foodAndDrinkService.getCurrentDrink());
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String name){
        foxService.setCurrentFox(name);
        return "redirect:/?name=" + name;
    }
}
