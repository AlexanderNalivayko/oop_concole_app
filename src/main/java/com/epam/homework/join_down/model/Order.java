package com.epam.homework.join_down.model;

public class Order {

    private int id;
    private String ClientFirstName;
    private String ClientLastName;
    private String phone;
    private Tour tour;
    private long transportId;
    private int days;
    private boolean nutrition;
    private long totalPrice;

    public Order(int id, String clientFirstName, String clientLastName, String phone,
                 Tour tour, long transportId, int days, boolean nutrition, long totalPrice) {
        this.id = id;
        ClientFirstName = clientFirstName;
        ClientLastName = clientLastName;
        this.phone = phone;
        this.tour = tour;
        this.transportId = transportId;
        this.days = days;
        this.nutrition = nutrition;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public String getClientFirstName() {
        return ClientFirstName;
    }

    public String getClientLastName() {
        return ClientLastName;
    }

    public boolean isNutrition() {
        return nutrition;
    }

    public String getPhone() {
        return phone;
    }

    public Tour getTour() {
        return tour;
    }

    public long getTransportId() {
        return transportId;
    }

    public int getDays() {
        return days;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ClientFirstName='" + ClientFirstName + '\'' +
                ", ClientLastName='" + ClientLastName + '\'' +
                ", phone='" + phone + '\'' +
                ", tour=" + tour +
                ", transportId=" + transportId +
                ", days=" + days +
                ", nutrition=" + nutrition +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
