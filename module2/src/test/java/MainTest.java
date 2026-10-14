import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void shouldPrintCatAndDogInfo() {
        String input = "2\ncat\nMurka\n3\n4.0\ndog\nRex\n5\n10.0\n";
        String output = runMain(input);

        assertTrue(output.contains(
                "Cat name = Murka, age = 3, mass = 4.00, feed = 0.40"
        ));
        assertTrue(output.contains(
                "Dog name = Rex, age = 5, mass = 10.00, feed = 3.00"
        ));
    }

    @Test
    void shouldRejectUnsupportedPetType() {
        String input = "1\nbird\n";
        String output = runMain(input);

        assertTrue(output.contains(
                "Incorrect input. Unsupported pet type"
        ));
    }

    @Test
    void shouldRejectInvalidAge() {
        String input = "1\ncat\nMurka\n0\n";
        String output = runMain(input);

        assertTrue(output.contains("Incorrect input. Age <= 0"));
    }

    @Test
    void shouldRejectInvalidWeight() {
        String input = "1\ndog\nRex\n5\n0\n";
        String output = runMain(input);

        assertTrue(output.contains("Incorrect input. Mass <= 0"));
    }

    @Test
    void shouldRetryWhenFirstSymbolIsNotANumber() {
        String input = "aa\n1\ncat\nMurka\n3\n4.0\n";
        String output = runMain(input);

        String expected =
                "Could not parse a number. Please, try again"
                        + System.lineSeparator()
                        + "Cat name = Murka, age = 3, mass = 4.00, feed = 0.40"
                        + System.lineSeparator();

        assertEquals(expected, output);
    }

    @Test
    void shouldRetryWhenWeightIsNotADouble() {
        String input = "1\ncat\nMurka\n3\na\n5.0\n";
        String output = runMain(input);

        String expected =
                "Could not parse a number. Please, try again"
                        + System.lineSeparator()
                        + "Cat name = Murka, age = 3, mass = 5.00, feed = 0.50"
                        + System.lineSeparator();

        assertEquals(expected, output);
    }

    private String runMain(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(
                    input.getBytes(StandardCharsets.UTF_8)
            ));
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));

            Main.main(new String[0]);

            return output.toString(StandardCharsets.UTF_8);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}
