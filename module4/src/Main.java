import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;


public class Main {
    private static final int MAX_AGE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = readInt(scanner);

        List<Animal> pets = Stream.generate(() -> readAnimal(scanner))
                .limit(count)
                .filter(Objects::nonNull)
                .map(pet -> pet.getAge() > MAX_AGE ? pet.createOlderAnimal() : pet)
                .toList();

        pets.forEach(System.out::println);
    }

    private static Animal readAnimal(Scanner scanner) {
        String type = scanner.nextLine().trim().toLowerCase();

        if (!type.equals("cat") && !type.equals("dog")) {
            System.out.println("Incorrect input. Unsupported pet type");

            return null;
        }

        String name = scanner.nextLine();

        int age = readInt(scanner);

        if (age <= 0) {
            System.out.println("Incorrect input. Age <= 0");

            return null;
        }

        return type.equals("dog") ? new Dog(name, age) : new Cat(name, age);
    }

    private static int readInt(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            scanner.nextLine();

            return number;
        }

        System.out.println("Could not parse a number. Please, try again");
        scanner.next();

        return readInt(scanner);
    }
}