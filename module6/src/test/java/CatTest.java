import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatTest {

    @Test
    void shouldReturnCorrectString() {
        Cat cat = new Cat("Murka", 3);

        assertEquals("Cat name = Murka, age = 3", cat.toString());
    }
}
