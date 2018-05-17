package com.philspelman.springrelationshipsproductsm2m.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CategoryProduct> categoriesProducts;

    public Category() {

    }

    public Category(String name) {
        this.name = name;
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
//
//@Entity(name = "Category")
//@Table(name = "categories")
//public class Category {
//
//
//    @EmbeddedId
//    private CategoryProductIdentity categoryProductIdentity;
//
//    @NotNull
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @NotNull
//    @Size(min = 2, max = 60)
//    private String name;
//
//
//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<CategoryProductIdentity> categoriesProducts;
//
//    public Category() {
//
//    }
//
//    public Category(String name) {
//        this.name = name;
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
//    public List<CategoryProductIdentity> getCategoriesProducts() {
//        return categoriesProducts;
//    }
//
//    public void setCategoriesProducts(List<CategoryProductIdentity> categoriesProducts) {
//        this.categoriesProducts = categoriesProducts;
//    }
//}

//    @Column(updatable = false)
//    private Date createdAt;
//    private Date updatedAt;
//
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = new Date();
//        this.updatedAt = this.createdAt;
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = new Date();
//    }
//