package jp.co.aivick.demo.service;

import jp.co.aivick.demo.dao.RecipeDao;
import jp.co.aivick.demo.dao.RecipeLikeDao;
import jp.co.aivick.demo.domain.RecipeSet;
import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.entity.RecipeLike;
import jp.co.aivick.demo.entity.RecipeLikedUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecipeService
{
    private RecipeDao recipeDao;

    private RecipeLikeDao recipeLikeDao;

    public RecipeService(RecipeDao recipeDao, RecipeLikeDao recipeLikeDao) {
        this.recipeDao = recipeDao;
        this.recipeLikeDao = recipeLikeDao;
    }

    public Recipe findBy(Integer id) {
        return recipeDao.find(id);
    }

    public RecipeSet<Recipe> findAll() {
        return new RecipeSet<Recipe>(this.recipeDao.findAll());
    }

    public RecipeSet<RecipeLikedUser> findAllWithLike(Integer userId) {
        return new RecipeSet<RecipeLikedUser>(this.recipeDao.findAllWithLike(userId));
    }

    @Transactional
    public void like(Integer userId, Integer recipeId, Boolean doLike) {
        var recipeLike = new RecipeLike();
        recipeLike.setUserId(userId);
        recipeLike.setRecipeId(recipeId);

        this.recipeLikeDao.delete(recipeLike);
        if (doLike) {
            this.recipeLikeDao.insert(recipeLike);
        }
    }
}


