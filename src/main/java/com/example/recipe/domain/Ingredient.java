package com.example.recipe.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    //if we delete an ingredient we don t want to delete the recipe
    //in this case each ingrediente is inside a Recipe that s it!
    //in the single class of ingrediente you are saying many ingrediente to one recipe and yu are puttin in this variable
    //the connenction between each ignediente and the recipe to it is refering
    // Many to one completa la relzioni dall latro lato e si tiene la foreign key di una recipe
    @ManyToOne
    private Recipe recipe;
    // this is not bi-derictional because an Ingredient need a unit of measure but not the opposite
    // we don t want to delete a unit of measure if you delete this ingrediente for instance!
    // it is retrieved every time from the database
    // so the fetch will say we need to call the unitofMeasure immediately or not ? if you say eager you want always immediately (this is
    // the default, if you want Lazy it will call from JPA through Hibernate only when the method getUnitOfMEAASURE WILL BE called
    // this is good when you have for instance a listof students inside a University entity , it is better to call only when you need
    //really to access to them, but in this case is a bit irrelevant
    // tu vuoi gli ingrediente allora ci sara anche qui una colonna esterna per l unita di misura id
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitOfMeasure;

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.recipe = recipe;
        this.unitOfMeasure = unitOfMeasure;
    }

    public void setRecipe(Recipe recipe) {
        recipe.addIngredient(this);
        this.recipe = recipe;
    }
}
