import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Test
    void shouldReturnCorrectHuntInfo() {
        Cat cat = new Cat("Murka", 3);

        assertEquals("I can hunt for mice", cat.hunt());
    }

    @Test
    void shouldReturnCorrectString() {
        Cat cat = new Cat("Murka", 3);

        assertEquals(
                "Cat name = Murka, age = 3. I can hunt for mice",
                cat.toString()
        );
    }
}
