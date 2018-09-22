package Model.Interfaces;

import View.Enum.ShapeColor;
import View.Enum.ShapeShadingType;
import View.Enum.ShapeType;

import java.awt.*;
import java.io.Serializable;

public interface IShape {
    void selectMaxandMin(Point start, Point end);
    void draw(Graphics g);
    Boolean contain(Point startpoint);
    void addX(int x);
    void addY(int y);
    Point getStartPoint();
    Point getEndPoint();
    ShapeType getShapeType();
    ShapeShadingType getShadingType();
    ShapeColor getPrimaryColor();
    ShapeColor getSecondaryColor();
    void setPrimaryColor(ShapeColor primaryColor);
    void setSecondaryColor(ShapeColor secondaryColor);
    void setShadingColor(ShapeShadingType shapeShadingType);
}
