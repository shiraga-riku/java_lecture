public class Recipe
{
    final private String name;
    final private double calorie;

    public Recipe(String name, double calorie) {
        this.name = name;
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public double getCalorie() {
        return calorie;
    }
}
