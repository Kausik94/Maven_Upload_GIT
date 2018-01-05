package com.los.data.access;

import com.los.entity.Meal;

import java.util.List;

public interface MealDao {

    void updateMeal(Meal meal);
    //
    public  void addMeal(Meal meal);

    List<Meal> getAllMeals();

    Meal getMealById(int mealId);

    void deleteMeal(int mealId);



}
