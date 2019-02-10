package com.example.recipe.services;

import com.example.recipe.domain.Recipe;
import com.example.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    // mock is from mockito, he will be able to be initialized by mockito
    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipies() {

        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);
        // we can mock every thing in the test and with method when of mockito we can say
        //that inside ths environment that method getRecipies will rethurn what we put in the thenReturn
        when(recipeService.getRecipies()).thenReturn(recipesData);


        // DOPO AVER SETTATO TUTTI I DATI QUI ANDIAMO A CHIAMARE IL METODO GETRECIPIES CHE ALL'ínterno chiama
        // IL MOCKATO recipeService.getRecipies() :) ritornando infatti la nostra lista presettata
        Set<Recipe> recipes = recipeService.getRecipies();

        assertEquals(recipes.size(), 1);
        // in this way you can see how manuy interaction you have with that class method
        verify(recipeRepository, times(1)).findAll();
    }
}