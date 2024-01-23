package com.farhan.sentimentAi.DTO.TopN;

import java.util.List;

public class TopNList {
    private List<TopNByCity> top_n_by_city;

    public List<TopNByCity> getTop_n_by_city() {
        return top_n_by_city;
    }

    public void setTop_n_by_city(List<TopNByCity> top_n_by_city) {
        this.top_n_by_city = top_n_by_city;
    }

    @Override
    public String toString() {
        return "TopNList{" +
                "top_n_by_city=" + top_n_by_city +
                '}';
    }
}
