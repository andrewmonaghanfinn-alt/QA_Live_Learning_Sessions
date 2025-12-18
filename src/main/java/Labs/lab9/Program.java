package Labs.lab9;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Penguin(AnimalType.Bird, "Penguin"));
        animals.add(new Duck(AnimalType.Bird, "Duck"));
        animals.add(new Tuna(AnimalType.Fish, "Tuna"));

        for (Animal animal : animals) {
            System.out.println("This is a " + animal.getName().toLowerCase());
            if (animal instanceof Bird) {
                ((Bird) animal).makeNest();
            } else if (animal instanceof Fish) {
                ((Fish) animal).swim();
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

abstract class Bird extends Animal {
    Bird(AnimalType animalType, String name) {
        super(animalType, name);
    }
    public abstract void makeNest();
    public void speak() {

    }
}

abstract class Fish extends Animal {
    Fish(AnimalType animalType, String name) {
        super(animalType, name);
    }
    public abstract void swim();

}

class Duck extends Bird {
    Duck(AnimalType animalType, String name) {
        super(animalType, name);
    }
    @Override
    public void makeNest() {
        System.out.println(getName() + " is making nest by the lake...");
    }

}

class Penguin extends Bird {
    Penguin(AnimalType animalType, String name) {
        super(animalType, name);
    }
    @Override
    public void makeNest() {
        System.out.println(getName() + " is making nest on the rocks...");
    }

}

class Tuna extends Fish {
    Tuna(AnimalType animalType, String name) {
        super(animalType, name);
    }
    @Override
    public void swim() {
        System.out.println(getName() + " is swimming...");
    }
}