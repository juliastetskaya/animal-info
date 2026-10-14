import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DogTest {
    @Test
    void shouldReturnName() {
        Dog dog = new Dog("Rex", 7);

        assertEquals("Rex", dog.getName());
    }

    @Test
    void shouldReturnAge() {
        Dog dog = new Dog("Rex", 7);

        assertEquals(7, dog.getAge());
    }

    @Test
    void shouldReturnCorrectStringRepresentation() {
        Dog dog = new Dog("Rex", 7);

        assertEquals("Dog name = Rex, age = 7", dog.toString());
    }
}
