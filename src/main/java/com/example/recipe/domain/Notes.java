package com.example.recipe.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // the owner is the Recipe class! So if we want to delete a recipe we will delete the Notes but not viceversa :)
    //ONE TO ONE abbiamo in entrambe le tabelle una foreign key, in questo aso per Recipe e nella classe recipe per NOte_id
    @OneToOne
    private Recipe recipe;

    //hibernate maximum 255 chars, so we need to
    //SO WE CA HAVE a long string
    @Lob
    private String recipeNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
