package com.philspelman.springrelationshipsproductsm2m.repositories;

import com.philspelman.springrelationshipsproductsm2m.models.CategoryProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {
    List<CategoryProduct> findAll();
}
