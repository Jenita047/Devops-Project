package com.thriftmart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String category;
    private double price;
    private String condition;
    private String description;
    private boolean sold;

    public Product() {}

    public Product(String productName, String category, double price, String condition, String description) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.condition = condition;
        this.description = description;
        this.sold = false;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isSold() { return sold; }
    public void setSold(boolean sold) { this.sold = sold; }
}
