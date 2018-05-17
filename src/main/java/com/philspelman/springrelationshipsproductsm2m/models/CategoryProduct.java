package com.philspelman.springrelationshipsproductsm2m.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="categories_products")
public class CategoryProduct {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @GeneratedValue
    private Long id;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    public CategoryProduct() {

    }

    public CategoryProduct(Product product, Category category) {
        this.product = product;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("CatProd: id: %d, product_id: %d, category_id: %d", this.id, this.category.getId(), this.product.getId());

    }

// ...
    // getters and setters removed for brevity
    // ...
}

