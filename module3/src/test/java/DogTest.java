import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void shouldReturnCorrectHuntInfo() {
        Dog dog = new Dog("Rex", 5);

        assertEquals("I can hunt for robbers", dog.hunt());
    }

    @Test
    void shouldReturnCorrectString() {
        Dog dog = new Dog("Rex", 5);

        assertEquals(
                "Dog name = Rex, age = 5. I can hunt for robbers",
                dog.toString()
        );
    }
}
