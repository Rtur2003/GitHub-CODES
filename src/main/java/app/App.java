package app;

import java.util.Scanner;

public final class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleCalculator consoleCalculator = new ConsoleCalculator(new Calculator(), scanner, System.out);
            consoleCalculator.run();
        }
    }
}
