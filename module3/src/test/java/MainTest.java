import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void shouldPrintHerbivoresBeforeOmnivores() {
        String input = "4\ncat\nMurka\n3\nguinea\nKesha\n2\ndog\nRex\n5\nhamster\nHoma\n1\n";
        String output = runMain(input);

        int guineaIndex = output.indexOf("GuineaPig name = Kesha");
        int hamsterIndex = output.indexOf("Hamster name = Homa");
        int catIndex = output.indexOf("Cat name = Murka");
        int dogIndex = output.indexOf("Dog name = Rex");

        assertTrue(guineaIndex >= 0);
        assertTrue(hamsterIndex >= 0);
        assertTrue(catIndex >= 0);
        assertTrue(dogIndex >= 0);

        assertTrue(guineaIndex < catIndex);
        assertTrue(hamsterIndex < catIndex);
        assertTrue(guineaIndex < dogIndex);
        assertTrue(hamsterIndex < dogIndex);
    }

    @Test
    void shouldRejectUnsupportedPetType() {
        String output = runMain("1\nbird\n");

        assertTrue(output.contains(
                "Incorrect input. Unsupported pet type"
        ));
    }

    @Test
    void shouldRejectInvalidAge() {
        String output = runMain("1\ncat\nMurka\n0\n");

        assertTrue(output.contains("Incorrect input. Age <= 0"));
    }

    @Test
    void shouldRetryWhenAgeIsNotAnInteger() {
        String input = "1\ncat\nMurka\naa\n3\n";
        String output = runMain(input);

        assertTrue(output.contains(
                "Could not parse a number. Please, try again"
        ));
        assertTrue(output.contains("Cat name = Murka, age = 3."));
    }

    private String runMain(String input) {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(new ByteArrayInputStream(
                    input.getBytes(StandardCharsets.UTF_8)
            ));
            System.setOut(new PrintStream(
                    output, true, StandardCharsets.UTF_8
            ));

            Main.main(new String[0]);

            return output.toString(StandardCharsets.UTF_8);
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}
