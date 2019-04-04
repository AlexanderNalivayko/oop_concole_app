package com.epam.homework.join_down.dao;

import com.epam.homework.join_down.model.Order;

import java.util.List;

public interface OrderDao {

    public void add(Order order);

    public Order getById(int id);

    public List<Order> getAllOrder();

    public void delete(Order order);

    public int getNextId();
}
