package com.epam.homework.join_down.service;

import com.epam.homework.join_down.dao.TransportDao;
import com.epam.homework.join_down.model.Transport;

import java.util.List;

public class DefaultTransportService implements TransportService {

    private TransportDao transportDao;

    public DefaultTransportService(TransportDao transportDao) {
        this.transportDao = transportDao;
    }

    @Override
    public Transport getTransportById(int id) {
        return transportDao.getById(id);
    }

    @Override
    public List<Transport> getAllTransport() {
        return transportDao.getAll();
    }
}
