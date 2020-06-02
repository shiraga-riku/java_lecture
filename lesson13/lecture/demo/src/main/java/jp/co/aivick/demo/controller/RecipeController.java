package jp.co.aivick.demo.controller;

import jp.co.aivick.demo.dao.RecipeDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeController
{
    private RecipeDao recipeDao;

    public RecipeController(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @RequestMapping
    public String recipes(Model model) {
        model.addAttribute("recipes", recipeDao.findAll());
        return "recipe.html";
    }
}
