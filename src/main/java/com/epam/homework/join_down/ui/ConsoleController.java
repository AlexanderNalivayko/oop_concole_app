package com.epam.homework.join_down.ui;

import com.epam.homework.join_down.model.Order;
import com.epam.homework.join_down.model.Tour;
import com.epam.homework.join_down.model.Transport;
import com.epam.homework.join_down.service.OrderService;
import com.epam.homework.join_down.service.TourService;
import com.epam.homework.join_down.service.TransportService;
import com.epam.homework.join_down.util.ParserUtil;

import java.util.List;


public class ConsoleController {

    private static final String ANSWER_ONE = "1";
    private static final String ANSWER_TWO = "2";
    private static final String ANSWER_THREE = "3";
    private static final String ANSWER_FOUR = "4";
    private static final String ANSWER_FIVE = "5";

    private static final String TRANSPORT_FORMAT = "%d.%s, company: %s, price %s";

    private View view;
    private TourService tourService;
    private OrderService orderService;
    private TransportService transportService;

    public ConsoleController(View view,
                             TourService tourService,
                             OrderService orderService,
                             TransportService transportService) {
        this.view = view;
        this.tourService = tourService;
        this.orderService = orderService;
        this.transportService = transportService;
    }

    public void runUserInterface() {
        view.showGreeting();
        rootDialogue();
    }

    private void rootDialogue() {
        view.showAvailableOptions();
        readRootResponse();
    }

    private void listTours(List<Tour> tours) {
        view.showTours(tours);
        rootDialogue();
    }

    private void sortingDialogue() {
        view.showSortingDialogue();
        readSortResponse();
    }

    private void orderDialogue() {
        view.showOrderDialogue();
        try {
            Tour tour = tourService.getTourById(Integer.parseInt(view.getIdFromUser()));

            Integer[] transportIds = ParserUtil.parseStringToIntArray(tour.getTransports());
            showAvailableTransport(transportIds);
            int transportId = transportIds[Integer.parseInt(view.getTransportFromUser()) - 1];

            showAvailableNutrition();
            String nutrition = view.getNutritionFromUser();

            int days = Integer.parseInt(view.getDaysFromUser());

            String firstName = view.getFirstNameFromUser();
            String lastName = view.getLastNameFromUser();
            String phone = view.gePhoneFromUser();

            Order order = orderService.createOrder(firstName, lastName, phone, tour,
                    transportId, (nutrition.equals("1")), days);
            orderService.registerNewOrder(order);
            view.showOrderRegisteredMsg();
            rootDialogue();
        } catch (NumberFormatException | NullPointerException e) {
            wrongInput();
        }
    }

    private void readRootResponse() {
        String userAnswer = view.getUserAnswer();
        switch (userAnswer) {
            case ANSWER_ONE:
                listTours(tourService.getAllTours());
                break;

            case ANSWER_TWO:
                sortingDialogue();
                break;

            case ANSWER_THREE:
                orderDialogue();
                break;

            case ANSWER_FOUR:
                showOrders();
                break;

            case ANSWER_FIVE:
                view.freeResources();
                System.exit(0);
                break;

            default:
                wrongInput();
                break;
        }
    }

    private void readSortResponse() {
        String userAnswer = view.getUserAnswer();
        switch (userAnswer) {

            case ANSWER_ONE:
                listTours(tourService.getToursSortedBy(SortType.LOCATION));
                rootDialogue();
                break;

            case ANSWER_TWO:
                listTours(tourService.getToursSortedBy(SortType.NAME));
                rootDialogue();
                break;

            case ANSWER_THREE:
                listTours(tourService.getToursSortedBy(SortType.PRICE));
                rootDialogue();
                break;

            case ANSWER_FOUR:
                rootDialogue();
                break;

            default:
                wrongInput();
                break;
        }
    }

    private void wrongInput() {
        view.showWrongInputMsg();
        rootDialogue();
    }

    private void showOrders() {
        List<Order> orders = orderService.getAllOrders();
        view.showOrdersHeader();
        if (orders != null && !orders.isEmpty()) {
            for (Order order : orders) {
                view.showMessage(order.toString());
            }
        } else {
            view.showNoOrders();
        }
        rootDialogue();
    }

    private void showAvailableNutrition() {
        view.showMessage("1. Included");
        view.showMessage("2. Not Included");
    }

    private void showAvailableTransport(Integer[] transportIds) {
        for (int i = 0; i < transportIds.length; i++) {
            Transport transport = transportService.getTransportById(transportIds[i]);
            view.showMessage(String.format(TRANSPORT_FORMAT,
                    i + 1,
                    transport.getTransportType(),
                    transport.getCompany(),
                    transport.getPrice()));

        }
    }
}
