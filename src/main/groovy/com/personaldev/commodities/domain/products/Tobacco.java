package com.personaldev.commodities.domain.products;

import javax.validation.constraints.NotNull;


public class Tobacco extends BaseProduct {

    private String blend;
    private String type;
    private String cut;

    public String getBlend() {
        return blend;
    }

    public void setBlend(String blend) {
        this.blend = blend;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }

    @Override
    public String toString() {
        return "Tobacco{" +
                "blend='" + blend + '\'' +
                ", type='" + type + '\'' +
                ", cut='" + cut + '\'' +
                '}';
    }
}
