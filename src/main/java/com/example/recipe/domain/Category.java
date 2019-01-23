package com.example.recipe.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;
    // this means that those recipe are mapped by categories in the only one table!
    // in this file you save the recipe are mapped by categories, but the categories are loosing their fight :)
    // but it mean that the table will be defined in the other side of the relationship so
    // we can see the Join table annotation in the Recipe java class
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet<>();


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
