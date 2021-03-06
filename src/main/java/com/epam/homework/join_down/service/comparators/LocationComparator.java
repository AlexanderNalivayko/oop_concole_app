package com.epam.homework.join_down.service.comparators;

import com.epam.homework.join_down.model.Tour;

import java.util.Comparator;

public class LocationComparator implements Comparator<Tour> {

    @Override
    public int compare(Tour tour1, Tour tour2) {
        return tour1.getLocation().compareTo(tour2.getLocation());
    }
}
