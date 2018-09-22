package View.Adaptor;

import Model.Rectangle;
import Model.Triangle;
import View.Enum.ShapeType;
import View.ShapePanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TriangleMouseAdaptor extends MouseAdapter {

    private Point startpoint;
    private ShapePanel panel;

    public TriangleMouseAdaptor(ShapePanel panel){

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

        int[] xset = {minx, maxx, minx};
        int[] yset = {miny, maxy, maxy};

        panel.addShape(new Triangle(xset, yset, Color.yellow));
    }
}
