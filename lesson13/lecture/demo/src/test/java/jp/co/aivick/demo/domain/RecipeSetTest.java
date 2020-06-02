package jp.co.aivick.demo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import jp.co.aivick.demo.entity.Recipe;
import org.junit.jupiter.api.Test;

class RecipeSetTest
{
    @Test
    void レシピが空の場合は最大カロリーはzeroとなる() {
        var sut = new RecipeSet(Collections.emptyList());

        assertEquals(new Calory(0), sut.calMax());
        assertEquals(new Calory(0), sut.calMin());
        assertEquals(new Calory(0), sut.calAverage());
    }

    @Test
    void レシピの最大_最小_平均値が取得できる() {
        var sut = new RecipeSet(
            List.of(recipe(1, "recipe1", 100.0),
                recipe(2, "recipe2", 200.0),
                recipe(3, "recipe3", 300.0)
            )
        );

        assertEquals(new Calory(300), sut.calMax());
        assertEquals(new Calory(100), sut.calMin());
        assertEquals(new Calory(200), sut.calAverage());
    }

    private Recipe recipe(int id, String name, Double cal) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setId(id);
        recipe.setCal(new Calory(cal));
        return recipe;
    }
}


