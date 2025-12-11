package Labs.lab04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;



public class Game extends Canvas {

    public static void main(String[] args) {
        //Game game = new Game();


        String name = "Bobert";
        System.out.println(name.charAt(3));
        System.out.println(("" + name.charAt(3)).toUpperCase());
        System.out.println(("" + name.charAt(3)).toLowerCase());

        String output = "";

        for ( char c : name.toCharArray()) {
            output += c + " ";
        }
        System.out.println(output);

        System.out.println(name.startsWith("Bob"));
        System.out.println(name.endsWith("ert"));
        System.out.println(name.indexOf("o"));
        System.out.println(name.indexOf("q"));
        String fullname = name + " Bobinson";
        System.out.println(fullname);


        StringBuilder sb = new StringBuilder("Bruce Springsteen ");
        sb.append("is the artist ever");
        System.out.println(sb.toString());
        sb.insert(sb.indexOf("artist"), "best ");
        System.out.println(sb.toString());
        sb.replace(sb.indexOf("artist"), sb.indexOf("artist")+ "artist".length(), "rock singer");
        System.out.println(sb.toString());
    }




// create an array of 3 balls
// call this array balls

    Shape[] shapes = { new Shape(150, 150, 10, 10, 10, 5, ShapeType.Oval), new Shape(250, 250, 10, 10, -4, -20, ShapeType.Arc), new Shape(50, 50, 10, 10, 10, 19, ShapeType.ThreeDRectangle)};



    Game() {

        JFrame frame = new JFrame();
        this.setSize(500, 500);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        Shape.setWorld(500, 500);
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        };

        t.schedule(tt, 0, 50);


        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                t.cancel();
                tt.cancel();
            }
        });
    }

    public void draw() {
// call the move() method of each balls
// Tip: use an enhanced for loop to pick
//	  each ball in the balls array.
        for (Shape shape : shapes) {
            shape.move();
        }
        this.repaint();
    }

    public void paint(Graphics g) {
        g.drawRect(0, 0, Shape.worldW, Shape.worldH);
// move and draw each ball in balls array
// Tip: use an enhanced for loop to pick
//	  each ball in the balls array.
        for (Shape shape : shapes) {
            g.setColor(shape.getColor());
            switch (shape.getShapeType()) {
                case ShapeType.Arc -> g.drawArc(shape.x, shape.y, shape.w, shape.h, 90, 100);
                case ShapeType.Rectangle -> g.drawRect(shape.x, shape.y, shape.w, shape.h);
                case ShapeType.RoundRectangle -> g.drawRoundRect(shape.x, shape.y, shape.w, shape.h, 10, 10);
                case ShapeType.ThreeDRectangle -> g.draw3DRect(shape.x, shape.y, shape.w, shape.h, true);
                default -> g.drawOval(shape.x, shape.y, shape.w, shape.h);
            }
        }

    }
}


