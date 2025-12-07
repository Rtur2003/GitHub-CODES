package app;

import java.util.Arrays;
import java.util.Optional;

public enum Operation {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char symbol;

    Operation(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static Optional<Operation> fromSymbol(char symbol) {
        return Arrays.stream(values())
                .filter(op -> op.symbol == symbol)
                .findFirst();
    }
}
