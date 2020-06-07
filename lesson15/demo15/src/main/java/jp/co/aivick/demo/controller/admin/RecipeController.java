package jp.co.aivick.demo.controller.admin;

import jp.co.aivick.demo.domain.Calory;
import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.form.admin.RecipeForm;
import jp.co.aivick.demo.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminRecipeController")
@RequestMapping("/admin/recipe")
public class RecipeController
{
    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/create")
    public String showCreateForm(RecipeForm recipeForm) {
        return "admin/recipes/create.html";
    }

    @PostMapping("/create")
    public String create(@Validated  RecipeForm recipeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/recipe/create.html";
        }
        Recipe recipe = new Recipe();
        recipe.setName(recipeForm.getName());
        recipe.setCal(Calory.of(recipeForm.getCal()));
        this.recipeService.create(recipe);
        return "redirect:/admin/recipes/update/" + recipe.getId();
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Integer id, RecipeForm recipeForm) {
        var recipe = this.recipeService.findBy(id);
        recipeForm.setName(recipeForm.getName());
        recipeForm.setCal(recipe.getCal()
                                .getValue());
        return "admin/recipes/update.html";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @Validated  RecipeForm recipeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/recipes/update/" + String.valueOf(id);
        }
        var recipe = this.recipeService.findBy(id);
        recipe.setCal(Calory.of(recipeForm.getCal()));
        recipe.setName(recipeForm.getName());
        recipeService.update(recipe);
        return "redirect:/admin/recipes/update/" + recipe.getId();
    }
}
