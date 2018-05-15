package com.philspelman.springrelationshipsproductsm2m.services;

import com.philspelman.springrelationshipsproductsm2m.models.Category;
import com.philspelman.springrelationshipsproductsm2m.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    //hook up repo
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }

    public void addCategory(Category category) {
        this.categoryRepository.save(category);

        if (this.categoryRepository.findAll().size() < 1) {
            //make some new categories
        }

    }


    public void destroyCategory(Long id) {
        //try to destroy the category
    }
}
