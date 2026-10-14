import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Test
    void shouldCalculateFeedInfo() {
        Cat cat = new Cat("Murka", 3, 4.0);

        assertEquals(0.4, cat.getFeedInfoKg(), 0.0001);
    }

    @Test
    void shouldReturnCorrectString() {
        Cat cat = new Cat("Murka", 3, 4.0);

        assertEquals(
                "Cat name = Murka, age = 3, mass = 4.00, feed = 0.40",
                cat.toString()
        );
    }
}