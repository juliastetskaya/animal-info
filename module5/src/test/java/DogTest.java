import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void shouldReturnCorrectString() {
        Dog dog = new Dog("Rex", 4);

        assertEquals("Dog name = Rex, age = 4", dog.toString());
    }

    @Test
    void shouldReturnHalfOfAgeAsWalkTime() throws InterruptedException {
        Dog dog = new Dog("Rex", 1);

        assertEquals(0.5, dog.goToWalk(), 0.001);
    }
}
