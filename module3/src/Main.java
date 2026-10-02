import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();

        int count = readInt(scanner);

        Map<String, AnimalCreator> creators = Map.of(
                "dog", Dog::new,
                "cat", Cat::new,
                "hamster", Hamster::new,
                "guinea", GuineaPig::new
        );

        for (int i = 0; i < count; i++) {
            String type = scanner.nextLine().trim().toLowerCase();
            if (!creators.containsKey(type)) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }

            String name = scanner.nextLine();

            int age = readInt(scanner);

            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }

            Animal animal = creators.get(type).create(name, age);
            pets.add(animal);
        }

        for (Animal pet : pets) {
            if (pet instanceof Herbivore) {
                System.out.println(pet);
            }
        }

        for (Animal pet : pets) {
            if (pet instanceof Omnivore) {
                System.out.println(pet);
            }
        }

        scanner.close();
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Could not parse a number. Please, try again");
            scanner.next();
        }

        int number = scanner.nextInt();
        scanner.nextLine();

        return number;
    }
}