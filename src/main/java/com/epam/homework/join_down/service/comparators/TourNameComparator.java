package com.epam.homework.join_down.service.comparators;

import com.epam.homework.join_down.model.Tour;

import java.util.Comparator;

public class TourNameComparator implements Comparator<Tour> {

    @Override
    public int compare(Tour tour1, Tour tour2) {
        return tour1.getTourName().compareTo(tour2.getTourName());
    }
}
