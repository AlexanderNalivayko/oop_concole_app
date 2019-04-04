package com.epam.homework.join_down;

import com.epam.homework.join_down.dao.*;
import com.epam.homework.join_down.service.*;
import com.epam.homework.join_down.ui.ConsoleController;
import com.epam.homework.join_down.ui.ConsoleViewWithFileProvidedMsgs;
import com.epam.homework.join_down.ui.View;

public class Runner {
    public static void main(String[] args) {

        View view = new ConsoleViewWithFileProvidedMsgs();

        TourDao tourDao = new InMemoryTourDao();
        TourService tourService = new DefaultTourService(tourDao);

        TransportDao transportDao = new InMemoryTransportDao();
        TransportService transportService = new DefaultTransportService(transportDao);

        OrderDao orderDao = new InMemoryOrderDao();
        OrderService orderService = new DefaultOrderService(orderDao, transportService);

        ConsoleController consoleController = new ConsoleController(view, tourService, orderService, transportService);

        consoleController.runUserInterface();
    }
}
