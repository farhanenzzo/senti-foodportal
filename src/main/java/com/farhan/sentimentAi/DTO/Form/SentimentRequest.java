package com.farhan.sentimentAi.DTO.Form;

public class SentimentRequest {
    private String text;
    private String restaurantName;
    private String locationName;
    private int topN;
    private String naturalName;

    public int getTopN() {
        return topN;
    }

    public void setTopN(int topN) {
        this.topN = topN;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getNaturalName() {
        return naturalName;
    }

    public void setNaturalName(String naturalName) {
        this.naturalName = naturalName;
    }
}
