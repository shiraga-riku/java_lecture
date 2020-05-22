package jp.co.aivick.doma.dao;

import java.util.List;
import jp.co.aivick.doma.AppConfig;
import jp.co.aivick.doma.entity.Menu;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;

@Dao(config = AppConfig.class)
public interface MenuDao
{
    @Select
    public List<Menu> findAll();

    @Select
    public List<Menu> findByName(String name);
}
