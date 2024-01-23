package com.farhan.sentimentAi.DTO.SentimentByRes;

import java.util.ArrayList;
import java.util.List;

public class FlaskLRModel {
    private String restaurantName;
    private String restaurantOverallSentiment;
    private List<SentimentLabelPercentage> sentimentLabelPercentage;

    public FlaskLRModel() {
        this.sentimentLabelPercentage = new ArrayList<>();
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantOverallSentiment() {
        return restaurantOverallSentiment;
    }

    public void setRestaurantOverallSentiment(String restaurantOverallSentiment) {
        this.restaurantOverallSentiment = restaurantOverallSentiment;
    }

    public List<SentimentLabelPercentage> getSentimentLabelPercentage() {
        return sentimentLabelPercentage;
    }

    public void setSentimentLabelPercentage(List<SentimentLabelPercentage> sentimentLabelPercentage) {
        this.sentimentLabelPercentage = sentimentLabelPercentage;
    }

    @Override
    public String toString() {
        return "FlaskLRModel{" +
                "restaurantName='" + restaurantName + '\'' +
                ", restaurantOverallSentiment='" + restaurantOverallSentiment + '\'' +
                ", sentimentLabelPercentage=" + sentimentLabelPercentage +
                '}';
    }
}
