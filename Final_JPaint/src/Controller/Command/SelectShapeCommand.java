package Controller.Command;

import Controller.Interfaces.ICommand;
import Model.Interfaces.IApplicationState;
import Model.Interfaces.IShape;
import View.ShapeList;

import java.awt.*;
import java.util.ArrayList;

public class SelectShapeCommand implements ICommand {
    ShapeList shapeList;
    IApplicationState applicationState;
    Point mousePressPoint;
    IShape selectedShape;
    Boolean atLeastOneShapeContain = false;

    public SelectShapeCommand(IApplicationState applicationState, ShapeList shapeList, Point mousePressPoint) {
        this.applicationState = applicationState;
        this.mousePressPoint = mousePressPoint;
        this.shapeList = shapeList;
    }

    public IShape getSelectedShape() {
        return selectedShape;
    }

    @Override
    public void excute() {
        ArrayList<IShape> shapes = shapeList.getShapes();
        for(IShape shape: shapes) {
            if(shape.contain(mousePressPoint)) {
                atLeastOneShapeContain = true;
                selectedShape = shape;
                shapeList.addToSelectedShapeList(shape);
                System.out.println("Shape Selected");
                break;
            }
            else {
                atLeastOneShapeContain = false;
            }
        }
        shapeList.updateShape();

        if(atLeastOneShapeContain == false) {
            shapeList.clearAllSelected();
            System.out.println("Shape DeSelected");
        }
    }
}
