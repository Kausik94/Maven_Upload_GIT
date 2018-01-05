package com.los.service;

import com.los.data.access.MealDao;
import com.los.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Autowired
    MealDao mealDao;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Meal> getAllMeals() {
        return mealDao.getAllMeals();
    }


    public void addmeal(Meal meal) {
        mealDao.addMeal(meal);
    }

    public void deleteMeal(int mealId) {
        mealDao.deleteMeal(mealId);
    }
    public void updateMeal(Meal meal) {
        mealDao.updateMeal(meal);
    }


    public Meal getMealById(int mealId) {
        return mealDao.getMealById(mealId);
    }

//    public List<FoodOrder> getOrderByUserId(int userId) {
//        return orderDao.getOrderByUserId(userId);
//    }
//
//    public List<FoodOrder> getOrderByProviderId(int providerId) {
//        return orderDao.getOrderByPoviderId(providerId);
//    }
//
//    public List<FoodOrder> getOrderByDate(String date) {
//        return orderDao.getOrderByDate(date);
//    }

}
