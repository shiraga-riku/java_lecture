package jp.co.aivick.demo.controller;

import jp.co.aivick.demo.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeController
{
    final private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping
    public String recipes(Model model) {
        model.addAttribute("recipeSet", recipeService.findAll());
        return "recipe.html";
    }
}
