package jp.co.aivick.demo.domain;

import java.util.Objects;
import org.seasar.doma.Domain;

@Domain(valueType = Double.class, factoryMethod = "of", accessorMethod = "getValue")
public class Calory
{
    final private double value;

    private Calory(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("calory must be over zero.");
        }
        this.value = value;
    }

    public static Calory of(final Double value) {
        return new Calory(value);
    }

    public Double getValue() {
        return this.value;
    }

    public Double getValue(int precision) {
        double x = Math.pow(10, precision);
        return Math.round(this.value * x) / x;
    }

    public String format() {
        return format(2);
    }

    public String format(int precision) {
        return String.format("%." + precision + "f Kcal", this.getValue());
    }

    @Override
    public String toString() {
        return format();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Calory calory = (Calory) o;
        return Double.compare(calory.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
