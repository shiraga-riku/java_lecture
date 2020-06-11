package jp.co.aivick.demo.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.aivick.demo.entity.Recipe;

public class RecipeSet<T extends Recipe>
{
    final private List<T> recipes;

    public RecipeSet(List<T> recipes) {
        this.recipes = recipes;
    }

    public Calory calMax() {
        var max = this.recipes.stream()
                              .mapToDouble(r -> r.getCal()
                                                 .getValue())
                              .max();
        return Calory.of(max.orElseGet(() -> 0));
    }

    public Calory calMin() {
        var min = this.recipes.stream()
                              .mapToDouble(r -> r.getCal()
                                                 .getValue())
                              .min();
        return Calory.of(min.orElseGet(() -> 0));
    }

    public Calory calAverage() {
        var avg = this.recipes.stream()
                              .mapToDouble(r -> r.getCal()
                                                 .getValue())
                              .average();
        return Calory.of(avg.orElseGet(() -> 0));
    }

    public List<T> all() {
        return Collections.unmodifiableList(this.recipes);
    }

    public boolean contains(Integer recipeId) {
        return this.recipes.stream()
                           .anyMatch(r -> r.getId()
                                           .intValue() == recipeId.intValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecipeSet<?> recipeSet = (RecipeSet<?>) o;
        return Objects.equals(recipes, recipeSet.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipes);
    }
}
