package com.gfa.programmerfoxclub.repositories;

import com.gfa.programmerfoxclub.models.Drink;
import com.gfa.programmerfoxclub.models.Food;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodAndDrinkRepository {
    private List<Food> foodList;
    private List<Drink> drinkList;

    public FoodAndDrinkRepository() {
        this.foodList = new ArrayList<>();
        this.drinkList = new ArrayList<>();
        foodList.add(new Food("carrot"));
        foodList.add(new Food("potato"));
        foodList.add(new Food("cucumber"));
        drinkList.add(new Drink("cola"));
        drinkList.add(new Drink("water"));
        drinkList.add(new Drink("beer"));
    }

    public List<Food> getFoodList(){
        return foodList;
    }

    public List<Drink> getDrinkList(){
        return drinkList;
    }
}
