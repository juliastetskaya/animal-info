import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatTest {

    @Test
    void shouldReturnName() {
        Cat cat = new Cat("Barsik", 3);

        assertEquals("Barsik", cat.getName());
    }

    @Test
    void shouldReturnAge() {
        Cat cat = new Cat("Barsik", 3);

        assertEquals(3, cat.getAge());
    }

    @Test
    void shouldReturnCorrectStringRepresentation() {
        Cat cat = new Cat("Barsik", 3);

        assertEquals("Cat name = Barsik, age = 3", cat.toString());
    }
}