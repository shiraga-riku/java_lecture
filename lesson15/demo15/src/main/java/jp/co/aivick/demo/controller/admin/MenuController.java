package jp.co.aivick.demo.controller.admin;

import java.util.List;
import java.util.stream.Collectors;
import jp.co.aivick.demo.domain.MenuType;
import jp.co.aivick.demo.domain.RecipeSet;
import jp.co.aivick.demo.entity.Menu;
import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.form.admin.MenuForm;
import jp.co.aivick.demo.form.admin.MenuForm.RecipeForm;
import jp.co.aivick.demo.service.MenuService;
import jp.co.aivick.demo.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/menu")
public class MenuController
{
    MenuService menuService;

    RecipeService recipeService;

    public MenuController(MenuService menuService, RecipeService recipeService) {
        this.menuService = menuService;
        this.recipeService = recipeService;
    }

    @GetMapping("/create")
    public String showCreateForm(MenuForm menuForm) {
        var recipeSet = recipeService.findAll(null);
        menuForm.setRecipes(this.toRecipeForms(recipeSet));
        return "admin/menu/create";
    }

    @PostMapping("/create")
    public String create(@Validated MenuForm menuForm, BindingResult bindingResult) {
        if (!menuForm.recipeSelected()) {
            bindingResult.addError(
                new FieldError(bindingResult.getObjectName(), "recipe", "レシピを選択してください。"));
        }

        if (bindingResult.hasErrors()) {
            return "admin/menu/create";
        }

        return updateMenuAndRedirect(menuForm, null);
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, MenuForm menuForm) {
        var menu = menuService.findBy(id);
        var menuRecipeSet = recipeService.findByMenuId(menu.getId());
        var allRecipeSet = recipeService.findAll(null);

        var recipeFormList = this.toRecipeForms(allRecipeSet);
        recipeFormList.forEach(recipeForm -> {
            if (menuRecipeSet.contains(recipeForm.getId())) {
                recipeForm.setSelected(true);
            }
        });

        menuForm.setId(id);
        menuForm.setName(menu.getName());
        menuForm.setType(menu.getType()
                             .getValue());
        menuForm.setRecipes(recipeFormList);

        return "admin/menu/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id, @Validated MenuForm menuForm,
        BindingResult bindingResult) {
        if (!menuForm.recipeSelected()) {
            bindingResult.addError(
                new FieldError(bindingResult.getObjectName(), "recipe", "レシピを選択してください。"));
        }
        if (bindingResult.hasErrors()) {
            return "admin/menu/update";
        }

        return updateMenuAndRedirect(menuForm, id);
    }

    private String updateMenuAndRedirect(MenuForm menuForm, Integer menuId) {
        Menu menu = new Menu();
        menu.setId(menuId);
        menu.setName(menuForm.getName());
        menu.setType(MenuType.valueOf(menuForm.getType()));
        var recipeIds = menuForm.getRecipes()
                                .stream()
                                .filter(RecipeForm::getSelected)
                                .map(RecipeForm::getId)
                                .collect(Collectors.toList());

        if (menuId == null) {
            menuService.create(menu, recipeIds);
        }
        else {
            menuService.update(menu, recipeIds);
        }

        return "redirect:/admin/menu/update/" + menu.getId();
    }

    private List<RecipeForm> toRecipeForms(RecipeSet<Recipe> recipeSet) {
        return recipeSet.all()
                        .stream()
                        .map(r -> {
                                MenuForm.RecipeForm recipeForm = new MenuForm.RecipeForm();
                                recipeForm.setId(r.getId());
                                recipeForm.setName(r.getName());
                                return recipeForm;
                            }
                        )
                        .collect(Collectors.toList());
    }
}
