package com.example.recipe.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        log.debug("Before each test we create instantiate the category");
        category = new Category();
    }

    @Test
    public void getId() {
        Long idValue = 4l;
        category.setId(4L);
        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}