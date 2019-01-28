package com.example.recipe.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class UnitOfMeasure {
//BE CAREFULL IN THE DATA.SQL used by spring to set data in the initialize of the db, put unity_of_measure

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;
}
