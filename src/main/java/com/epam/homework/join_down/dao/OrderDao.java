package com.epam.homework.join_down.dao;

import com.epam.homework.join_down.model.Order;

import java.util.List;

public interface OrderDao {

    void add(Order order);

    Order getById(int id);

    List<Order> getAllOrder();

    void delete(Order order);

    int getNextId();
}
