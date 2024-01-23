package com.farhan.sentimentAi.DTO.AvgPositive;

import java.util.List;

public class AvgPositiveList {
    private List<AvgPositiveByCity> avg_pos_senti_by_city;

    public List<AvgPositiveByCity> getAvg_pos_senti_by_city() {
        return avg_pos_senti_by_city;
    }

    public void setAvg_pos_senti_by_city(List<AvgPositiveByCity> avg_pos_senti_by_city) {
        this.avg_pos_senti_by_city = avg_pos_senti_by_city;
    }

    @Override
    public String toString() {
        return "AvgPositive{" +
                "avg_pos_senti_by_city=" + avg_pos_senti_by_city +
                '}';
    }
}
