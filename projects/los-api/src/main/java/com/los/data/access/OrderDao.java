package com.los.data.access;

import com.los.entity.FoodOrder;



import java.util.List;

public interface OrderDao {

    void updateOrder(FoodOrder foodOrder);
//
    public  void addOrder(FoodOrder foodOrder);

    List<FoodOrder> getAllOrders();

    FoodOrder getOrderById(int orderId);

    void deleteOrder(int orderId);

    List<FoodOrder> getOrderByUserId(int userId);

    List<FoodOrder> getOrderByPoviderId(int providerId);

    List<FoodOrder> getOrderByDate(String date);

//    FoodOrder getOrderByUserId(int userId);
//
//    FoodOrder getOrderByOrderId(int orderId);
}

