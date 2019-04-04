package com.epam.homework.join_down.service;

import com.epam.homework.join_down.model.Transport;

import java.util.List;

public interface TransportService {

    public Transport getTransportById(int id);

    public List<Transport> getAllTransport();
}
