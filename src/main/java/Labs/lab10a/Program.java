package Labs.lab10a;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Penguin(AnimalType.Bird, "Penguin"));
        animals.add(new Duck(AnimalType.Bird, "Duck"));
        animals.add(new Tuna(AnimalType.Fish, "Tuna"));

        for (Animal animal : animals) {
            System.out.println("This is a " + animal.getName().toLowerCase());
            if (animal instanceof Flyable) {
                ((Flyable) animal).fly();
            } else if (animal instanceof Swimmable) {
                ((Swimmable) animal).swim();
            }
        }

    }
}

enum AnimalType {
    Fish,
    Amphibian,
    Reptile,
    Mammal,
    Bird,
    Invertibrate
}

abstract class Animal {
    private AnimalType animalType;
    private String name;

    Animal(AnimalType animalType, String name) {
        this.animalType = animalType;
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}

abstract class Bird extends Animal implements Moveable, Flyable{
    Bird(AnimalType animalType, String name) {
        super(animalType, name);
    }
}

class Duck extends Bird {
    Duck(AnimalType animalType, String name) {
        super(animalType, name);
    }
    public void move() {
        System.out.println("Moving like a " + getName().toLowerCase());
    }
    public void fly() {
        System.out.println("Flying like a " + getName().toLowerCase());
    }


}

class Penguin extends Bird {
    Penguin(AnimalType animalType, String name) {
        super(animalType, name);
    }
    public void move() {
        System.out.println("Moving like a " + getName().toLowerCase());
    }
    public void fly() {
        System.out.println("Flying like a " + getName().toLowerCase());
    }
}

abstract class Fish extends Animal implements Moveable, Swimmable {
    Fish(AnimalType animalType, String name) {
        super(animalType, name);
    }
}

class Tuna extends Fish {
    Tuna(AnimalType animalType, String name) {
        super(animalType, name);
    }
    public void move() {
        System.out.println("Moving like a " + getName().toLowerCase());
    }
    public void swim() {
        System.out.println("Swimming like a " + getName().toLowerCase());
    }
}

interface Swimmable {
    public void swim();
}

interface Flyable {
    public void fly();
}

interface Moveable {
    public void move();
}