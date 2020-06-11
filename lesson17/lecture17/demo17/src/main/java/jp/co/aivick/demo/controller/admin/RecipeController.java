package jp.co.aivick.demo.controller.admin;

import jp.co.aivick.demo.domain.Calory;
import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.form.admin.RecipeForm;
import jp.co.aivick.demo.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("AdminRecipeController")
@RequestMapping("/admin/recipe")
public class RecipeController
{
    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/list")
    public String recipes(@RequestParam(required = false) String name, Model model) {
        if (name == null || name.length() == 0) {
            name = null;
        }
        model.addAttribute("recipeSet", recipeService.findAll(name));
        return "admin/recipe/list";
    }

    @GetMapping("/create")
    public String showCreateForm(RecipeForm recipeForm) {
        return "admin/recipe/create";
    }

    @PostMapping("/create")
    public String create(@Validated  RecipeForm recipeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/recipe/create";
        }
        Recipe recipe = new Recipe();
        recipe.setName(recipeForm.getName());
        recipe.setCal(Calory.of(recipeForm.getCal()));
        this.recipeService.create(recipe);
        return "redirect:/admin/recipe/list";
    }
}
