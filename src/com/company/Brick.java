package com.company;

import java.awt.*;

public class Brick {

    private int x = 50;
    private int y = 50;
    private Game game;
    private static final int DIAMETERY = 30;
    private static final int DIAMETERX = 150;

    public Brick(Game game) {
        this.game = game;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, DIAMETERX, DIAMETERY);
    }

    public Rectangle getBrickBounds(){
        return new Rectangle(x, y, DIAMETERX, DIAMETERY);
    }

    public int getBottomY() {
        return y + DIAMETERY;
    }

    public int getTopY() {
        return y - DIAMETERY;
    }
}
