package com.epam.homework.join_down.ui;

import java.util.Scanner;

public abstract class View {
    private static final String NEW_LINE = System.lineSeparator();

    private final Scanner scanner = new Scanner(System.in);

    String getUserAnswer() {
        return scanner.nextLine();
    }

    public void freeResources() {
        scanner.close();
    }

    void showMessage(String message) {
        System.out.println(NEW_LINE + message);
    }

    abstract void showGreeting();

    abstract void showAvailableOptions();

    abstract void showTours(String formattedTours);

    abstract void showSortingDialogue();

    abstract String getNutritionFromUser(String availableNutrition);

    abstract String getTransportFromUser(String availableTransport);

    abstract void showOrderDialogue();

    abstract String getDaysFromUser();

    abstract String getIdFromUser();

    abstract void showWrongInputMsg();

    abstract String getFirstNameFromUser();

    abstract String getLastNameFromUser();

    abstract String gePhoneFromUser();

    abstract void showNoOrders();

    abstract void showOrders(String orders);

    abstract void showOrderRegisteredMsg();

}
