package com.epam.homework.join_down.service;

import com.epam.homework.join_down.model.Order;
import com.epam.homework.join_down.model.Tour;

import java.util.List;

public interface OrderService {

    void registerNewOrder(Order order);

    Order createOrder(String firstName, String LastName, String phone, Tour tour,
                             int transportId, boolean nutrition, int days);

    List<Order> getAllOrders();
}
