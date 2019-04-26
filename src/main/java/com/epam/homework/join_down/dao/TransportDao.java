package com.epam.homework.join_down.dao;

import com.epam.homework.join_down.model.Transport;

import java.util.List;

public interface TransportDao {

    Transport getById(int id);

    List<Transport> getAll();
}
