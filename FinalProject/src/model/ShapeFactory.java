package model;

import javafx.scene.shape.Ellipse;
import view.gui.DrawEllipseShape;
import view.gui.DrawRectangleShape;
import view.gui.DrawTriangleShape;
import view.interfaces.IDrawShape;

public class ShapeFactory {

    public IDrawShape createShape(ShapeConfiguration shapeConfiguration) {
        ShapeType shapeType = shapeConfiguration.getShapeType();
        IDrawShape shape = null;


        if(shapeType.equals(ShapeType.RECTANGLE)) {
            System.out.println("Rectangle Shape factory is running.");
            shape = new DrawRectangleShape(shapeConfiguration);
        }
        else if (shapeType.equals(ShapeType.ELLIPSE)) {
            System.out.println("Ellipse Shape factory is running.");
            shape = new DrawEllipseShape(shapeConfiguration);
        }
        else if(shapeType.equals(ShapeType.TRIANGLE)) {
            System.out.println("Triangle Shape factory is running.");
            shape = new DrawTriangleShape(shapeConfiguration);
        }
        else{
            System.out.println("this is NULLLLLLLL");
        }
        return shape;
    }
}
