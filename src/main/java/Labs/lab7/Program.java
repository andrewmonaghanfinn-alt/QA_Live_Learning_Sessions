package Labs.lab7;

import java.awt.*;
import java.util.ArrayList;
/*
* Lab questions:
*
*How does this work?
*
* The classes are being implicitly cast into Shape objects which allows them to be used
* in the same way, which is also an example of polymorphism.
*
*How can we store a shape, like a Rectangle, in a list of Shape objects?
*
*The list is just a set of references, these references are to Shape objects, so
* it doesn't break the rule that a list must have a single type. The other subclass-specific
* methods/fields aren't represented by the reference in memory, so from the perspective of the
* list they are the exact same as Shape instances.
*
*
*
*
* */

public class Program {
    public static void main(String[] args) {
        Rectangle Rect = new Rectangle(10, 20, Color.RED, new Point(100, 50));
        Circle Circ = new Circle(45, Color.PINK, new Point(25, 1));
        Sphere Sphe = new Sphere(70, Color.CYAN, new Point(240, 256));

        System.out.println(Rect.printCharacteristics());
        System.out.println(Circ.printCharacteristics());
        System.out.println(Sphe.printCharacteristics());

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(Rect);
        shapes.add(Circ);
        shapes.add(Sphe);

        for (Shape s : shapes) {
            System.out.println("Colour: " + s.getColour().toString());
            System.out.println("Position: " + s.getPosition().x + ", " + s.getPosition().y);
        }

    }
}

class Shape {
    private Color colour;
    private Point position;

    Shape(Color colour, Point position) {
        this.colour = colour;
        this.position = position;
    }

    public Color getColour() {
        return colour;
    }
    public Point getPosition() {
        return position;
    }
    public void setColour(Color colour) {
        this.colour = colour;
    }
    public void setPosition(Point position) {
        this.position = position;
    }

}

class Rectangle extends Shape {
    private int sideA;
    private int sideB;

    Rectangle(int sideA, int sideB, Color colour, Point position) {
        super(colour, position);
        this.sideA = sideA;
        this.sideB = sideB;
    }
    public int getArea() {
        return sideA * sideB;
    }
    public String printCharacteristics() {
        return "Side A: " + sideA + "\n" +
                "Side B: " + sideB + "\n" +
                "Position X: " + getPosition().x + "\n" +
                "Position Y: " + getPosition().y + "\n" +
                "Shape colour: " + getColour().toString() + "\n";
    }
    public int getCircumference() {
        return 2 * (sideA + sideB);
    }
}

class Circle extends Shape {
    protected int radius;

    Circle(int radius, Color colour, Point position){
        super(colour, position);
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    public double getCircumference() {
        return Math.PI * radius * 2;
    }
    public int getDiameter() {
        return 2 * radius;
    }
    public String printCharacteristics() {
        return "Radius: " + radius + "\n" +
                "Diameter: " + getDiameter() + "\n" +
                "Circumference: " + getCircumference() + "\n" +
                "Area: " + getArea() + "\n" +
                "Position X: " + getPosition().x + "\n" +
                "Position Y: " + getPosition().y + "\n" +
                "Shape colour: " + getColour().toString() + "\n";
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
}

class Sphere extends Circle {
    Sphere(int radius, Color colour, Point position) {
        super(radius, colour, position);
    }
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
    public String printCharacteristics() {
        return "Radius: " + radius + "\n" +
                "Diameter: " + getDiameter() + "\n" +
                "Circumference: " + getCircumference() + "\n" +
                "Volume: " + getVolume() + "\n" +
                "Position X: " + getPosition().x + "\n" +
                "Position Y: " + getPosition().y + "\n" +
                "Shape colour: " + getColour().toString() + "\n";
    }
}