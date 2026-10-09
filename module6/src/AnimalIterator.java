import java.util.List;

public class AnimalIterator implements BaseIterator<Animal> {
    private final List<Animal> pets;
    private int currentIndex;

    public AnimalIterator(List<Animal> pets) {
        this.pets = pets;
        currentIndex = 0;
    }

    @Override
    public Animal next() {
        return pets.get(currentIndex++);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < pets.size();
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }
}
