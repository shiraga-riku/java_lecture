package jp.co.aivick.demo.dao;

import jp.co.aivick.demo.entity.RecipeLike;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface RecipeLikeDao
{
    @Insert
    public int insert(RecipeLike recipeLike);

    @Delete
    public int delete(RecipeLike recipeLike);
}
