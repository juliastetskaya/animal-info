import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Test
    void shouldReturnCorrectString() {
        Cat cat = new Cat("Murka", 4);

        assertEquals("Cat name = Murka, age = 4", cat.toString());
    }

    @Test
    void shouldReturnQuarterOfAgeAsWalkTime() throws InterruptedException {
        Cat cat = new Cat("Murka", 1);

        assertEquals(0.25, cat.goToWalk(), 0.001);
    }
}
