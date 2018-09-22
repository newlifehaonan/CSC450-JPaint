package Model;

import Model.Interfaces.IShape;

import java.awt.*;

public class Ellipse implements IShape {

    int x;
    int y;
    int width;
    int heigh;
    Color color;

    public Ellipse(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigh = height;
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.drawOval(x,y,width,heigh);
    }

}
