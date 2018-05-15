package com.philspelman.springrelationshipsproductsm2m.controllers;

import com.philspelman.springrelationshipsproductsm2m.models.Product;
import com.philspelman.springrelationshipsproductsm2m.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
public class ProductController {
    //todo: hookup the ninja service
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //todo: CRUD routes

    @RequestMapping("/")
    public String indexRoute(Model model) {
        return "index";
    }


    @RequestMapping("/products/all")
    public String showAllProducts(Model model) {
        return "viewProductsAll";
    }



    @RequestMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {

        return "formProductNew";
    }

    @PostMapping("/products/new")
    public String newProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formProductNew";
        } else {
            this.productService.addProduct(product);
            return "redirect:/";
        }
    }

    @RequestMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.destroyProduct(id);
        return "redirect:/";
    }

}
