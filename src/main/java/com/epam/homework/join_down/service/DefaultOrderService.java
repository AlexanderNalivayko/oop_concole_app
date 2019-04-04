package com.epam.homework.join_down.service;

import com.epam.homework.join_down.dao.OrderDao;
import com.epam.homework.join_down.model.Order;
import com.epam.homework.join_down.model.Tour;

import java.util.List;

public class DefaultOrderService implements OrderService {

    private OrderDao orderDao;
    private TransportService transportService;

    public DefaultOrderService(OrderDao orderDao, TransportService transportService) {
        this.transportService = transportService;
        this.orderDao = orderDao;
    }

    @Override
    public void registerNewOrder(Order order) {
        orderDao.add(order);
    }

    @Override
    public Order createOrder(String firstName, String lastName, String phone, Tour tour,
                             int transportId, boolean nutrition, int days) {
        if (tour == null || transportId < 0 || days < 0) {
            throw new IllegalArgumentException("Can not create Order with such parameters");
        }
        int total = countTotalPrice(tour, transportId, nutrition, days);
        return new Order(orderDao.getNextId(), firstName, lastName, phone, tour, transportId, days, nutrition, total);
    }

    private int countTotalPrice(Tour tour, int transportId, boolean nutrition, int days) {
        int total = (nutrition ? tour.getPricePerDayWithNutrition() : tour.getPricePerDay()) * days;
        total += transportService.getTransportById(transportId).getPrice();
        return total;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrder();
    }
}
