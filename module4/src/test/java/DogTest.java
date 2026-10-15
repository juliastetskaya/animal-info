import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void shouldReturnCorrectString() {
        Dog dog = new Dog("Rex", 7);

        assertEquals("Dog name = Rex, age = 7", dog.toString());
    }

    @Test
    void shouldCreateOlderDog() {
        Dog dog = new Dog("Rex", 7);

        Animal olderDog = dog.createOlderAnimal();

        assertInstanceOf(Dog.class, olderDog);
        assertEquals("Rex", olderDog.getName());
        assertEquals(8, olderDog.getAge());
    }
}
