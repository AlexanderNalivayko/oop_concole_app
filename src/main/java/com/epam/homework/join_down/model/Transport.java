package com.epam.homework.join_down.model;

import com.epam.homework.join_down.model.enums.TransportType;

public class Transport {

    private int id;
    private TransportType transportType;
    private String company;
    private int price;

    public Transport(TransportType transportType, String company, int price) {
        this.transportType = transportType;
        this.company = company;
        this.price = price;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
