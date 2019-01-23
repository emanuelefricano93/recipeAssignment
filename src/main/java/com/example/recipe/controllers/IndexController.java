package com.example.recipe.controllers;

import com.example.recipe.domain.Recipe;
import com.example.recipe.repositories.CategoryRepository;
import com.example.recipe.repositories.UnitOfMeasureRepository;
import com.example.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeService recipeService;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

       /* Optional<Category> category = this.categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasure = this.unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println(category.get().getId());
        System.out.println(unitOfMeasure.get().getId());*/
        HashSet<Recipe> recipes = (HashSet<Recipe>) this.recipeService.getRecipies();
        model.addAttribute("recipes", recipes);

        return "index";
    }

}
