package com.example.recipe.repositories;

import com.example.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

// this intergace will be implemented automatically by hibernate, providing the class and the Id
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
