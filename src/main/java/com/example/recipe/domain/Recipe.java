package com.example.recipe.domain;

import javax.persistence.*;
import java.util.Set;

/*
* we need also the entity so we need the id value, we are in relational world
* */
@Entity
public class Recipe {

    //java genearaion annotation for id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    //now we wnat to use also the relatioship mapped in the child ingredients by a property called recipe
    //you are cascading all the operation to the other class ( so a delete will delete the ingrediente bounded to this recipe)
    // how is bounded? through the recipe property,in the Ingrediente class on the recipe property we have the Many to one annotation
    // the opposite of the relationship
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;
    //large object binary!
    @Lob
    private Byte[] image;
    // I want the recipe is the owner of the Relationship specifying the cascade
    //if we delete the recipe in cascade we will delete also the note, but not the viceversa!
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }
}
