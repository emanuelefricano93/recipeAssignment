package com.example.recipe.services;

import com.example.recipe.domain.Recipe;
import com.example.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements  RecipeService{

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipies() {
        log.debug("I'm in the recipe service impl");

        HashSet<Recipe> recipeSet = new HashSet<>();
        //quindi questo significa che seleziona l iterable e poi per ogni elemento passalo a quella funzione add di recipe.set
        // è come dire recipe -> recipeSet.add(recipe) just to be shorter :) JAVA 8 syntax
        this.recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }
}
