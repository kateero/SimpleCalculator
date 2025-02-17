package simplecalculator;

public class Calculator {
    //методы: add, subtract, multiply, divide
    public double multiply(double a, double b) {
        return a*b;
    }
    public String divide(double a, double b) {
        String message;
        double result;
        try {
            result = a/b;
            message = String.valueOf(result);
        } catch (ArithmeticException e) {
            message = "You can't divide by 0!";
        }
        return message;
    }
}
