package com.project.store.superstore.models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "productPrice")
    private double productPrice;

    @Column(name = "productSold")
    private double productSold;

    public Product() {
    }

    public Product( String productName, String imageUrl, double productPrice, double productSold) {
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
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", productPrice=" + productPrice +
                ", productSold=" + productSold +
                '}';
    }
}
