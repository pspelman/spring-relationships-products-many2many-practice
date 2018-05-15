package com.philspelman.springrelationshipsproductsm2m.controllers;


import com.philspelman.springrelationshipsproductsm2m.models.Category;
import com.philspelman.springrelationshipsproductsm2m.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/categories/")
public class CategoryController {

    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //todo: CRUD routes


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

    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.destroyCategory(id);
        return "redirect:/";
    }

}
