package com.epam.homework.join_down.dao;

import com.epam.homework.join_down.model.Tour;

import java.util.List;

public interface TourDao {

    List<Tour> getAll();

    Tour getById(int id);
}
