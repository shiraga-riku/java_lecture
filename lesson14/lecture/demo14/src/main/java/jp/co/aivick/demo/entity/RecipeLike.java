package jp.co.aivick.demo.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.In;
import org.seasar.doma.Table;

@Entity
@Table(name = "recipe_likes")
public class RecipeLike
{
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Id
    @Column(name = "recipe_id")
    private Integer recipeId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }
}
