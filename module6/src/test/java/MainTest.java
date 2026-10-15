import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void shouldPrintAnimalsInInputOrder() {
        String output = runMain(
                "2\ncat\nMurka\n3\ndog\nRex\n5\n");

        int catIndex = output.indexOf("Cat name = Murka, age = 3");
        int dogIndex = output.indexOf("Dog name = Rex, age = 5");

        assertTrue(catIndex >= 0);
        assertTrue(dogIndex > catIndex);
    }

    @Test
    void shouldRejectUnsupportedPetType() {
        String output = runMain("1\nbird\n");

        assertTrue(output.contains(
                "Incorrect input. Unsupported pet type"));
    }
}
