package com.philspelman.springrelationshipsproductsm2m.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import static org.hibernate.id.PersistentIdentifierGenerator.PK;


import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class CategoryProductIdentity implements Serializable {

    @NotNull
    @Size(max = 20)
    private Long categoryId;

    @NotNull
    @Size(max = 20)
    private Long productId;

    public CategoryProductIdentity() {
    }

    public CategoryProductIdentity(Long categoryId, Long productId) {
        this.categoryId = categoryId;
        this.productId = productId;
    }

    public Long getEmployeeId() {
        return categoryId;
    }

    public void setEmployeeId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCompanyId() {
        return productId;
    }

    public void setCompanyId(Long productId) {
        this.productId = productId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryProductIdentity that = (CategoryProductIdentity) o;

        if (!categoryId.equals(that.categoryId)) return false;
        return productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        int result = categoryId.hashCode();
        result = 31 * result + productId.hashCode();
        return result;
    }
}


//
//@Entity(name = "categories_products")
//@Table(name = "categories_products")
//public class CategoryProduct extends Category implements Serializable, Comparable {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        CategoryProduct cp = (CategoryProduct) o;
//        return Objects.equals(product, cp.product) &&
//                Objects.equals(category, cp.category);
////                && Objects.equals(id, pk.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(product, category);
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
//    public Product getProduct() {
//        return product;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
//
//}



//
//@Entity(name = "categories_products")
//@IdClass(PK.class)
//@Table(name = "categories_products")
//public class CategoryProduct implements Serializable {
//
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(updatable = false)
//    private Date createdAt;
//    private Date updatedAt;
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    public PK getId() {
//        return new PK(
//                product,
//                category,
//                id
//        );
//    }
//
//    public void setId(PK id) {
//        this.product = id.getProduct();
//        this.category = id.getCategory();
////        this.id = id.getId();
//
//    }
////
////    public Long getId() {
////        return id;
////    }
//
//    public void setId(Long id) {
//        this.id = id;
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
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public CategoryProduct() {
//
//    }
//
//    public CategoryProduct(Product product, Category category) {
//        this.product = product;
//        this.category = category;
//    }
//}
//
//
