package com.example.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "productName")
    private String productName;

    @NotNull
    @Column(name = "category")
    private String category;

    @Column(name = "productShortDescription")
    private String productShortDescription;

    @Column(name = "productDescription")
    private String productDescription;

    @NotNull
    @Column(name = "price")
    private float price;

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductShortDescription() {
        return productShortDescription;
    }

    public void setProductShortDescription(String productShortDescription) {
        this.productShortDescription = productShortDescription;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Product() {

    }

    public Product(@NotNull String productName, @NotNull String category, @NotNull float price, String productDescription, String productShortDescription) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.productDescription = productDescription;
        this.productShortDescription = productShortDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", productShortDescription='" + productShortDescription + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                '}';
    }
}
