import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuineaPigTest {

    @Test
    void shouldReturnCorrectChillInfo() {
        GuineaPig guineaPig = new GuineaPig("Kesha", 2);

        assertEquals("I can chill for 12 hours", guineaPig.chill());
    }

    @Test
    void shouldReturnCorrectString() {
        GuineaPig guineaPig = new GuineaPig("Kesha", 2);

        assertEquals(
                "GuineaPig name = Kesha, age = 2. I can chill for 12 hours",
                guineaPig.toString()
        );
    }
}
