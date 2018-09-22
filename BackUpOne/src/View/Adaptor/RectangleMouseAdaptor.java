package View.Adaptor;

import Model.Rectangle;
import View.ShapePanel;
import View.Enum.ShapeType;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RectangleMouseAdaptor extends MouseAdapter {

    private Point startpoint;
    private ShapePanel panel;

    public RectangleMouseAdaptor(ShapePanel panel){

        this.panel = panel;

        this.panel.setType(ShapeType.rectangle);
    }

    @Override
    public void mousePressed(MouseEvent e) {

        startpoint = e.getPoint();
        System.out.println("Mouse was pressed at " + "[" + startpoint.getX() + "," + startpoint.getY() + "].");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int maxx =(int) Math.max(startpoint.getX(), e.getX());
        int maxy =(int) Math.max(startpoint.getY(), e.getY());
        int minx =(int) Math.min(startpoint.getX(), e.getX());
        int miny =(int) Math.min(startpoint.getY(), e.getY());

        int width = maxx - minx;
        int height = maxy - miny;

        panel.addShape(new Rectangle(minx, miny, width, height, Color.blue));
    }
}
