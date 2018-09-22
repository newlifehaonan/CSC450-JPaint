package Model.Factory;

import Model.Ellipse;
import Model.Interfaces.IShape;
import Model.Rectangle;
import Model.Triangle;
import View.Enum.ShapeColor;
import View.Enum.ShapeShadingType;
import View.Enum.ShapeType;
import java.awt.*;

public class ShapeFactory {

    public IShape createShape(ShapeType shapeType, Point mousePressPoint, Point mouseReleasePoint, ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shapeShadingType) {
        IShape shape = null;

        if(shapeType.equals(ShapeType.rectangle)) {
            shape = new Rectangle(mousePressPoint, mouseReleasePoint,primaryColor,secondaryColor,shapeShadingType);
        }
        else if (shapeType.equals(ShapeType.ellipse)) {
            shape = new Ellipse(mousePressPoint, mouseReleasePoint, primaryColor, secondaryColor, shapeShadingType);
        }
        else if(shapeType.equals(ShapeType.triangle)) {
            shape = new Triangle(mousePressPoint, mouseReleasePoint, primaryColor, secondaryColor, shapeShadingType);
        }
        return shape;
    }
}
