package com.philspelman.springrelationshipsproductsm2m.services;

import com.philspelman.springrelationshipsproductsm2m.models.Category;
import com.philspelman.springrelationshipsproductsm2m.models.CategoryProduct;
import com.philspelman.springrelationshipsproductsm2m.models.Product;
import com.philspelman.springrelationshipsproductsm2m.repositories.CategoryProductRepository;
import com.philspelman.springrelationshipsproductsm2m.repositories.CategoryRepository;
import com.philspelman.springrelationshipsproductsm2m.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    //hook up repo
    private CategoryRepository categoryRepository;
    private final CategoryProductRepository categoryProductRepository;
    private final ProductRepository productRepository;




    public CategoryService(CategoryRepository categoryRepository,
                           CategoryProductRepository categoryProductRepository,
                           ProductRepository productRepository) {

        this.categoryRepository = categoryRepository;
        this.categoryProductRepository = categoryProductRepository;
        this.productRepository = productRepository;

    }

    public void addCategory(Category category) {
        this.categoryRepository.save(category);

        if (this.categoryRepository.findAll().size() < 1) {
            //make some new categories
        }
    }

//    public void associateProductWithCategory(Product product, Category category) {
    public void associateProductWithCategory(Long product_id, Long category_id) {

        Optional<Product> product = productRepository.findById(product_id);
        Optional<Category> category = categoryRepository.findById(category_id);

        if (category.isPresent() && product.isPresent()) {
            CategoryProduct association = new CategoryProduct();
            association.setCategory(category.get());
            association.setProduct(product.get());
            this.categoryProductRepository.save(association);
        }


    }
    //todo: pull all categories

    //todo: pull all categories NOT on a list



    public void destroyCategory(Long id) {
        //try to destroy the category
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }
}
