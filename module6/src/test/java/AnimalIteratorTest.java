import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalIteratorTest {

    @Test
    void shouldIterateThroughAllAnimals() {
        Animal cat = new Cat("Murka", 3);
        Animal dog = new Dog("Rex", 5);
        AnimalIterator iterator = new AnimalIterator(List.of(cat, dog));

        assertTrue(iterator.hasNext());
        assertSame(cat, iterator.next());

        assertTrue(iterator.hasNext());
        assertSame(dog, iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    void shouldResetIteration() {
        Animal cat = new Cat("Murka", 3);
        Animal dog = new Dog("Rex", 5);
        AnimalIterator iterator = new AnimalIterator(List.of(cat, dog));

        iterator.next();
        iterator.next();

        assertFalse(iterator.hasNext());

        iterator.reset();

        assertTrue(iterator.hasNext());
        assertSame(cat, iterator.next());
    }

    @Test
    void shouldHandleEmptyList() {
        AnimalIterator iterator = new AnimalIterator(List.of());

        assertFalse(iterator.hasNext());
    }
}
