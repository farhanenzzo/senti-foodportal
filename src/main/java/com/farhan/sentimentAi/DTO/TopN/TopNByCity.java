package com.farhan.sentimentAi.DTO.TopN;

public class TopNByCity {
    private double positive_sentiment_percentage;
    private String restaurant;

    public double getPositive_sentiment_percentage() {
        return positive_sentiment_percentage;
    }

    public void setPositive_sentiment_percentage(double positive_sentiment_percentage) {
        this.positive_sentiment_percentage = positive_sentiment_percentage;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "TopNByCity{" +
                "positive_sentiment_percentage=" + positive_sentiment_percentage +
                ", restaurant='" + restaurant + '\'' +
                '}';
    }
}
