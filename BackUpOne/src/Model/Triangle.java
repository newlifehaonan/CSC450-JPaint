package Model;

import Model.Interfaces.IShape;

import java.awt.*;

public class Triangle implements IShape {


    int[] x;
    int[] y;

    Color color;

    public Triangle(int[] x, int[] y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.drawPolygon(x, y, 3);
    }
}
