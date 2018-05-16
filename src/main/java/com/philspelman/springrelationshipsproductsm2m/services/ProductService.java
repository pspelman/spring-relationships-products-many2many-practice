package com.philspelman.springrelationshipsproductsm2m.services;

import com.philspelman.springrelationshipsproductsm2m.models.Product;
import com.philspelman.springrelationshipsproductsm2m.repositories.CategoryProductRepository;
import com.philspelman.springrelationshipsproductsm2m.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private final CategoryProductRepository categoryProductRepository;


    public ProductService(ProductRepository productRepository,
                          CategoryProductRepository categoryProductRepository) {

        this.productRepository = productRepository;
        this.categoryProductRepository = categoryProductRepository;

        if (this.productRepository.findAll().size() < 1) {
            //add some new products
            addNewProducts();
        }
    }
    private void addNewProducts() {
        this.productRepository.save(new Product("Shoe", "Nike", 50));
        this.productRepository.save(new Product("Turtle", "A ninja", 10));
        this.productRepository.save(new Product("Hammer", "A way to tell time", 2));

    }


    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    public void destroyProduct(Long id) {
        this.productRepository.deleteById(id);

    } 

    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
