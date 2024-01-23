package com.farhan.sentimentAi.DTO.ResCount;

public class ResCountByCity {
    private String city;
    private int restaurant_count;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRestaurant_count() {
        return restaurant_count;
    }

    public void setRestaurant_count(int restaurant_count) {
        this.restaurant_count = restaurant_count;
    }

    @Override
    public String toString() {
        return "ResCountByCity{" +
                "city='" + city + '\'' +
                ", restaurant_count=" + restaurant_count +
                '}';
    }
}
