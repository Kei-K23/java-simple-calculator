package dev.kei;
import static java.lang.Double.NaN;

public class Calculator {
    // methods for calculating for two numbers calculations
    public enum BiOperationMethods {
        NORMAL, ADD, MINUS, MULTIPLY, DIVIDE, X_POWER_OF_Y
    }

    // methods for calculating for one number calculations
    public enum MonoOperationMethods {
        SQUARE_ROOT, SQUARE, ONE_DIVIDED_BY, COS, SIN, TAN, LOG, RATE, ABS, LN
    }

    private Double num1, num2;
    private BiOperationMethods mode = BiOperationMethods.NORMAL;

    private Double calculateBiHelper() {
        if (mode.equals(BiOperationMethods.NORMAL)) {
            return num2;
        }

        if (mode.equals(BiOperationMethods.ADD)) {
            if (num2 != 0) {
                return num1 + num2;
            }
            return num1;
        }

        if (mode.equals(BiOperationMethods.MINUS)) {
            return num1 - num2;
        }

        if (mode.equals(BiOperationMethods.MULTIPLY)) {
            return num1 * num2;
        }

        if (mode.equals(BiOperationMethods.DIVIDE)) {
            return num1 / num2;
        }

        if (mode.equals(BiOperationMethods.X_POWER_OF_Y)) {
            return Math.pow(num1, num2);
        }

        throw new RuntimeException("Invalid operation");
    }

    public Double calculateBi(BiOperationMethods methods, Double num) {
        if(methods.equals(BiOperationMethods.NORMAL)) {
            num2 = 0.0;
            num1 = num;
            mode = methods;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiHelper();
            mode = methods;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperationMethods.NORMAL, num);
    }

    public Double reset() {
        num1 = 0.0;
        num2 = 0.0;
        mode = BiOperationMethods.NORMAL;

        return NaN;
    }

    public Double calculateMono(MonoOperationMethods methods, Double num) {
        if (methods.equals(MonoOperationMethods.SQUARE)) {
            return num * num;
        }

        if (methods.equals(MonoOperationMethods.SQUARE_ROOT)) {
            return Math.sqrt(num);
        }

        if (methods.equals(MonoOperationMethods.ONE_DIVIDED_BY)) {
            return 1 / num;
        }

        if (methods.equals(MonoOperationMethods.COS)) {
            return Math.cos(Math.toRadians(num));
        }

        if (methods.equals(MonoOperationMethods.SIN)) {
            return Math.sin(Math.toRadians(num));
        }

        if (methods.equals(MonoOperationMethods.TAN)) {
            if (num == 0 || num % 100 == 0) {
                return 0.0;
            }
            if (num % 90 == 0.0 && num % 100 != 0.0) {
                return NaN;
            }
            return Math.tan(Math.toRadians(num));
        }

        if (methods.equals(MonoOperationMethods.LOG)) {
            return Math.log10(num);
        }

        if (methods.equals(MonoOperationMethods.LN)) {
            return Math.log(num);
        }

        if (methods.equals(MonoOperationMethods.ABS)) {
            return Math.abs(num);
        }

        if (methods.equals(MonoOperationMethods.RATE)) {
            return num / 100;
        }

        throw new RuntimeException("Invalid operation");
    }

}
