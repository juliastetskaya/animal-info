import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

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

    @Test
    void shouldPrintCatAndDog() {
        String output = runMain(
                "2\ncat\nMurka\n1\ndog\nRex\n1\n");

        assertTrue(output.contains("Cat name = Murka, age = 1"));
        assertTrue(output.contains("Dog name = Rex, age = 1"));
        assertTrue(output.contains("start time ="));
        assertTrue(output.contains("end time ="));
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
        String output = runMain("1\ncat\nMurka\naa\n1\n");

        assertTrue(output.contains(
                "Could not parse a number. Please, try again"));
        assertTrue(output.contains("Cat name = Murka, age = 1"));
    }
}
