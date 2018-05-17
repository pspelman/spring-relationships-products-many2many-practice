package com.philspelman.springrelationshipsproductsm2m.controllers;

import com.philspelman.springrelationshipsproductsm2m.models.Category;
import com.philspelman.springrelationshipsproductsm2m.models.CategoryProductIdentity;
import com.philspelman.springrelationshipsproductsm2m.models.Product;
import com.philspelman.springrelationshipsproductsm2m.repositories.CategoryProductRepository;
import com.philspelman.springrelationshipsproductsm2m.services.CategoryService;
import com.philspelman.springrelationshipsproductsm2m.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    //todo: hookup the ninja service
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService,
                             CategoryService categoryService) {

        this.productService = productService;
        this.categoryService = categoryService;
    }

    //todo: CRUD routes

    @RequestMapping("/")
    public String indexRoute(Model model) {
        return "index";
    }


    @RequestMapping("/products/all")
    public String showAllProducts(Model model) {

        model.addAttribute("products", productService.allProducts());

        return "viewProductsAll";
    }

    @RequestMapping("/products/view/{id}")
    public String viewProduct(@PathVariable("id") Long id,
                              Model model,
                              RedirectAttributes redirectAttributes) {

        Optional<Product> product = productService.getProductById(id);

        //todo: get all the categories
        List<Category> allCategories = categoryService.allCategories();

        //todo: separate the categories already used and still available

        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            model.addAttribute("categories", allCategories);
            return "viewProductAndCategories";
        } else {
            redirectAttributes.addFlashAttribute("get_by_id_error", "no product with that ID was found");
            return "redirect:/";
        }
    }


        @RequestMapping("/products/new")
        public String newProduct (@ModelAttribute("product") Product product){
            return "formProductNew";
        }

        @PostMapping("/products/new")
        public String newProduct (@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
            if (bindingResult.hasErrors()) {
                return "formProductNew";
            } else {
                this.productService.addProduct(product);
                return "redirect:/";
            }
        }

        @RequestMapping("/product/delete/{id}")
        public String deleteProduct (@PathVariable("id") Long id){
            productService.destroyProduct(id);
            return "redirect:/";
        }

    }
