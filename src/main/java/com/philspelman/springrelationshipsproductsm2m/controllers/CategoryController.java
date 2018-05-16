package com.philspelman.springrelationshipsproductsm2m.controllers;


import com.philspelman.springrelationshipsproductsm2m.models.Category;
import com.philspelman.springrelationshipsproductsm2m.models.CategoryProduct;
import com.philspelman.springrelationshipsproductsm2m.repositories.CategoryProductRepository;
import com.philspelman.springrelationshipsproductsm2m.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/categories/")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    //todo: CRUD routes


    @RequestMapping("/view/{id}")
    public String viewCategory(@PathVariable("id") Long id,
                                         Model model,
                                         RedirectAttributes redirectAttributes) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "viewCategoryAndProducts";
        } else {
            redirectAttributes.addFlashAttribute("get_by_id_error", "no category with that ID was found");
            return "redirect:/";
        }
    }

    @RequestMapping("/new")
    public String newCategory(@ModelAttribute("category") Category category) {

        return "formCategoryNew";
    }

    @PostMapping("/new")
    public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "categoryFormNew";
        } else {
            this.categoryService.addCategory(category);
            return "redirect:/";
        }
    }

    @RequestMapping("/add_product_to_category/{product_id}/{category_id}")
    public String addProductToCategory(@PathVariable("product_id") Long product_id,
                                       @PathVariable("category_id") Long category_id) {

        this.categoryService.associateProductWithCategory(product_id, category_id);
        return "redirect:/";

    }

    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.destroyCategory(id);
        return "redirect:/";
    }

}
