package com.epam.homework.join_down.service;

import com.epam.homework.join_down.model.Transport;

import java.util.List;

public interface TransportService {

    Transport getTransportById(int id);

    List<Transport> getAllTransport();
}
