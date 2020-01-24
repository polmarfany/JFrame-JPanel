package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet {
    private static final int Y = 330;
    private int x = 0;
    private int vx = 0;
    private Game game;
    private static final int RACQUETHEIGHT = 10;
    private static final int RACQUETWIDTH = 60;

    public Racquet(Game game) {
        this.game = game;
    }

    public void move() {
        if (x + vx > 0 && x + vx < game.getWidth() - RACQUETWIDTH)
            x = x + vx;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, RACQUETWIDTH, RACQUETHEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        vx = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            vx = -3;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            vx = 3;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, RACQUETWIDTH, RACQUETHEIGHT);
    }

    public int getTopY() {
        return Y - RACQUETHEIGHT;
    }
}