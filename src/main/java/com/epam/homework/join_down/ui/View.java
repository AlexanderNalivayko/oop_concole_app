package com.epam.homework.join_down.ui;

import com.epam.homework.join_down.model.Tour;

import java.util.List;

public interface View {

    void showGreeting();

    void showAvailableOptions();

    void showTours(List<Tour> tours);

    void showSortingDialogue();

    public String getNutritionFromUser();

    String getUserAnswer();

    public String getTransportFromUser();

    public void showOrderDialogue();

    public String getDaysFromUser();

    String getIdFromUser();

    void showMessage(String message);

    public void freeResources();

    public void showWrongInputMsg();

    public String getFirstNameFromUser();

    public String getLastNameFromUser();

    public String gePhoneFromUser();

    public void showNoOrders();

    public void showOrdersHeader();

    public void showOrderRegisteredMsg();

}
