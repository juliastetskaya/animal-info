import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    private PrintStream originalOut;
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 10})
    void shouldAcceptPetWithPositiveAge(int age) {
        String input = "1\ncat\nBarsik\n" + age + "\n";

        try (Scanner scanner = new Scanner(input)) {
            Main.run(scanner);
        }

        String expected = "Cat name = Barsik, age = " + age
                + System.lineSeparator();

        assertEquals(expected, output.toString());
    }

    @Test
    void shouldPrintErrorForUnsupportedPetType() {
        String input = "1\nhamster\n";
        try (Scanner scanner = new Scanner(input)) {
            Main.run(scanner);
        }

        String expected =
                "Incorrect input. Unsupported pet type"
                        + System.lineSeparator();

        assertEquals(expected, output.toString());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void shouldRejectPetWithNonPositiveAge(int age) {
        String input = "1\ncat\nBarsik\n" + age + "\n";

        try (Scanner scanner = new Scanner(input)) {
            Main.run(scanner);
        }

        String expected =
                "Incorrect input. Age <= 0"
                        + System.lineSeparator();

        assertEquals(expected, output.toString());
    }

    @Test
    void shouldRetryWhenAgeIsNotANumber() {
        String input = "1\ncat\nBarsik\nabc\n3\n";
        try (Scanner scanner = new Scanner(input)) {
            Main.run(scanner);
        }

        String expected =
                "Could not parse a number. Please, try again"
                        + System.lineSeparator()
                        + "Cat name = Barsik, age = 3"
                        + System.lineSeparator();

        assertEquals(expected, output.toString());
    }
}
