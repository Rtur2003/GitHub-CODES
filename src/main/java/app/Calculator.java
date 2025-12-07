package app;

public final class Calculator {

    public double apply(double current, Operation operation, double operand) {
        return switch (operation) {
            case ADD -> current + operand;
            case SUBTRACT -> current - operand;
            case MULTIPLY -> current * operand;
            case DIVIDE -> divide(current, operand);
        };
    }

    private double divide(double current, double operand) {
        if (operand == 0.0d) {
            throw new IllegalArgumentException("Sıfıra bölme yapılamaz.");
        }
        return current / operand;
    }
}
