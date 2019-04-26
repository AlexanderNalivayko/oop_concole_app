package com.epam.homework.join_down.dao;

import com.epam.homework.join_down.model.Tour;
import com.epam.homework.join_down.model.enums.TourType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTourDao implements TourDao {
    private static HashMap<Integer, Tour> tours = new HashMap<>();

    static {
        tours.put(0, new Tour.Builder()
                .withId(0)
                .withTourName("Historical Kiev")
                .withLocation("Kiev")
                .withTourType(TourType.EXCURSION)
                .withTransports("0,1,2")
                .withPricePerDay(450)
                .withPricePerDayWithNutrition(600)
                .withDescription("Unbelievably beautiful city, !please don't get of the bus! ... ")
                .build());
        tours.put(1, new Tour.Builder()
                .withId(1)
                .withTourName("Trans atlantic cruise")
                .withLocation("Atlantic ocean")
                .withTourType(TourType.CRUISE)
                .withTransports("3,4,5")
                .withPricePerDay(1500)
                .withPricePerDayWithNutrition(2000)
                .withDescription("New, World greatest ship \"Titanic\" will take you to ...")
                .build());
        tours.put(2, new Tour.Builder()
                .withId(2)
                .withTourName("Milan shopping tour")
                .withLocation("Milan")
                .withTourType(TourType.SHOPPING)
                .withTransports("6,7")
                .withPricePerDay(150)
                .withPricePerDayWithNutrition(500)
                .withDescription("Yes. You really need that red handbag, it makes you so pretty...")
                .build());
        tours.put(3, new Tour.Builder()
                .withId(3)
                .withTourName("Ukrainian sanatorium")
                .withLocation("Zhytomyr")
                .withTourType(TourType.MEDICAL_TOUR)
                .withTransports("8")
                .withPricePerDay(300)
                .withPricePerDayWithNutrition(450)
                .withDescription("Best electrofarez in the world.")
                .build());
    }

    @Override
    public List<Tour> getAll() {
        return new ArrayList<>(tours.values());
    }

    @Override
    public Tour getById(int id) {
        return tours.get(id);
    }
}
