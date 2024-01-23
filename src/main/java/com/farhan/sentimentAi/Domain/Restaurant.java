package com.farhan.sentimentAi.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurant_details")
public class Restaurant {

    private static final long serialVersionUID = 1L;

    @Id
    private String name;

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
