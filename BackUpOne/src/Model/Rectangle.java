package Model;

import Model.Interfaces.IShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle implements IShape {

    int x;
    int y;
    int width;
    int heigh;
    Color color;

    public Rectangle(int x, int y, int width, int heigh, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigh = heigh;
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.drawRect(x,y,width,heigh);
    }
}
