package jp.co.aivick.demo.dao;

import jp.co.aivick.demo.entity.Menu;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface MenuDao
{
    @Select
    Menu find(Integer menuId);

    @Insert
    int create(Menu menu);

    @Update
    int update(Menu menu);
}
