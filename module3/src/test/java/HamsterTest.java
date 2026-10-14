import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamsterTest {

    @Test
    void shouldReturnCorrectChillInfo() {
        Hamster hamster = new Hamster("Homa", 1);

        assertEquals("I can chill for 8 hours", hamster.chill());
    }

    @Test
    void shouldReturnCorrectString() {
        Hamster hamster = new Hamster("Homa", 1);

        assertEquals(
                "Hamster name = Homa, age = 1. I can chill for 8 hours",
                hamster.toString()
        );
    }
}
