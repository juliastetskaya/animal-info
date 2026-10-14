import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void shouldPrintCatInformation() {
        String input = "1\ncat\nBarsik\n3\n";
        Scanner scanner = new Scanner(input);

        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));
            Main.run(scanner);

        } finally {
            System.setOut(originalOut);
            scanner.close();
        }

        String expected = "Cat name = Barsik, age = 3"
                + System.lineSeparator();

        assertEquals(expected, output.toString());
    }

    @Test
    void shouldPrintErrorForUnsupportedPetType() {
        String input = "1\nhamster\n";
        Scanner scanner = new Scanner(input);

        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));
            Main.run(scanner);
        } finally {
            System.setOut(originalOut);
            scanner.close();
        }

        String expected =
                "Incorrect input. Unsupported pet type"
                        + System.lineSeparator();

        assertEquals(expected, output.toString());
    }

    @Test
    void shouldRejectPetWithZeroAge() {
        String input = "1\ncat\nBarsik\n0\n";
        Scanner scanner = new Scanner(input);

        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));

            Main.run(scanner);

        } finally {
            System.setOut(originalOut);
            scanner.close();
        }

        String expected =
                "Incorrect input. Age <= 0"
                        + System.lineSeparator();

        assertEquals(expected, output.toString());
    }

    @Test
    void shouldRetryWhenAgeIsNotANumber() {
        String input = "1\ncat\nBarsik\nabc\n3\n";
        Scanner scanner = new Scanner(input);

        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));

            Main.run(scanner);

        } finally {
            System.setOut(originalOut);
            scanner.close();
        }

        String expected =
                "Could not parse a number. Please, try again"
                        + System.lineSeparator()
                        + "Cat name = Barsik, age = 3"
                        + System.lineSeparator();

        assertEquals(expected, output.toString());
    }
}
