import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void shouldCalculateFeedInfo() {
        Dog dog = new Dog("Rex", 5, 10.0);

        assertEquals(3.0, dog.getFeedInfoKg(), 0.0001);
    }

    @Test
    void shouldReturnCorrectString() {
        Dog dog = new Dog("Rex", 5, 10.0);

        assertEquals(
                "Dog name = Rex, age = 5, mass = 10.00, feed = 3.00",
                dog.toString()
        );
    }
}
