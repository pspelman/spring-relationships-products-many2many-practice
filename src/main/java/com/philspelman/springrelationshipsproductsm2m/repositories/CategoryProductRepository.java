package com.philspelman.springrelationshipsproductsm2m.repositories;

import com.philspelman.springrelationshipsproductsm2m.models.Category;
import com.philspelman.springrelationshipsproductsm2m.models.CategoryProduct;
import com.philspelman.springrelationshipsproductsm2m.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//import com.philspelman.springrelationshipsproductsm2m.models.PK;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Category> {

    Iterable<CategoryProduct> findAll();

    List<CategoryProduct> findCategoryProductByProductEquals(Product product);

//    @Query(value = "DROP DATABASE relationships_m2m", nativeQuery = true)
    @Query(value = "ALTER TABLE categories_products DROP PRIMARY KEY, ADD PRIMARY KEY(category_id, product_id)", nativeQuery = true)
    void changeTables();

//        Iterable<Category> findAll();
//    List<CategoryProductRepository> findAll();
//    Boolean findByCategoryAndAndProduct(Category category, Product product);



}
