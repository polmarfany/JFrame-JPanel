package com.company;

import java.awt.*;

public class Ball {

    private int x = 0;
    private int y = 0;
    private int vx = 1;
    private int vy = 1;
    private Game game;
    private static final int BALLDIAMETER = 50;

    public Ball(Game game) {
        this.game = game;
    }

    void move() {
        if (x + vx < 0)
            vx = 1;
        if (x + vx > game.getWidth() - BALLDIAMETER)
            vx = -1;
        if (y + vy < 0)
            vy = 1;
        if (y + vy > game.getHeight() - BALLDIAMETER)
            game.gameOver();
        if (collision() ) {
            vy = -1;
            y = game.racquet.getTopY() - BALLDIAMETER;
        }

        x = x + vx;
        y = y + vy;
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, BALLDIAMETER, BALLDIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, BALLDIAMETER, BALLDIAMETER);
    }
}