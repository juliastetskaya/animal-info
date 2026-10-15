import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void shouldNotIncreaseAgeWhenItIsTen() {
        String output = runMain("1\ncat\nMurka\n10\n");

        assertTrue(output.contains("Cat name = Murka, age = 10"));
    }

    @Test
    void shouldIncreaseAgeWhenItIsGreaterThanTen() {
        String output = runMain("2\ncat\nMurka\n12\ndog\nRex\n11\n");

        assertTrue(output.contains("Cat name = Murka, age = 13"));

        assertTrue(output.contains("Dog name = Rex, age = 12"));
    }

    @Test
    void shouldRejectUnsupportedPetType() {
        String output = runMain("1\nbird\n");

        assertTrue(output.contains(
                "Incorrect input. Unsupported pet type"));
    }

    @Test
    void shouldRejectInvalidAge() {
        String output = runMain("1\ncat\nMurka\n0\n");

        assertTrue(output.contains("Incorrect input. Age <= 0"));
    }

    @Test
    void shouldRetryWhenAgeIsNotAnInteger() {
        String output = runMain("1\ncat\nMurka\naa\n5\n");

        assertTrue(output.contains(
                "Could not parse a number. Please, try again"));
        assertTrue(output.contains("Cat name = Murka, age = 5"));
    }

    private String runMain(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(
                    input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(output));

            Main.main(new String[0]);

            return output.toString(StandardCharsets.UTF_8);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}
