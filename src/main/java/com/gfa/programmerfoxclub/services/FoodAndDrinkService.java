package com.gfa.programmerfoxclub.services;

import com.gfa.programmerfoxclub.models.Drink;
import com.gfa.programmerfoxclub.models.Food;
import com.gfa.programmerfoxclub.models.Fox;
import com.gfa.programmerfoxclub.repositories.FoodAndDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodAndDrinkService {

    private final FoodAndDrinkRepository foodAndDrinkRepository;
    private Food currentFood;
    private Drink currentDrink;
    private Map<String, String> foxFoodMap = new HashMap<>();
    private FoxService foxService;

    @Autowired
    public FoodAndDrinkService(FoodAndDrinkRepository foodAndDrinkRepository) {
        this.foodAndDrinkRepository = foodAndDrinkRepository;
    }

    public List<Food> getFoodList() {
        return foodAndDrinkRepository.getFoodList();
    }

    public List<Drink> getDrinkList() {
        return foodAndDrinkRepository.getDrinkList();
    }

    public void setCurrentFood(String food) {
        currentFood = new Food(food);
    }

    public String getCurrentFood() {
        if (currentFood == null) return new Food("carrot").getFoodName();
        else return currentFood.getFoodName();
    }

    public void setCurrentDrink(String drink) {
        currentDrink = new Drink(drink);
    }

    public String getCurrentDrink() {
        if (currentDrink == null) return new Drink("cola").getDrinkName();
        else return currentDrink.getDrinkName();
    }

    public String findFoodByFoxName(String name, String food) {
        if (!foxFoodMap.containsKey(name)) {
            foxFoodMap.put(name, food);
            return foxFoodMap.get(name);
        } else {
            return foxFoodMap.get(name);
        }
    }
}
