package Labs.oo2;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

public class Game extends Canvas {

    public static void main(String[] args) {
        Game game = new Game();


    }


// create an array of 3 balls
// call this array balls

    Ball[] balls = { new Ball(150, 150, 10, 10, 10, 5), new Ball(250, 250, 10, 10, -4, -20), new Ball(50, 50, 10, 10)};



    Game() {



        JFrame frame = new JFrame();
        this.setSize(500, 500);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        Ball.setWorld(500, 500);
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
        for (Ball ball : balls) {
            ball.move();
        }
        this.repaint();
    }

    public void paint(Graphics g) {
        g.drawRect(0, 0, Ball.worldW, Ball.worldH);
// move and draw each ball in balls array
// Tip: use an enhanced for loop to pick
//	  each ball in the balls array.
        for (Ball ball : balls) {
            g.drawOval(ball.x, ball.y, ball.w, ball.h);
        }

    }
}

class Ball {
    public int x, y, w, h;
    private int dirX, dirY;

    static int worldW;
    static int worldH;

    public static void setWorld(int w, int h) {
        worldW = 300;
        worldH = 300;
    }

    Ball(int x, int y, int w, int h, int dirX, int dirY) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dirX = dirX;
        this.dirY = dirY;
    }
    Ball (int x, int y, int w, int h) {
        this(x, y, w, h, 1, 1);
    }

    void move() {
        x += dirX;
        y += dirY;

        if (x < 0) {
            x = 0;
            dirX = -dirX;
        } else if (x > Ball.worldW - w) {
            x = Ball.worldW - w;
            dirX = -dirY;
        }

        if (y < 0) {
            y = 0;
            dirY = -dirY;
        } else if (y > Ball.worldH - h) {
            y = Ball.worldH - h;
            dirY = -dirY;
        }
    }


}
