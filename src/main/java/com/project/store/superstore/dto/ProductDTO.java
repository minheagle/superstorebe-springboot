package com.project.store.superstore.dto;

import javax.persistence.Column;

public class ProductDTO {
    private long id;
    private String productName;
    private String imageUrl;
    private double productPrice;
    private double productSold;

    public ProductDTO() {
    }

    public ProductDTO( String productName, String imageUrl, double productPrice, double productSold) {
        this.productName = productName;
        this.imageUrl = imageUrl;
        this.productPrice = productPrice;
        this.productSold = productSold;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductSold() {
        return productSold;
    }

    public void setProductSold(double productSold) {
        this.productSold = productSold;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", productPrice=" + productPrice +
                ", productSold=" + productSold +
                '}';
    }
}
