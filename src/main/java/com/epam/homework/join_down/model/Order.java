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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (transportId != order.transportId) return false;
        if (days != order.days) return false;
        if (nutrition != order.nutrition) return false;
        if (totalPrice != order.totalPrice) return false;
        if (ClientFirstName != null ? !ClientFirstName.equals(order.ClientFirstName) : order.ClientFirstName != null)
            return false;
        if (ClientLastName != null ? !ClientLastName.equals(order.ClientLastName) : order.ClientLastName != null)
            return false;
        if (phone != null ? !phone.equals(order.phone) : order.phone != null) return false;
        return tour != null ? tour.equals(order.tour) : order.tour == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ClientFirstName != null ? ClientFirstName.hashCode() : 0);
        result = 31 * result + (ClientLastName != null ? ClientLastName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (tour != null ? tour.hashCode() : 0);
        result = 31 * result + (int) (transportId ^ (transportId >>> 32));
        result = 31 * result + days;
        result = 31 * result + (nutrition ? 1 : 0);
        result = 31 * result + (int) (totalPrice ^ (totalPrice >>> 32));
        return result;
    }
}
