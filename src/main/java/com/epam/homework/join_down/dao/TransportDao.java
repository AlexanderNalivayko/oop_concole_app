package com.epam.homework.join_down.dao;

import com.epam.homework.join_down.model.Transport;

import java.util.List;

public interface TransportDao {

    public Transport getById(int id);

    public List<Transport> getAll();
}
