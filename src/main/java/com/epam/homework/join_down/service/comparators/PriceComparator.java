package com.epam.homework.join_down.service.comparators;

import com.epam.homework.join_down.model.Tour;

import java.util.Comparator;

public class PriceComparator implements Comparator<Tour> {

    @Override
    public int compare(Tour t1, Tour t2) {
        return t1.getPricePerDay() - t2.getPricePerDay();
    }
}
