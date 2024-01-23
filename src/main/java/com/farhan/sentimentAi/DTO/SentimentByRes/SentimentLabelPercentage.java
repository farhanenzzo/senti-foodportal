package com.farhan.sentimentAi.DTO.SentimentByRes;

public class SentimentLabelPercentage {
    double sentimentPercentage;
    String sentimentTitle;

    public double getSentimentPercentage() {
        return sentimentPercentage;
    }

    public void setSentimentPercentage(double sentimentPercentage) {
        this.sentimentPercentage = sentimentPercentage;
    }

    public String getSentimentTitle() {
        return sentimentTitle;
    }

    public void setSentimentTitle(String sentimentTitle) {
        this.sentimentTitle = sentimentTitle;
    }

    @Override
    public String toString() {
        return "SentimentLabelPercentage{" +
                "sentimentPercentage=" + sentimentPercentage +
                ", sentimentTitle='" + sentimentTitle + '\'' +
                '}';
    }
}
