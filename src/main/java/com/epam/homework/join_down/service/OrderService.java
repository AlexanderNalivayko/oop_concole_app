package com.epam.homework.join_down.service;

import com.epam.homework.join_down.model.Order;
import com.epam.homework.join_down.model.Tour;

import java.util.List;

public interface OrderService {

    public void registerNewOrder(Order order);

    public Order createOrder(String firstName, String LastName, String phone, Tour tour,
                             int transportId, boolean nutrition, int days);

    public List<Order> getAllOrders();

}
