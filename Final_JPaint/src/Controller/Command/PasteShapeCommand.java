package Controller.Command;

import Controller.Interfaces.ICommand;
import Controller.Interfaces.IUndoable;
import Model.Interfaces.IApplicationState;
import Model.Interfaces.IShape;
import View.ShapeList;

import java.awt.*;
import java.util.ArrayList;

public class PasteShapeCommand implements ICommand,IUndoable {

    IApplicationState applicationState;
    ShapeList shapeList;

    ArrayList<IShape> pastedShapes = new ArrayList<IShape>();

    public PasteShapeCommand(IApplicationState applicationState, ShapeList shapeList) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
    }

    @Override
    public void excute() {
        ArrayList<IShape> selectedShapes = shapeList.getSelectedShapes();
        for(IShape shape :selectedShapes) {

            Point newStartPoint = getNewShapeDrawPoint(shape.getStartPoint());
            Point newEndPoint = getNewShapeDrawPoint(shape.getEndPoint());

            CreateShapeCommand createShapeCommand = new CreateShapeCommand(shape.getShapeType(),
                    shape.getShadingType(),newStartPoint, newEndPoint, shapeList, shape.getPrimaryColor(),shape.getSecondaryColor());

            createShapeCommand.excute();

            pastedShapes.add(createShapeCommand.getCreatedShape());

            System.out.println("Shape Copied");
            CommandHistory.add(this);
        }
    }

    private Point getNewShapeDrawPoint(Point point) {
        int newX = (int) (point.getX() + 50);
        int newY = (int) (point.getY() + 50);
        return new Point(newX, newY);
    }


    @Override
    public void undo() {
        for(IShape shape: pastedShapes) {
            shapeList.remove(shapeList.getShapeIndex(shape));
        }
    }

    @Override
    public void redo() {
        for(IShape shape: pastedShapes) {
            shapeList.add(shape);
        }
    }
}
