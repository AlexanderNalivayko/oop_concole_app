package com.epam.homework.join_down.ui;

public class ConsoleViewWithStaticMsgs extends View {

    private final static String NEW_LINE = System.lineSeparator();

    private final static String GREETINGS = "Hello. This is Join-Down. Super budget console touristic app";

    private final static String GENERAL_OPTIONS = "GENERAL OPTIONS:" + NEW_LINE
            + "CHOOSE CATEGORY:" + NEW_LINE
            + "1. show available tours" + NEW_LINE
            + "2. show available tours sorted by ..." + NEW_LINE
            + "3. make order" + NEW_LINE
            + "4. show all orders" + NEW_LINE
            + "5. exit.";

    private final static String SORTING_DIALOGUE = "WHICH WAY YOU WANT TO SORT TOURS ?" + NEW_LINE
            + "1. location" + NEW_LINE
            + "2. name" + NEW_LINE
            + "3. price" + NEW_LINE
            + "4. back.";

    private final static String ENTER_ID = "PLEASE ENTER TOUR ID:";
    private final static String CHOOSE_NUTRITION = "PLEASE CHOOSE NUTRITION:";
    private final static String CHOOSE_TRANSPORT = "PLEASE CHOOSE TRANSPORT:";
    private final static String ENTER_FIRST_NAME = "PLEASE ENTER FIRST NAME:";
    private final static String ENTER_LAST_NAME = "PLEASE ENTER LAST NAME:";
    private final static String ENTER_DAYS = "PLEASE ENTER AMOUNT OF DAYS:";
    private final static String ENTER_PHONE = "PLEASE ENTER PHONE NUMBER:";

    private final static String NO_ORDERS_YET = "there is no orders yet.";
    private final static String NEW_ORDER_REGISTERED = "new order successfully registered.";
    private final static String WRONG_INPUT = "sorry. your input is wrong, try again.";

    private final static String ORDER_CREATION_HEADER = "ORDER CREATION:";
    private final static String TOURS_HEADER = "AVAILABLE TOURS:";
    private final static String ORDERS_HEADER = "ORDERS:";


    @Override
    public void showGreeting() {
        showMessage(GREETINGS);
    }

    @Override
    public void showAvailableOptions() {
        showMessage(GENERAL_OPTIONS);
    }

    @Override
    public void showTours(String formattedTours) {
        showMessage(TOURS_HEADER + NEW_LINE + formattedTours);
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
    public String getNutritionFromUser(String availableNutrition) {
        showMessage(CHOOSE_NUTRITION + NEW_LINE + availableNutrition);
        return getUserAnswer();
    }

    @Override
    public String getTransportFromUser(String availableTransport) {
        showMessage(CHOOSE_TRANSPORT + NEW_LINE + availableTransport);
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
    public void showOrders(String orders) {
        showMessage(ORDERS_HEADER + NEW_LINE + orders);
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


}
