package com.example.recipe.controllers;

import com.example.recipe.domain.Recipe;
import com.example.recipe.repositories.CategoryRepository;
import com.example.recipe.repositories.UnitOfMeasureRepository;
import com.example.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;

@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        log.debug("Index controller constructor");
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        HashSet<Recipe> recipes = (HashSet<Recipe>) this.recipeService.getRecipies();
        model.addAttribute("recipes", recipes);
        return "index";
    }

}
