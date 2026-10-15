import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Test
    void shouldReturnCorrectString() {
        Cat cat = new Cat("Murka", 5);

        assertEquals("Cat name = Murka, age = 5", cat.toString());
    }

    @Test
    void shouldCreateOlderCat() {
        Cat cat = new Cat("Murka", 5);

        Animal olderCat = cat.createOlderAnimal();

        assertInstanceOf(Cat.class, olderCat);
        assertEquals("Murka", olderCat.getName());
        assertEquals(6, olderCat.getAge());
    }
}
