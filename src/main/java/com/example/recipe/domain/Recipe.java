package com.example.recipe.domain;

import javax.persistence.*;
import java.util.HashSet;
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
    @Lob
    private String directions;
    //now we wnat to use also the relatioship mapped in the child ingredients by a property called recipe
    //you are cascading all the operation to the other class ( so a delete will delete the ingrediente bounded to this recipe)
    // how is bounded? through the recipe property,in the Ingrediente class on the recipe property we have the Many to one annotation
    // the opposite of the relationship
    // SO MAPPED means that the entity in this side (recipe) is the inverse of the relationship and the owner
    // of the realtionship is in the other (ingredeinte table) and there will be a foreing key recipe_id in the INGREDIENTE table
    // quindi dentro recipe non avremo nessuna colonna per gli ingredienti perche gia gli ingredienti sono mappati da una recipe
    // quindi nella loro tabella gli ingredeinti hanno una colonna per recipe_id
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();
    //large object binary!
    @Lob
    private Byte[] image;
    // I want the recipe is the owner of the Relationship specifying the cascade
    //if we delete the recipe in cascade we will delete also the note, but not the viceversa!
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    // ordinal is the default like 1 2 and 3, the default behaviour , but if you want to update is not so good
    // string is better without and integer order
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    // we are saying to hibernate that we want just this table for the relationship so
    // this will create ony the recipe_vategory with the boss recipe_id and the second column categgory_id
    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

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

    //cosi quando setti abbiamo gia la relazione senza doverla chiamarla su entrambi i nodi
    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
