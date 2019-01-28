package com.example.recipe.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    // this means that those recipe are mapped by categories in the only one table!
    // in this file you save the recipe are mapped by categories, but the categories are loosing their strength :)
    // but it mean that the table will be defined in the other side of the relationship so
    // we can see the Join table annotation in the Recipe java class
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet<>();
}
