package com.epam.homework.join_down.ui;

import com.epam.homework.join_down.model.Order;
import com.epam.homework.join_down.model.Tour;
import com.epam.homework.join_down.model.Transport;
import com.epam.homework.join_down.service.OrderService;
import com.epam.homework.join_down.service.TourService;
import com.epam.homework.join_down.service.TransportService;
import com.epam.homework.join_down.util.FormatUtil;
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
        view.showTours(FormatUtil.FormatObjToUserFriendlyStr(tours));
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
            String transport = getAvailableTransport(transportIds);
            int transportId = transportIds[Integer.parseInt(view.getTransportFromUser(transport)) - 1];

            String nutrition = view.getNutritionFromUser(getAvailableNutrition());

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
        if (orders != null && !orders.isEmpty()) {
            view.showOrders(FormatUtil.FormatObjToUserFriendlyStr(orders));
        } else {
            view.showNoOrders();
        }
        rootDialogue();
    }

    private String getAvailableNutrition() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1. Included");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("2. Not Included");
        return stringBuilder.toString();
    }

    private String getAvailableTransport(Integer[] transportIds) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = transportIds.length;
        for (int i = 0; i < length; i++) {
            Transport transport = transportService.getTransportById(transportIds[i]);
            stringBuilder.append(String.format(TRANSPORT_FORMAT,
                    i + 1,
                    transport.getTransportType(),
                    transport.getCompany(),
                    transport.getPrice()));
            if (i < length - 1) {
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }
}
