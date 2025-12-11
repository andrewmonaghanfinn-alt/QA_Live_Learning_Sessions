package Labs.lab04;

import java.awt.*;
import java.util.Random;


enum ShapeType {
    Rectangle,
    ThreeDRectangle,
    RoundRectangle,
    Oval,
    Arc
}


public class Shape {
    public int x, y, w, h;
    private int dirX, dirY;
    private final ShapeType shapeType;
    private Color colour;
    static int worldW;
    static int worldH;

    public static void setWorld(int w, int h) {
        worldW = 300;
        worldH = 300;
    }

    Shape(int x, int y, int w, int h, int dirX, int dirY, ShapeType shapeType) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dirX = dirX;
        this.dirY = dirY;
        this.shapeType = shapeType;
        Random rand = new Random();
        colour = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }
    Shape(int x, int y, int w, int h) {
        this(x, y, w, h, 1, 1, ShapeType.RoundRectangle);
    }

    Shape(int x, int y, int w, int dirX, int dirY) {
        this(x, y, w, w, dirX, dirY, ShapeType.Oval);
        this.colour = Color.BLACK;
    }

    void move() {
        x += dirX;
        y += dirY;

        if (x < 0) {
            x = 0;
            dirX = -dirX;
        } else if (x > Shape.worldW - w) {
            x = Shape.worldW - w;
            dirX = -dirY;
        }

        if (y < 0) {
            y = 0;
            dirY = -dirY;
        } else if (y > Shape.worldH - h) {
            y = Shape.worldH - h;
            dirY = -dirY;
        }
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public Color getColor() {
        return colour;
    }
}

