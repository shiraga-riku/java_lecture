package jp.co.aivick.demo.form.admin;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import jp.co.aivick.demo.domain.MenuType;

public class MenuForm
{
    public static class RecipeForm
    {
        @NotNull
        private Integer id;
        @NotEmpty
        private String name;
        @NotNull
        private Boolean selected = false;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getSelected() {
            return selected;
        }

        public void setSelected(Boolean selected) {
            this.selected = selected;
        }
    }

    private Integer id;

    @NotEmpty
    private String name;

    @NotNull
    private Integer type;

    @Valid
    @NotEmpty
    private List<RecipeForm> recipes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public MenuType[] getMenuTypes() {
        return MenuType.values();
    }

    public List<RecipeForm> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeForm> recipeForms) {
        this.recipes = recipeForms;
    }

    public boolean recipeSelected() {
        return this.recipes.stream()
                           .anyMatch(r -> r.getSelected());
    }
}
