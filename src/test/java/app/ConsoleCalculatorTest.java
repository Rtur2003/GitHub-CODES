package app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ConsoleCalculatorTest {

    @Test
    void runsFullSessionAndPrintsFinalResult() {
        String input = String.join(System.lineSeparator(),
                "10",
                "+",
                "5",
                "*",
                "2",
                "=");

        String output = runWithInput(input);

        assertTrue(output.contains("Ara sonuç: 15.0"));
        assertTrue(output.contains("Nihai sonuç: 30.0"));
    }

    @Test
    void recoversFromInvalidOperationAndDivisionByZero() {
        String input = String.join(System.lineSeparator(),
                "3",
                "x",
                "/",
                "0",
                "+",
                "4",
                "q");

        String output = runWithInput(input);

        assertTrue(output.contains("Geçersiz işlem"));
        assertTrue(output.contains("Sıfıra bölme yapılamaz"));
        assertTrue(output.contains("Nihai sonuç: 7.0"));
    }

    private String runWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream((input + System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try (Scanner scanner = new Scanner(in);
             PrintStream printStream = new PrintStream(out, true, StandardCharsets.UTF_8)) {
            new ConsoleCalculator(new Calculator(), scanner, printStream).run();
        }

        return out.toString(StandardCharsets.UTF_8);
    }
}
