package RefactorProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*
CHANGELOG:

-Added a factory for creating animals
-Animals can only be made from enumerated types (replaced private enum for package private enum)
-Added overrides for animal methods and added doBehaviour() which runs all methods
-Removed helper as it is not used for anything (i think)
-used helper function for country variable
-Removed redundant print statements
-turned calculateTax() into a helper function
-added a daemon thread
-saving animals to json file using threading
 */



public class Main {
    public static List<Animal> animals = new ArrayList<>();
    public static Map<String, String> cache = new HashMap<>();
    public static String path = "src/main/java/RefactorProject/animals.json";
    public static Random random = new Random(42);

    public static void main(String[] args) throws InterruptedException {

        //Animal section

        Animal a1 = AnimalFactory.create(AnimalFactory.Species.Dog, "Rex");
        Animal a2 = AnimalFactory.create(AnimalFactory.Species.Cat, "Lune");
        Animal a3 = AnimalFactory.create(AnimalFactory.Species.Rabbit, "Hazel");
        animals.add(a1);
        animals.add(a2);
        animals.add(a3);




        Thread daemonThread1 = new Thread(Main::doBackgroundWork);
        daemonThread1.setDaemon(true);
        daemonThread1.start();

        System.out.println("=== Animals ===");

        for (Animal a : animals) {
            a.doBehaviour();
            System.out.println();
        }

        Thread thread2 = new Thread(() -> saveAnimalsToFile(path));
        thread2.start();

        //Kennel section


        Kennel kennel = new Kennel();
        kennel.dogs.add((Dog)AnimalFactory.create(AnimalFactory.Species.Dog, "Buddy"));


        thread2.join();

        //Accounting section
        System.out.println("\n === Tax Calculation ===");

        System.out.println(getTax(123.45, "UK"));

        System.out.println("\n === TODO LIST ===");
        printReport(Arrays.asList("OK", "WARN", "TODO"));

    }

    //Animal related functions:

    public static void saveAnimalsToFile(String path) {
        System.out.println("Saving to " + path + " ...");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("[\n");

            for (int i = 0; i < animals.size(); i++) {
                Animal a = animals.get(i);
                writer.write("  {\n");
                writer.write("    \"name\": \"" + a.name + "\",\n");
                writer.write("    \"legs\": " + a.legs + ",\n");
                writer.write("    \"food\": \"" + a.food + "\"\n");
                writer.write("  }");

                if (i < animals.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }

            writer.write("]");
        } catch (IOException e) {
            System.out.println("Error saving animals to file (don't worry they have not been harmed: " + e.getMessage());

        }
    }

    //Thread-based functions
    public static void doBackgroundWork() {
        System.out.println("[DAEMON] working in background");
    }
    //Accounting related functions:
    private static double calculateTax(double gross, String country) {
        country = helper(country);
        if ("UK".equals(country)) return gross * 0.2;
        if ("FR".equals(country)) return gross * 0.19 + 3;
        return gross * 0.15;
    }
    public static String getTax(double gross, String country) {
        double bill = calculateTax(gross, country);
        return "Tax rough calc: " + bill;
    }

    public static void printReport(List<String> lines) {
        System.out.println("---- REPORT ----");
        for (int i = 0; i < lines.size(); i = i + 1) {
            System.out.println((i + 1) + ") " + lines.get(i));
        }

        System.out.println("Generated at: " + getDateTimeNow());
    }
//helper functions:
    public static String helper(String x) {
        if (x == null) return "null";
        String y = x.trim().toUpperCase();
        if (y.length() > 2) return y.substring(0, 2);
        return y;
    }

    public static String getDateTimeNow() {
        LocalDateTime currentDT = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return currentDT.format(formatter);
    }

}


class AnimalFactory {

    public static enum Species {
        Cat,
        Dog,
        Rabbit
    }

    public static Animal create(Species species, String name) {
        return switch (species) {
            case Cat -> new Cat(name);
            case Dog -> new Dog(name);
            case Rabbit -> new Rabbit(name);
            default -> throw new IllegalArgumentException("Unknown animal type: " + species);
        };
    }
}



abstract class Animal {
    protected String name;
    protected int legs;
    protected String food;

    public Animal(String name) {
        this.name = name;
        this.legs = -1;
        this.food = "something";
    }

    public abstract void speak();

    public void idle() {
        System.out.println(name + " does animal stuff.");
    }
    public void move() {
        System.out.println(name + " moves somehow on " + legs + " legs.");
    }
    public void eat(String food) {
        System.out.println(name + " eats " + food + ".");
    }
    public void doBehaviour() {
        speak();
        idle();
        move();
        eat(food);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
        this.legs = 4;
        this.food = "bone";
    }
    @Override
    public void speak() {
        System.out.println(name + " says: woof");
    }
    @Override
    public void idle() {
        System.out.println(name + " chases its tail.");
    }
    @Override
    public void move() {
        System.out.println(name + " runs on " + legs + " legs.");
    }
    @Override
    public void doBehaviour() {
        speak();
        idle();
        move();
        eat(food);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
        this.legs = 4;
        this.food = "fish";
    }
    @Override
    public void idle() {
        System.out.println(name + " ignores you.");
    }
    @Override
    public void speak() {
        System.out.println(name + " says: meow");
    }
    @Override
    public void move() {
        System.out.println(name + " walks " + legs + " legs.");
    }
    @Override
    public void doBehaviour() {
        speak();
        idle();
        move();
        eat(food);
    }
}

class Rabbit extends Animal {
    public Rabbit(String name) {
        super(name);
        this.legs = 4;
        this.food = "carrot";
    }
    @Override
    public void idle() {
        System.out.println(name + " nibbles something.");
    }
    @Override
    public void speak() {
        System.out.println(name + " says: squeak");
    }
    @Override
    public void move() {
        System.out.println(name + " hops on " + legs + " legs.");
    }
    @Override
    public void doBehaviour() {
        speak();
        idle();
        move();
        eat(food);
    }
}

class Kennel {
    public List<Dog> dogs = new ArrayList<>();
    public String address = "Somewhere";
}