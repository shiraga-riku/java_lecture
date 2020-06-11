package jp.co.aivick.demo.dao;

import java.util.List;
import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.entity.RecipeLikedUser;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface RecipeDao
{
    @Select
    Recipe find(Integer id);

    @Select
    List<Recipe> findAll(String recipeName);

    @Select
    List<RecipeLikedUser> findAllWithLike(Integer userId);

    @Select
    List<Recipe> findByMenuId(Integer menuId);

    @Insert
    int create(Recipe recipe);

    @Update
    int update(Recipe recipe);
}


