package com.epam.homework.join_down.service;

import com.epam.homework.join_down.model.Tour;
import com.epam.homework.join_down.ui.SortType;

import java.util.List;

public interface TourService {

    public List<Tour> getAllTours();

    public List<Tour> getToursSortedBy(SortType sortBy);

    public Tour getTourById(int id);
}
