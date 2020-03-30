package com.example.foodmood;

import java.util.ArrayList;

public class Food {
    private String name;
    private String cuisine;
    private String location;
    private String price;
    private String dish;
    private double rating;
    private int photo;

    //Constructor for food attributes

    public Food(String name, String cuisine, String location, String price, String dish, double rating, int photo) {
        this.name = name;
        this.cuisine = cuisine;
        this.location = location;
        this.price = price;
        this.dish = dish;
        this.rating = rating;
        this.photo = photo;
    }

    //getters and setters for food attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo){
        this.photo = photo;
    }

    //method used to return the restaurant object that is clicked on

    public static Food getFood(String id) {
        for(Food food : getFood()) {
            if(food.getName().equals(id)) {
                return food;
            }
        }
        return null;
    }

    //toString method that returns name of restaurant

    @Override
    public String toString() {
        return name;
    }

    //getFood method returns array list of food objects which contain the restaurants and their info

    public static ArrayList<Food> getFood() {
        ArrayList<Food> food = new ArrayList<>();
        food.add(new Food("Chin Chin", "Asian Fusion", "Surry Hills", "$$$", "Kingfish Sashimi", 9.8, R.drawable.chinchin));
        food.add(new Food("Sake", "Contemporary Japanese", "The Rocks", "$$$", "Popcorn Shrimp", 9.7, R.drawable.sake));
        food.add(new Food("Filicudi", "Italian", "Five Dock", "$", "Seafood Marinara", 9.4, R.drawable.filicudi));
        food.add(new Food("A Thousand Spices", "Indian", "Homebush", "$", "Butter Chicken", 9.2, R.drawable.spices));
        food.add(new Food("Won Jo", "Korean", "Strathfield", "$", "Seafood Hotpot", 8.8, R.drawable.wonjo));
        food.add(new Food("Ippudo", "Japanese", "Sydney CBD", "$$", "Shiromaru Ramen", 8.7, R.drawable.ippudo));
        food.add(new Food("China Doll", "Modern Asian", "Woolloomooloo", "$$$", "Crispy Dumplings", 8.5, R.drawable.china));
        food.add(new Food("El Jannah", "Lebanese", "Kogarah", "$", "Charcoal Chicken", 8.4, R.drawable.jannah));
        food.add(new Food("Cho Cho San", "Modern Japanese", "Potts Point", "$$$", "Scallop Sashimi", 8.3, R.drawable.cho));
        food.add(new Food("Contrabando", "Mexican", "Sydney CBD", "$$", "Fish Tacos", 8.1, R.drawable.bando));

        return food;
    }
}

