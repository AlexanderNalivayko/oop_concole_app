package com.epam.homework.join_down.model;

import com.epam.homework.join_down.model.enums.TransportType;

public class Transport {

    private int id;
    private TransportType transportType;
    private String company;
    private int price;

    public Transport(int id, TransportType transportType, String company, int price) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        if (id != transport.id) return false;
        if (price != transport.price) return false;
        if (transportType != transport.transportType) return false;
        return company != null ? company.equals(transport.company) : transport.company == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (transportType != null ? transportType.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }
}
