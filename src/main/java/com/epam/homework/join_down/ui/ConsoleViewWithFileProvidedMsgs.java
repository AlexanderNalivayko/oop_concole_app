package com.epam.homework.join_down.ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConsoleViewWithFileProvidedMsgs extends View {
    private static final String NEW_LINE = "\n";

    private FileInputStream fis;
    private Properties property = new Properties();

    public ConsoleViewWithFileProvidedMsgs() {
        try {
            fis = new FileInputStream("src/main/resources/messages.properties");
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showGreeting() {
        showMessage(property.getProperty("msg.greetings"));
    }

    @Override
    public void showAvailableOptions() {
        showMessage(property.getProperty("msg.general_options"));
    }

    @Override
    public void showTours(String formattedTours) {
        showMessage(property.getProperty("msg.tours_header") + NEW_LINE + formattedTours);
    }

    @Override
    public void showSortingDialogue() {
        showMessage(property.getProperty("msg.sorting_dialogue"));
    }

    @Override
    public void showOrderDialogue() {
        showMessage(property.getProperty("msg.order_creation_header"));
    }

    @Override
    public String getIdFromUser() {
        showMessage(property.getProperty("msg.enter_id"));
        return getUserAnswer();
    }

    @Override
    public String getNutritionFromUser(String availableNutrition) {
        showMessage(property.getProperty("msg.choose_nutrition") + NEW_LINE + availableNutrition);
        return getUserAnswer();
    }

    @Override
    public String getTransportFromUser(String availableTransport) {
        showMessage(property.getProperty("msg.choose_transport") + NEW_LINE + availableTransport);
        return getUserAnswer();
    }

    @Override
    public String getFirstNameFromUser() {
        showMessage(property.getProperty("msg.enter_first_name"));
        return getUserAnswer();
    }

    @Override
    public String getLastNameFromUser() {
        showMessage(property.getProperty("msg.enter_last_name"));
        return getUserAnswer();
    }

    @Override
    public String gePhoneFromUser() {
        showMessage(property.getProperty("msg.enter_phone"));
        return getUserAnswer();
    }

    @Override
    public String getDaysFromUser() {
        showMessage(property.getProperty("msg.enter_days"));
        return getUserAnswer();
    }

    @Override
    public void showOrders(String orders) {
        showMessage(property.getProperty("msg.orders_header") + NEW_LINE + orders);
    }

    @Override
    public void showOrderRegisteredMsg() {
        showMessage(property.getProperty("msg.new_order_registered"));
    }

    @Override
    public void showNoOrders() {
        showMessage(property.getProperty("msg.no_orders_yet"));
    }

    @Override
    public void showWrongInputMsg() {
        showMessage(property.getProperty("msg.wrong_input"));
    }

    @Override
    public void freeResources() {
        super.freeResources();
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
