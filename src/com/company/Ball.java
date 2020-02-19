package com.company;

import java.awt.*;
import java.awt.geom.Line2D;

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
        else if (x + vx > game.getWidth() - BALLDIAMETER)
            vx = -1;
        else if (y + vy < 0)
            vy = 1;
        else if (y + vy > game.getHeight() - BALLDIAMETER)
            //game.gameOver();
            vy = -1;
        else if (collisionRacquet()) {
            vy = -1;
            y = game.racquet.getTopY() - BALLDIAMETER;
        }
        else if (collisionBrickBottom()) {
            vy = 1;
            y = game.brick.getBottomY() - BALLDIAMETER;
        }
        else if (collisionBrickLeft()) {
            vx = 1;
        }
        else if (collisionBrickRight()) {
            vx = -1;
        }
        else if (collisionBrickTop()) {
            vy = -1;
            y = game.brick.getTopY() - BALLDIAMETER;
        }

        x = x + vx;
        y = y + vy;
    }

    private boolean collisionRacquet() {
        return game.racquet.getRacquetBounds().intersects(getBallBounds());
    }

    private boolean collisionBrickBottom() {
        return getBallBounds().intersectsLine(bro().x, bro().y + bro().height, bro().x + bro().width, bro().y + bro().height);
    }

    private boolean collisionBrickLeft() {
        return getBallBounds().intersectsLine(bro().x, bro().y, bro().x, bro().y + bro().height);
    }

    private boolean collisionBrickRight() {
        return getBallBounds().intersectsLine(bro().x + bro().width, bro().y, bro().x + bro().width, bro().y + bro().height);
    }

    private boolean collisionBrickTop() {
        return getBallBounds().intersectsLine(bro().x, bro().y, bro().x + bro().width, bro().y );
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, BALLDIAMETER, BALLDIAMETER);
    }

    public Rectangle getBallBounds() {
        return new Rectangle(x, y, BALLDIAMETER, BALLDIAMETER);
    }

    public Rectangle bro(){
        return game.brick.getBrickBounds();
    }
}