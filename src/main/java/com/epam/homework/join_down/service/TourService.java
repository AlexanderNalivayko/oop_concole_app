package com.epam.homework.join_down.service;

import com.epam.homework.join_down.model.Tour;
import com.epam.homework.join_down.ui.SortType;

import java.util.List;

public interface TourService {

    List<Tour> getAllTours();

    List<Tour> getToursSortedBy(SortType sortBy);

    Tour getTourById(int id);
}
