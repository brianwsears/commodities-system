package com.personaldev.commodities.domain.products;

import javax.validation.constraints.NotNull;


public class Coffee extends BaseProduct {

    private String roast;
    private Boolean caffeinated;

    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public Boolean getCaffeinated() {
        return caffeinated;
    }

    public void setCaffeinated(Boolean caffeinated) {
        this.caffeinated = caffeinated;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "roast='" + roast + '\'' +
                ", caffeinated=" + caffeinated +
                '}';
    }
}
