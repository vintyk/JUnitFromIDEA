package by.vinty.entity;

public class CalculatorImpl implements Calculator{

    
    public double calculate(String expression) {
        return Double.parseDouble(expression);
    }
}
