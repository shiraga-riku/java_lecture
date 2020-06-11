package jp.co.aivick.demo.service;

import java.util.List;
import jp.co.aivick.demo.dao.MenuDao;
import jp.co.aivick.demo.dao.MenuRecipeDao;
import jp.co.aivick.demo.entity.Menu;
import jp.co.aivick.demo.entity.MenuRecipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuService
{
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private MenuRecipeDao menuRecipeDao;

    @Transactional
    public void create(Menu menu, List<Integer> recipeIds) {
        menuDao.create(menu);

        for (var recipeId : recipeIds) {
            MenuRecipe menuRecipe = new MenuRecipe();
            menuRecipe.setMenuId(menu.getId());
            menuRecipe.setRecipeId(recipeId);
            menuRecipeDao.create(menuRecipe);
        }
    }

    public Menu findBy(Integer menuId) {
        return menuDao.find(menuId);
    }

    @Transactional
    public void update(Menu menu, List<Integer> recipeIds) {
        menuDao.update(menu);
        menuRecipeDao.deleteAll(menu.getId());
        for (var recipeId : recipeIds) {
            MenuRecipe menuRecipe = new MenuRecipe();
            menuRecipe.setMenuId(menu.getId());
            menuRecipe.setRecipeId(recipeId);
            menuRecipeDao.create(menuRecipe);
        }
    }
}
