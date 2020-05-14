public class CalorieOverSpec implements MenuSpec
{
    final private double calorie;

    public CalorieOverSpec(double calorie) {
        this.calorie = calorie;
    }

    @Override
    public boolean satisifedBy(Menu menu) {
        return menu.getCal() > this.calorie;
    }
}
