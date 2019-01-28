package com.example.recipe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**to avoid a circular dependency*/
@Data
@EqualsAndHashCode(exclude = {"recipe"})
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
}
