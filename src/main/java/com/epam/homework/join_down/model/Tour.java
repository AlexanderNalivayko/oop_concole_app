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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (!id.equals(tour.id)) return false;
        if (tourName != null ? !tourName.equals(tour.tourName) : tour.tourName != null) return false;
        if (location != null ? !location.equals(tour.location) : tour.location != null) return false;
        if (tourType != tour.tourType) return false;
        if (transportsIds != null ? !transportsIds.equals(tour.transportsIds) : tour.transportsIds != null)
            return false;
        if (pricePerDay != null ? !pricePerDay.equals(tour.pricePerDay) : tour.pricePerDay != null) return false;
        if (pricePerDayWithNutrition != null ? !pricePerDayWithNutrition.equals(tour.pricePerDayWithNutrition) : tour.pricePerDayWithNutrition != null)
            return false;
        return description != null ? description.equals(tour.description) : tour.description == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (tourName != null ? tourName.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (tourType != null ? tourType.hashCode() : 0);
        result = 31 * result + (transportsIds != null ? transportsIds.hashCode() : 0);
        result = 31 * result + (pricePerDay != null ? pricePerDay.hashCode() : 0);
        result = 31 * result + (pricePerDayWithNutrition != null ? pricePerDayWithNutrition.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
