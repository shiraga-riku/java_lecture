package jp.co.aivick.demo.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.aivick.demo.entity.Recipe;

public class RecipeSet
{
    final private List<Recipe> recipes;

    public RecipeSet(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Calory calMax() {
        var max = this.recipes.stream()
                              .mapToDouble(r -> r.getCal()
                                                 .value())
                              .max();
        return new Calory(max.orElseGet(() -> 0));
    }

    public Calory calMin() {
        var min = this.recipes.stream()
                              .mapToDouble(r -> r.getCal()
                                                 .value())
                              .min();
        return new Calory(min.orElseGet(() -> 0));
    }

    public Calory calAverage() {
        var avg = this.recipes.stream()
                              .mapToDouble(r -> r.getCal()
                                                 .value())
                              .average();
        return new Calory(avg.orElseGet(() -> 0));
    }

    public List<Recipe> all() {
        return Collections.unmodifiableList(this.recipes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecipeSet recipeSet = (RecipeSet) o;
        return Objects.equals(recipes, recipeSet.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipes);
    }
}
