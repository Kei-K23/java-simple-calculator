package dev.kei;
import javax.swing.*;

public class Calculator {
    private static UI ui;

    public Calculator(UI ui) {
        Calculator.ui = ui;
    }

    public static double calculateResult(double firstNumber, double secondNumber, String operator) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                if (secondNumber != 0) {
                    return firstNumber / secondNumber;
                } else {
                    JOptionPane.showMessageDialog(ui, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            default:
                return 0;
        }
    }
}
