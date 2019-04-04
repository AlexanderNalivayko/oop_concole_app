package com.epam.homework.join_down.service;

import com.epam.homework.join_down.dao.TourDao;
import com.epam.homework.join_down.model.Tour;
import com.epam.homework.join_down.service.comparators.LocationComparator;
import com.epam.homework.join_down.service.comparators.PriceComparator;
import com.epam.homework.join_down.service.comparators.TourNameComparator;
import com.epam.homework.join_down.ui.SortType;

import java.util.List;

public class DefaultTourService implements TourService {

    private TourDao tourDao;

    public DefaultTourService(TourDao tourDao) {
        this.tourDao = tourDao;
    }

    @Override
    public List<Tour> getAllTours() {
        return tourDao.getAll();
    }

    @Override
    public List<Tour> getToursSortedBy(SortType sortBy) {
        List<Tour> tours = getAllTours();
        if (sortBy.equals(SortType.PRICE)) {
            tours.sort(new PriceComparator());
        } else if (sortBy.equals(SortType.LOCATION)) {
            tours.sort(new LocationComparator());
        } else if (sortBy.equals(SortType.NAME)) {
            tours.sort(new TourNameComparator());
        }
        return tours;
    }

    @Override
    public Tour getTourById(int id) {
        return tourDao.getById(id);
    }
}
