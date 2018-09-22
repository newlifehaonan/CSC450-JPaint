package Controller.Command;

import Controller.Interfaces.ICommand;
import Controller.Interfaces.IUndoable;
import Model.Factory.ShapeFactory;
import Model.Interfaces.IApplicationState;
import Model.Interfaces.IShape;
import View.Enum.ShapeColor;
import View.Enum.ShapeShadingType;
import View.Enum.ShapeType;
import View.ShapeList;
import java.awt.*;


public class CreateShapeCommand implements ICommand, IUndoable {

    ShapeFactory shapeFactory = new ShapeFactory();
    ShapeList shapeList;
    IApplicationState applicationState;
    Point mousePressPoint, mouseReleasePoint;
    ShapeType shapeType;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;
    ShapeShadingType shapeShadingType;
    IShape createdShape;

    public CreateShapeCommand(IApplicationState applicationState, Point mousePressPoint, Point mouseReleasePoint, ShapeList shapeList) {
        this.applicationState = applicationState;
        this.mousePressPoint = mousePressPoint;
        this.mouseReleasePoint = mouseReleasePoint;
        this.shapeList = shapeList;
        shapeType = applicationState.getActiveShapeType();
        primaryColor = applicationState.getActivePrimaryColor();
        secondaryColor = applicationState.getActiveSecondaryColor();
        shapeShadingType = applicationState.getActiveShapeShadingType();
    }

    public CreateShapeCommand(ShapeType shapeType,
                              ShapeShadingType shapeShadingType,
                              Point mousePressPoint,
                              Point mouseReleasePoint,
                              ShapeList shapeList,
                              ShapeColor primaryColor,
                              ShapeColor secondaryColor) {
        this.mousePressPoint = mousePressPoint;
        this.mouseReleasePoint = mouseReleasePoint;
        this.shapeList = shapeList;
        this.shapeType = shapeType;
        this.shapeShadingType = shapeShadingType;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    @Override
    public void excute() {

        createdShape = shapeFactory.createShape(shapeType,mousePressPoint, mouseReleasePoint,primaryColor,secondaryColor,shapeShadingType);
        this.shapeList.add(createdShape);
        CommandHistory.add(this);
    }

    public IShape getCreatedShape() {
        return createdShape;
    }

    @Override
    public void undo() {
        shapeList.remove(shapeList.getShapeIndex(createdShape));
    }

    @Override
    public void redo() {
        shapeList.add(createdShape);
    }
}
