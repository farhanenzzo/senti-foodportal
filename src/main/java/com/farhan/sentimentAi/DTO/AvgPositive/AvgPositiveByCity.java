package com.farhan.sentimentAi.DTO.AvgPositive;

public class AvgPositiveByCity {
    private double average_positive_sentiment_percentage;
    private String city;

    public double getAverage_positive_sentiment_percentage() {
        return average_positive_sentiment_percentage;
    }

    public void setAverage_positive_sentiment_percentage(double average_positive_sentiment_percentage) {
        this.average_positive_sentiment_percentage = average_positive_sentiment_percentage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "PositiveSentimentByCity{" +
                "average_positive_sentiment_percentage=" + average_positive_sentiment_percentage +
                ", city='" + city + '\'' +
                '}';
    }
}
