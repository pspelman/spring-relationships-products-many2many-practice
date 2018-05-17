package com.philspelman.springrelationshipsproductsm2m.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;





@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float price;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="product", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CategoryProduct> categoriesProducts;

    public Product() {

    }

    public Product(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<CategoryProduct> getCategoriesProducts() {
        return categoriesProducts;
    }

    public void setCategoriesProducts(List<CategoryProduct> categoriesProducts) {
        this.categoriesProducts = categoriesProducts;
    }

// ...
    // getters and setters removed for brevity
    // ...
}














//@Entity
//@Table(name="products")
//public class Product {
//
//
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    private String description;
//    private float price;
//
//    @Column(updatable = false)
//    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
//    private Date createdAt;
//
//    @Column
//    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
//    private Date updatedAt;
//
//
//    //always before creating
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = new Date();
//        this.updatedAt = this.createdAt;
//    }
//
//    //always before updating
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = new Date();
//    }
//
//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<CategoryProductIdentity> categoriesProducts;
//
//    public Product() {
//
//    }
//
//    public Product(String name, String description, float price) {
//        this.name = name;
//        this.description = description;
//        this.price = price;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public float getPrice() {
//        return price;
//    }
//
//    public void setPrice(float price) {
//        this.price = price;
//    }
//
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Date getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public List<CategoryProductIdentity> getCategoriesProducts() {
//        return categoriesProducts;
//    }
//
//    public void setCategoriesProducts(List<CategoryProductIdentity> categoriesProducts) {
//        this.categoriesProducts = categoriesProducts;
//    }
//}
