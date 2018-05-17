package com.philspelman.springrelationshipsproductsm2m.repositories;

import com.philspelman.springrelationshipsproductsm2m.models.Category;
import com.philspelman.springrelationshipsproductsm2m.models.CategoryProductIdentity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
}

