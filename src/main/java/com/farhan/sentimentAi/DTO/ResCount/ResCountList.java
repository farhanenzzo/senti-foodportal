package com.farhan.sentimentAi.DTO.ResCount;

import java.util.List;

public class ResCountList {
    private List<ResCountByCity> city_counts;

    public List<ResCountByCity> getCity_counts() {
        return city_counts;
    }

    public void setCity_counts(List<ResCountByCity> city_counts) {
        this.city_counts = city_counts;
    }

    @Override
    public String toString() {
        return "RestaurantCount{" +
                "city_counts=" + city_counts +
                '}';
    }
}
