package jp.co.aivick.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import jp.co.aivick.demo.dao.RecipeDao;
import jp.co.aivick.demo.domain.Calory;
import jp.co.aivick.demo.entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest
{
    @Mock
    RecipeDao recipeDao;

    RecipeService recipeService;

    @BeforeEach
    public void before() {
        recipeService = new RecipeService(recipeDao);
    }

    @Test
    void idで検索できる() {
        var expect = recipe(1, "recipe1", 100);

        when(recipeDao.find(1)).thenReturn(expect);

        var actual = recipeService.findBy(1);

        assertEquals(expect, actual);
    }

    @Test
    void 全件検索できる() {
        var expect1 = recipe(1, "recipe1", 100);
        var expect2 = recipe(2, "recipe2", 200);

        when(recipeDao.findAll()).thenReturn(List.of(expect1, expect2));
        var actual = recipeService.findAll();

        assertEquals(List.of(expect1, expect2), actual.all());
    }

    private Recipe recipe(int id, String name, double cal) {
        var recipe = new Recipe();
        recipe.setId(id);
        recipe.setName(name);
        recipe.setCal(new Calory(cal));
        return recipe;
    }
}
