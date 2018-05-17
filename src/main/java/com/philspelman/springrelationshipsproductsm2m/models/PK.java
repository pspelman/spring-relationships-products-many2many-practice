//package com.philspelman.springrelationshipsproductsm2m.models;
//
//import java.io.Serializable;
//import java.util.Objects;
//
////public static class PK implements Serializable {
//public class PK implements Serializable {
//
//    private Product product;
//    private Category category;
//    private Long id;
//
//    PK(Product product, Category category) {
//        this.product = (Product) product;
//        this.category = (Category) category;
//        this.id = id;
//    }
//
//    private PK() {
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
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        PK pk = (PK) o;
//        return Objects.equals(product, pk.product) &&
//                Objects.equals(category, pk.category);
////                && Objects.equals(id, pk.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(product, category);
//    }
//}
