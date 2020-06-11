package jp.co.aivick.demo.dao;

import jp.co.aivick.demo.entity.MenuRecipe;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface MenuRecipeDao
{
    @Insert
    public int create(MenuRecipe menuRecipe);

    @Delete(sqlFile = true)
    int deleteAll(Integer menuId);
}
