package com.philspelman.springrelationshipsproductsm2m.services;

import com.philspelman.springrelationshipsproductsm2m.models.Product;
import com.philspelman.springrelationshipsproductsm2m.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

        if (this.productRepository.findAll().size() < 1) {
            //add some new products

        }
    }
    private void addNewProducts() {
        this.productRepository.save(new Product());
        this.productRepository.save(new Product());
        this.productRepository.save(new Product());
    }


    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    public void destroyProduct(Long id) {
        this.productRepository.deleteById(id);

    }
}
