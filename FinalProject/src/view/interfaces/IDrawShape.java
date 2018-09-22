package view.interfaces;

import controller.Point;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;

import java.awt.*;

public interface IDrawShape {
    void paint(Graphics g);
    boolean contains(Point start_Point);
    Point getStartPoint();
    void addX(int dx);
    void addY(int dy);
    Point getAdjustedEnd();
    Point getAdjustedStart();
    int getHeight();
    int getWidth();
    Color getSecondaryColor();
    Color getPrimaryColor();
    ShapeShadingType getShapeShadingType();
    ShapeType getShapeType();
    ShapeConfiguration getShapeConfiguration();
}