# Animal Info

## Project goal

Animal Info is a set of six progressive Java learning modules built around a simple domain model of pets. Each module explores a different Java language or standard-library concept, with the examples becoming more advanced throughout the project.

This is a console-based project focused on Java fundamentals.

## Concepts covered

- **Module 1 — Classes and inheritance:** abstract classes, encapsulation, constructors, getters, inheritance, and method overriding.
- **Module 2 — Abstraction and polymorphism:** abstract methods, polymorphic behavior, and basic input validation.
- **Module 3 — Interfaces and object creation:** interfaces, a functional interface, method references, lambdas, and using a `Map` to select object creators.
- **Module 4 — Stream API:** generating and filtering streams, method references, and transforming objects with stream operations.
- **Module 5 — Concurrency:** `ExecutorService`, `Callable`, `CompletionService`, and measuring task execution time.
- **Module 6 — Generics and iterators:** a generic `BaseIterator<T>` interface and a custom iterator implementation for a list of animals.

## Requirements

- JDK 16 or newer. The code uses `Stream.toList()`, which was introduced in Java 16.
- A terminal or command-line shell.

An IDE such as IntelliJ IDEA can also be used, but is not required.

## Project structure

```text
animal-info/
├── module1/
│   └── src/
├── module2/
│   └── src/
├── module3/
│   └── src/
├── module4/
│   └── src/
├── module5/
│   └── src/
└── module6/
    └── src/
```

Each module is a separate console program. The modules reuse class names such as `Animal`, `Cat`, `Dog`, and `Main`, so compile and run **one module at a time**.

## How to compile and run

Run the commands below from the project root (`animal-info/`). Replace `module1` with any module from `module1` through `module6`.

### macOS / Linux

```bash
mkdir -p module1/out
javac -d module1/out module1/src/*.java
java -cp module1/out Main
```

### Windows PowerShell

```powershell
New-Item -ItemType Directory -Force module1/out
javac -d module1/out module1/src/*.java
java -cp module1/out Main
```

The programs read input from standard input. Follow the prompts and input format implemented in the selected module's `Main.java`.

## Notes

- The modules are intended to be explored independently and in order.
- There is no external library or build-tool dependency; the examples use the Java standard library.
