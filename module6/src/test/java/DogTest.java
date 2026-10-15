import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DogTest {

    @Test
    void shouldReturnCorrectString() {
        Dog dog = new Dog("Rex", 5);

        assertEquals("Dog name = Rex, age = 5", dog.toString());
    }
}
