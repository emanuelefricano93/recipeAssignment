package com.example.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipeApplication {

    public static void main(String[] args) {

        System.out.println("ciao3");// ctrl shift a -> registry compiler.automake.allow.when.app.running to unselecte to deactiate
        // and anslo ctrl alt s and disalbe compiler -> coiler automatically
        SpringApplication.run(RecipeApplication.class, args);
    }

}

