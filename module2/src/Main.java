import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();

        int count = readInt(scanner);

        for (int i = 0; i < count; i++) {
            String type = scanner.nextLine().trim().toLowerCase();
            if (!type.equals("cat") && !type.equals("dog")) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }

            String name = scanner.nextLine();

            int age = readInt(scanner);

            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }

            double weight = readDouble(scanner);

            if (weight <= 0.0) {
                System.out.println("Incorrect input. Mass <= 0");
                continue;
            }

            if (type.equals("dog")) {
                pets.add(new Dog(name, age, weight));
            } else {
                pets.add(new Cat(name, age, weight));
            }
        }

        for (Animal pet : pets) {
            System.out.println(pet);
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

    private static double readDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Could not parse a number. Please, try again");
            scanner.next();
        }

        double number = scanner.nextDouble();
        scanner.nextLine();

        return number;
    }
}