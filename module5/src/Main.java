import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Main {
    static final double NANOSECONDS_PER_SECOND = 1_000_000_000.0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long programStartTime = System.nanoTime();

        int count = readInt(scanner);

        List<Animal> pets = Stream.generate(() -> readAnimal(scanner))
                .limit(count)
                .filter(Objects::nonNull)
                .toList();

        if (!pets.isEmpty()) {
            execution(pets, programStartTime);
        }
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

    private static void execution(List<Animal> pets, long programStartTime) {
        ExecutorService executor = Executors.newFixedThreadPool(pets.size());
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);

        pets.forEach((pet) -> {
            Callable<String> task = () -> {
                long start = System.nanoTime();
                double walkTime = pet.goToWalk();

                double startTime = (start - programStartTime) / NANOSECONDS_PER_SECOND;
                double endTime = startTime + walkTime;

                return String.format("%s, start time = %.2f, end time = %.2f", pet.toString(), startTime, endTime);
            };

            completionService.submit(task);
        });

        for (int i = 0; i < pets.size(); i++) {
            try {
                String future = completionService.take().get();
                System.out.println(future);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        executor.shutdown();
    }
}