package com.epam.homework.join_down.model;

import com.epam.homework.join_down.model.enums.TourType;

public class Tour {

    private Integer id;
    private String tourName;
    private String location;
    private TourType tourType;
    private String transportsIds;
    private Integer pricePerDay;
    private Integer pricePerDayWithNutrition;
    private String description;

    public Integer getId() {
        return id;
    }

    public String getTourName() {
        return tourName;
    }

    public String getLocation() {
        return location;
    }

    public TourType getTourType() {
        return tourType;
    }

    public String getTransports() {
        return transportsIds;
    }

    public String getTransportsIds() {
        return transportsIds;
    }

    public Integer getPricePerDay() {
        return pricePerDay;
    }

    public Integer getPricePerDayWithNutrition() {
        return pricePerDayWithNutrition;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", tourName='" + tourName + '\'' +
                ", location='" + location + '\'' +
                ", tourType=" + tourType +
                ", pricePerDay=" + pricePerDay +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {

        private Tour newTour;

        public Builder() {
            newTour = new Tour();
        }

        public Builder withId(Integer id) {
            newTour.id = id;
            return this;
        }

        public Builder withTourName(String tourName) {
            newTour.tourName = tourName;
            return this;
        }


        public Builder withLocation(String location) {
            newTour.location = location;
            return this;
        }

        public Builder withTourType(TourType tourType) {
            newTour.tourType = tourType;
            return this;
        }

        public Builder withTransports(String transportsIds) {
            newTour.transportsIds = transportsIds;
            return this;
        }

        public Builder withPricePerDayWithNutrition(int pricePerDayWithNutrition) {
            newTour.pricePerDayWithNutrition = pricePerDayWithNutrition;
            return this;
        }

        public Builder withPricePerDay(Integer pricePerDay) {
            newTour.pricePerDay = pricePerDay;
            return this;
        }

        public Builder withDescription(String description) {
            newTour.description = description;
            return this;
        }

        public Tour build() {
            return newTour;
        }
    }
}
