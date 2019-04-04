package com.epam.homework.join_down.ui;

import com.epam.homework.join_down.model.Tour;

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements View {

    private final static String NEW_LINE = System.lineSeparator();

    private final static String GREETINGS = "Hello. This is Join-Down. Super budget console touristic app";

    private final static String GENERAL_OPTIONS = "### General options ###" + NEW_LINE
            + "chose category:" + NEW_LINE
            + "1. show available tours" + NEW_LINE
            + "2. show available tours sorted by ..." + NEW_LINE
            + "3. make order" + NEW_LINE
            + "4. show all orders" + NEW_LINE
            + "5. exit.";

    private final static String SORTING_DIALOGUE = "sort tours by:" + NEW_LINE
            + "1. location" + NEW_LINE
            + "2. name" + NEW_LINE
            + "3. price" + NEW_LINE
            + "4. back.";

    private final static String ENTER_ID = "please enter tour id:";
    private final static String CHOOSE_NUTRITION = "please choose nutrition:";
    private final static String CHOOSE_TRANSPORT = "please choose transport:";
    private final static String ENTER_FIRST_NAME = "please enter FirstName:";
    private final static String ENTER_LAST_NAME = "please enter LastName:";
    private final static String ENTER_DAYS = "please enter amount of days:";
    private final static String ENTER_PHONE = "please enter phone number:";

    private final static String NO_ORDERS_YET = "there is no orders yet.";
    private final static String NEW_ORDER_REGISTERED = "new order registered.";
    private final static String WRONG_INPUT = "sorry. your input is wrong, try again.";

    private final static String ORDER_CREATION_HEADER = "### Order creation: ###";
    private final static String TOURS_HEADER = "### Available tours: ###";
    private final static String ORDERS_HEADER = "### Orders: ###";


    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showGreeting() {
        showMessage(GREETINGS);
    }

    @Override
    public void showAvailableOptions() {
        showMessage(GENERAL_OPTIONS);
    }

    @Override
    public void showTours(List<Tour> tours) {
        showMessage(TOURS_HEADER);
        for (Tour tour : tours) {
            showMessage(tour.toString());
        }
    }

    @Override
    public void showSortingDialogue() {
        showMessage(SORTING_DIALOGUE);
    }

    @Override
    public void showOrderDialogue() {
        showMessage(ORDER_CREATION_HEADER);
    }

    @Override
    public String getIdFromUser() {
        showMessage(ENTER_ID);
        return getUserAnswer();
    }

    @Override
    public String getNutritionFromUser() {
        showMessage(CHOOSE_NUTRITION);
        return getUserAnswer();
    }

    @Override
    public String getTransportFromUser() {
        showMessage(CHOOSE_TRANSPORT);
        return getUserAnswer();
    }

    @Override
    public String getFirstNameFromUser() {
        showMessage(ENTER_FIRST_NAME);
        return getUserAnswer();
    }

    @Override
    public String getLastNameFromUser() {
        showMessage(ENTER_LAST_NAME);
        return getUserAnswer();
    }

    @Override
    public String gePhoneFromUser() {
        showMessage(ENTER_PHONE);
        return getUserAnswer();
    }

    @Override
    public String getDaysFromUser() {
        showMessage(ENTER_DAYS);
        return getUserAnswer();
    }

    @Override
    public String getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void showOrdersHeader() {
        showMessage(ORDERS_HEADER);
    }

    @Override
    public void showOrderRegisteredMsg() {
        showMessage(NEW_ORDER_REGISTERED);
    }

    @Override
    public void showNoOrders() {
        showMessage(NO_ORDERS_YET);
    }

    @Override
    public void showWrongInputMsg() {
        showMessage(WRONG_INPUT);
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void freeResources() {
        scanner.close();
    }

}
