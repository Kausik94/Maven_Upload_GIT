package com.los.service;

import com.los.data.access.OrderDao;
import com.los.entity.FoodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<FoodOrder> getAllOrders() {
        return orderDao.getAllOrders();
    }


    public void addOrder(FoodOrder foodOrder) {
        orderDao.addOrder(foodOrder);
    }

    public void deleteOrder(int orderId) {
        orderDao.deleteOrder(orderId);
    }
    public void updateOrder(FoodOrder foodOrder) {
        orderDao.updateOrder(foodOrder);
    }


    public FoodOrder getOrderById(int orderId) {
        return orderDao.getOrderById(orderId);
    }

    public List<FoodOrder> getOrderByUserId(int userId) {
        return orderDao.getOrderByUserId(userId);
    }

    public List<FoodOrder> getOrderByProviderId(int providerId) {
        return orderDao.getOrderByPoviderId(providerId);
    }

    public List<FoodOrder> getOrderByDate(String date) {
        return orderDao.getOrderByDate(date);
    }

}
