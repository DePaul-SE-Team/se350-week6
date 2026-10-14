# Duck Dilemma — Composition over Inheritance

SE 350, Week 6 lab. A small Java exercise in refactoring an inheritance-based design into one built with **composition** and **dependency injection**.

## The problem

`src/main/java/org/example/problem/DuckDillema.java` models ducks with an inheritance hierarchy:

```
Duck (abstract: swim(), quack())
├── SwimmingDuck   — "can swim", "can quack"
│   ├── Mallard    — reuses SwimmingDuck
│   ├── RedHead    — reuses SwimmingDuck
│   ├── Rubber     — overrides both: "can float", "can squeak"
│   └── Decoy      — overrides quack() to do nothing
└── FloatingDuck   — "can float", "can squeak"
```w

The hierarchy shows the usual weaknesses of using inheritance to share behavior:

- **Duplicated code.** `Rubber` reimplements exactly what `FloatingDuck` already does, because a class can only extend one parent.
- **Overriding to remove behavior.** `Decoy` inherits a quack and then overrides it to return nothing.
- **Rigid combinations.** Every new mix of swim and quack behavior needs a new subclass, and a duck can't change behavior at runtime.

## The task

Rewrite the design in `src/main/java/org/example/solution/Solution.java` using **dependency injection and composition**:

- Pull the varying behaviors (swimming, quacking) out into their own interfaces with separate implementations.
- Give `Duck` references to those behaviors instead of hard-coding them through subclasses.
- Supply (inject) the behaviors from outside, for example through the constructor.
- Use `main` to build each duck (Mallard, RedHead, Rubber, Decoy) and print what it can do.

## Project layout

```
.
├── pom.xml
└── src/main/java/org/example
    ├── problem/DuckDillema.java   # original inheritance-based design
    └── solution/Solution.java     # composition + DI rewrite (to be completed)
```

## Requirements

- JDK 25 (set by `maven.compiler.source`/`target` in `pom.xml`)
- Maven 3.9+ (or open the project in IntelliJ IDEA)

`Solution.java` uses Java 25's compact source files feature (a top-level `void main` with no enclosing class).

## Build and run

Compile with Maven:

```sh
mvn compile
```

Run the solution file directly with the Java launcher:

```sh
java src/main/java/org/example/solution/Solution.java
```

Or run the original problem class after compiling:

```sh
java -cp target/classes org.example.problem.DuckDillema
```

Both `main` methods are currently empty, so they print nothing until you fill them in.
