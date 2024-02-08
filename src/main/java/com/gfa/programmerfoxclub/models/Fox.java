package com.gfa.programmerfoxclub.models;

import java.util.ArrayList;
import java.util.List;

public class Fox {
    private String name;
    private List<Trick> listOfTricks;
    private Food food;
    private Drink drink;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Fox(String name) {
        this.name = name;
        this.listOfTricks = new ArrayList<>();
        this.food = new Food("Food");
        this.drink = new Drink("Drink");
    }

    public Fox() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
