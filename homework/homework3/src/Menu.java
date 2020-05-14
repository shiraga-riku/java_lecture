import java.util.Collections;
import java.util.List;

public class Menu
{
    final private String name;
    final private String type;
    final private List<Recipe> recipes;

    public Menu(String name, String type, List<Recipe> recipes) {
        this.name = name;
        this.type = type;
        this.recipes = Collections.unmodifiableList(recipes);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<Recipe> getRecipes() {
        return this.recipes;
    }

    public double getCal() {
        return this.recipes
            .stream()
            .mapToDouble(Recipe::getCalorie)
            .sum();
    }
}
