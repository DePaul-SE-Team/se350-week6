# Duck Dilemma: Composition over Inheritance

**SE 350 · Week 6 Lab**

Refactor a Java design that uses inheritance to share behavior into one that uses **composition** and **dependency injection**.

- **Composition:** A duck delegates swimming and quacking to separate behavior objects.
- **Dependency injection:** Code outside the duck supplies those objects, such as through its constructor.

## The Problem

The original design is in [`DuckDillema.java`](src/main/java/org/example/problem/DuckDillema.java):

```text
Duck (abstract: swim(), quack())
├── SwimmingDuck — swims and quacks
│   ├── Mallard — inherits both behaviors
│   ├── RedHead — inherits both behaviors
│   ├── Rubber — overrides both to float and squeak
│   └── Decoy — overrides quack() to remain silent
└── FloatingDuck — floats and squeaks
```

This hierarchy ties behavior to a duck’s parent class, creating several problems:

| Problem | Example |
|---|---|
| **Duplicated behavior** | `Rubber` repeats the floating and squeaking behavior already defined in `FloatingDuck`. |
| **Inherited behavior that must be removed** | `Decoy` inherits quacking, then overrides it to do nothing. |
| **Inflexible behavior combinations** | Each new combination requires subclass changes or additional overrides. Changing behavior at runtime requires additional support. |

## Your Task

Complete [`Solution.java`](src/main/java/org/example/solution/Solution.java) using composition and dependency injection.

1. Define separate interfaces for swimming and quacking behavior.
2. Implement the behaviors needed by the four duck types.
3. Give `Duck` references to behavior objects and delegate its operations to them.
4. Inject the behavior objects from outside `Duck`, for example through its constructor.
5. Use `main` to construct each duck and demonstrate its behavior.

Preserve the behavior of the original design:

| Duck | Swimming behavior | Quacking behavior |
|---|---|---|
| Mallard | Swim | Quack |
| RedHead | Swim | Quack |
| Rubber | Float | Squeak |
| Decoy | Swim | Remain silent |

The refactored design should reuse behavior implementations rather than duplicate them across duck classes.

## Project Layout

```text
.
├── pom.xml
└── src/main/java/org/example
    ├── problem
    │   └── DuckDillema.java   # Original inheritance-based design
    └── solution
        └── Solution.java     # Composition and DI exercise
```

## Requirements

- **JDK 25**, as configured in `pom.xml`
- **Maven 3.9+**

You can also open the project in IntelliJ IDEA and configure it to use JDK 25.

`Solution.java` uses a Java 25 compact source file: its `void main()` method has no enclosing class.

## Build and Run

Run these commands from the project root.

### Compile the project

```sh
mvn compile
```

### Run your solution

```sh
java src/main/java/org/example/solution/Solution.java
```

### Run the original design

After compiling:

```sh
java -cp target/classes org.example.problem.DuckDillema
```

Both `main` methods are initially empty, so neither produces output until you add demonstration code.
