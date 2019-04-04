package com.epam.homework.join_down.dao;

import com.epam.homework.join_down.model.Transport;
import com.epam.homework.join_down.model.enums.TransportType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTransportDao implements TransportDao {

    private static HashMap<Integer, Transport> transports = new HashMap<>();
    static {
        transports.put(0, new Transport(0,TransportType.BUS, "AutoBus", 500));
        transports.put(1, new Transport(1, TransportType.PLANE, "MAU", 1000));
        transports.put(2, new Transport(2,TransportType.SHIP, "UkraineShipShipment", 400));
        transports.put(3, new Transport(3, TransportType.BUS, "AutoBus", 8000));
        transports.put(4, new Transport(4, TransportType.TRAIN, "InternationalRailways", 7000));
        transports.put(5, new Transport(5, TransportType.SHIP, "SeaWoolf", 7777));
        transports.put(6, new Transport(6, TransportType.PLANE, "LuftHansa", 954));
        transports.put(7, new Transport(7, TransportType.BUS, "EuroBus", 480));
        transports.put(8, new Transport(8, TransportType.BUS, "StraightRoad", 380));
    }

    @Override
    public Transport getById(int id) {
        return transports.get(id);
    }

    @Override
    public List<Transport> getAll() {
        return new ArrayList<>(transports.values());
    }
}
