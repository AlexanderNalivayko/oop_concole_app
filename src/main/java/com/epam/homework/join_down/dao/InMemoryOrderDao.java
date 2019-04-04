package com.epam.homework.join_down.dao;

import com.epam.homework.join_down.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryOrderDao implements OrderDao {

    private static HashMap<Integer, Order> orders = new HashMap<>();
    private static int counter = 0;

    @Override
    public synchronized void add(Order order) {
        orders.put(counter++, order);
    }

    @Override
    public Order getById(int id) {
        return orders.get(id);
    }

    @Override
    public List<Order> getAllOrder() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public synchronized void delete(Order order) {
        orders.remove(order.getId());
    }

    @Override
    public synchronized int getNextId() {
        return counter++;
    }
}
