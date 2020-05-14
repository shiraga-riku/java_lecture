public class Calculator
{
    public static void main(String[] args) {
        Operator operator = Operator.create(args[0]);
        Double result = operator.calc(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        System.out.println(result);
    }
}

interface Operator
{
    public double calc(double num1, double num2);

    public static Operator create(String op) {
        switch (op) {
            case "+":
                return new Plus();
            case "-":
                return new Minus();
            case "m":
                return new Multiply();
            case "/":
                return new Divide();
            default:
                throw new IllegalArgumentException("Unknown operator:" + op);
        }
    }
}

class Plus implements Operator
{
    @Override
    public double calc(double num1, double num2) {
        return num1 + num2;
    }
}

class Minus implements Operator
{
    @Override
    public double calc(double num1, double num2) {
        return num1 - num2;
    }
}

class Multiply implements Operator
{
    @Override
    public double calc(double num1, double num2) {
        return num1 * num2;
    }
}

class Divide implements Operator
{
    @Override
    public double calc(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("cant divide by zero.");
        }
        return num1 / num2;
    }
}
