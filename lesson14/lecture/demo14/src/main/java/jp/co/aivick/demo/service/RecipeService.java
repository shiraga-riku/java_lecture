package jp.co.aivick.demo.service;

import jp.co.aivick.demo.dao.RecipeDao;
import jp.co.aivick.demo.domain.RecipeSet;
import jp.co.aivick.demo.entity.Recipe;
import org.springframework.stereotype.Service;

@Service
public class RecipeService
{
    private RecipeDao recipeDao;

    public RecipeService(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public Recipe findBy(Integer id) {
        return recipeDao.find(id);
    }

    public RecipeSet findAll() {
        return new RecipeSet(this.recipeDao.findAll());
    }
}


