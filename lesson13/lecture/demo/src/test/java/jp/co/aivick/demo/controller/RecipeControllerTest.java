package jp.co.aivick.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.aivick.demo.domain.Calory;
import jp.co.aivick.demo.domain.RecipeSet;
import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.service.RecipeService;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RecipeController.class)
class RecipeControllerTest
{
    @Autowired
    MockMvc mockMvc;

    @MockBean
    RecipeService recipeService;

    @Test
    void サービスから取得したレシピセットがmodelに設定される() throws Exception {

        when(recipeService.findAll()).thenReturn(
            new RecipeSet(List.of(recipe(1, "recipe1", 100), recipe(2, "recipe2", 200))));

        this.mockMvc.perform(get("/recipes"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(view().name("recipe.html"))
                    .andExpect(model().attribute("recipeSet", new RecipeSet(
                        List.of(recipe(1, "recipe1", 100), recipe(2, "recipe2", 200)))));
    }

    private Recipe recipe(int id, String name, double cal) {
        var recipe = new Recipe();
        recipe.setId(id);
        recipe.setName(name);
        recipe.setCal(new Calory(cal));
        return recipe;
    }
}

