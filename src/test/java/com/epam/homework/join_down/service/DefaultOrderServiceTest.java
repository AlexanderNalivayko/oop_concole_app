package com.epam.homework.join_down.service;

import com.epam.homework.join_down.dao.OrderDao;
import com.epam.homework.join_down.model.Order;
import com.epam.homework.join_down.model.Tour;
import com.epam.homework.join_down.model.Transport;
import com.epam.homework.join_down.model.enums.TransportType;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class DefaultOrderServiceTest {

    private OrderService orderService;
    private String firstName;
    private String lastName;
    private String phone;
    private Tour tour;
    private int transportId;
    private boolean nutrition;
    private int days;

    @Before
    public void setUp() throws Exception {
        OrderDao orderDao = mock(OrderDao.class);
        when(orderDao.getNextId()).thenReturn(0);

        TransportService transportService = mock(TransportService.class);
        Transport transport = new Transport(0, TransportType.BUS, "", 100);
        when(transportService.getTransportById(anyInt())).thenReturn(transport);

        orderService = new DefaultOrderService(orderDao, transportService);
        firstName = "John";
        lastName = "Smith";
        phone = "000-00-00";
        tour = new Tour.Builder().withPricePerDay(100).build();
        transportId = 0;
        nutrition = false;
        days = 1;
    }

    @Test
    public void shouldReturnOrder() {
        Order expectedOrder = new Order(0, firstName, lastName, phone,
                tour, transportId, days, nutrition, 200);
        Order createdOrder = orderService.createOrder(firstName, lastName, phone, tour, transportId, nutrition, days);
        assertThat(createdOrder).isEqualTo(expectedOrder);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionOnNullInput() {
        orderService.createOrder(firstName, lastName, phone, null, transportId, nutrition, days);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionOnNegativeDays() {
        orderService.createOrder(firstName, lastName, phone, tour, transportId, nutrition, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnExceptionOnNegativeTransportId() {
        orderService.createOrder(firstName, lastName, phone, tour, -1, nutrition, days);
    }
}