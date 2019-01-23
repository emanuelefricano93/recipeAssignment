package com.example.recipe.repositories;

import com.example.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// this intergace will be implemented automatically by hibernate, providing the class and the Id
public interface CategoryRepository extends CrudRepository<Category, Long> {
    //unelievable but JPA is wonderful!! because you need to follow this convention description
    // find by description! e poi ci pensare Spring Data Jpa a implementare questa roba e tirare su i dati!
    Optional<Category> findByDescription(String description);
}
