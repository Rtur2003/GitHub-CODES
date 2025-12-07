package app;

import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

public final class ConsoleCalculator {
    private final Calculator calculator;
    private final Scanner scanner;
    private final PrintStream out;

    public ConsoleCalculator(Calculator calculator, Scanner scanner, PrintStream out) {
        this.calculator = calculator;
        this.scanner = scanner;
        this.out = out;
    }

    public void run() {
        out.println("=== Sürekli Hesap Makinesi ===");

        Optional<Double> startValue = promptForNumber("Başlangıç sayısını girin:");
        if (startValue.isEmpty()) {
            out.println("Girdi akışı kapandı. Çıkılıyor.");
            return;
        }

        double current = startValue.get();

        while (true) {
            Optional<String> operationInput = readNextToken("İşlem girin (+, -, *, /). Bitirmek için '=' veya 'q' yazın:");
            if (operationInput.isEmpty()) {
                out.println("Girdi akışı kapandı. Çıkılıyor.");
                break;
            }

            String rawOperation = operationInput.get();
            if (shouldExit(rawOperation)) {
                break;
            }

            Optional<Operation> operation = parseOperation(rawOperation);
            if (operation.isEmpty()) {
                out.println("Hata: Geçersiz işlem. Geçerli operatörler: + - * / veya çıkmak için '=' / q.");
                continue;
            }

            Optional<Double> operand = promptForNumber("Bir sonraki sayıyı girin:");
            if (operand.isEmpty()) {
                out.println("Girdi akışı kapandı. Çıkılıyor.");
                break;
            }

            try {
                current = calculator.apply(current, operation.get(), operand.get());
                out.println("Ara sonuç: " + current);
            } catch (IllegalArgumentException ex) {
                out.println("Hata: " + ex.getMessage());
            }
        }

        out.println("Nihai sonuç: " + current);
    }

    private Optional<String> readNextToken(String prompt) {
        while (true) {
            Optional<String> line = nextLine(prompt);
            if (line.isEmpty()) {
                return Optional.empty();
            }
            String trimmed = line.get().trim();
            if (!trimmed.isEmpty()) {
                return Optional.of(trimmed);
            }
            out.println("Hata: Boş giriş algılandı. Lütfen bir değer yazın.");
        }
    }

    private Optional<String> nextLine(String prompt) {
        out.println(prompt);
        if (!scanner.hasNextLine()) {
            return Optional.empty();
        }
        return Optional.of(scanner.nextLine());
    }

    private Optional<Double> promptForNumber(String prompt) {
        while (true) {
            Optional<String> input = readNextToken(prompt);
            if (input.isEmpty()) {
                return Optional.empty();
            }
            String normalized = input.get().replace(',', '.');
            try {
                return Optional.of(Double.parseDouble(normalized));
            } catch (NumberFormatException ex) {
                out.println("Hata: Geçersiz sayı. Lütfen tekrar deneyin.");
            }
        }
    }

    private Optional<Operation> parseOperation(String value) {
        if (value.length() != 1) {
            return Optional.empty();
        }
        return Operation.fromSymbol(value.charAt(0));
    }

    private boolean shouldExit(String value) {
        return "=".equals(value) || "q".equalsIgnoreCase(value) || "quit".equalsIgnoreCase(value)
                || "exit".equalsIgnoreCase(value);
    }
}
