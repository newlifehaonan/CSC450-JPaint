package Controller.DrawShape;

import Controller.Interfaces.IShape;

import java.awt.*;

public class Shape implements IShape {

    Point.Float start;
    Point.Float end;

    public Shape(Point.Float start, Point.Float end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Point.Float getStartPoint() {

        return start;
    }

    @Override
    public Point.Float getEndPoint() {
        return end;
    }

    @Override
    public void setStartPoint() {
        float minx =(float) Math.min(start.getX(),end.getX());
        float miny =(float) Math.min(start.getY(),end.getY());
        start = new Point.Float(minx,miny);
    }

    @Override
    public void setEndPoint() {
        float maxx =(float) Math.max(start.getX(),end.getX());
        float maxy =(float) Math.max(start.getY(),end.getY());
        start = new Point.Float(maxx,maxy);
    }

    @Override
    public float getWidth() {
        return (float) (end.getX() - start.getX());
    }

    @Override
    public float getHeight() {
        return (float) (end.getY() - start.getY());
    }
}
