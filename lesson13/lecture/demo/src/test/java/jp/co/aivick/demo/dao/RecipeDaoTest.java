package jp.co.aivick.demo.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import java.util.List;
import jp.co.aivick.demo.BaseDatabaseTest;
import jp.co.aivick.demo.domain.Calory;
import jp.co.aivick.demo.entity.Recipe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DatabaseSetup(value = "/test/recipes.xml", type = DatabaseOperation.INSERT)
@SpringBootTest
class RecipeDaoTest extends BaseDatabaseTest
{
    @Autowired
    RecipeDao recipeDao;

    @Test
    void IDを指定して検索できること() {
        Recipe actual = recipeDao.find(2);
        assertEquals(recipe(2, "サーモン", 150), actual);
    }

    @Test
    void 全件取得できること() {
        List<Recipe> actual = recipeDao.findAll();

        assertEquals(List.of(
            recipe(1, "ハンバーグ", 200),
            recipe(2, "サーモン", 150)
            ),
            actual
        );
    }

    private Recipe recipe(int id, String name, double cal) {
        Recipe r = new Recipe();
        r.setId(id);
        r.setName(name);
        r.setCal(new Calory(cal));
        return r;
    }
}
