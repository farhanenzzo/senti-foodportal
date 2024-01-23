package com.farhan.sentimentAi.DTO.UniqueResCount;

public class UniqueCountDto {
    private String column;
    private int unique_count;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public int getUnique_count() {
        return unique_count;
    }

    public void setUnique_count(int unique_count) {
        this.unique_count = unique_count;
    }
}
