package com.personaldev.commodities.domain.products;

import javax.validation.constraints.NotNull;


public class BaseProduct {

    @NotNull
    int id;
    private String manufacturer;
    private String productName;
    private String unitOfSale;
    private Float pricePerUnit;
    private Boolean inStock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnitOfSale() {
        return unitOfSale;
    }

    public void setUnitOfSale(String unitOfSale) {
        this.unitOfSale = unitOfSale;
    }

    public Float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "BaseProduct{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", productName='" + productName + '\'' +
                ", unitOfSale='" + unitOfSale + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                ", inStock=" + inStock +
                '}';
    }
}
