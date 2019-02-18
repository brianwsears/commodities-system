package com.personaldev.commodities.domain.products;

import javax.validation.constraints.NotNull;


public class Product {

    @NotNull
    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
