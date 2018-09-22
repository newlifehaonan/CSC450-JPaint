package View.Adaptor;

import Controller.Command.CreateShapeCommand;
import Controller.Command.DeleteShapeCommand;
import Controller.Command.SelectShapeCommand;
import Model.Interfaces.IApplicationState;
import Model.Interfaces.IShape;
import View.Enum.ShapeColor;
import View.Enum.ShapeShadingType;
import View.Enum.ShapeType;
import View.ShapeList;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MoveMouseAdaptor extends MouseAdapter {

    private Point startpoint;
    private Point endPoint;
    private IApplicationState applicationState;
    private ShapeList shapeList;
    private IShape shape;

    public MoveMouseAdaptor(IApplicationState applicationState, ShapeList shapeList) {
        this.shapeList = shapeList;
        this.applicationState = applicationState;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startpoint = e.getPoint();
        SelectShapeCommand selectShapeCommand = new SelectShapeCommand(applicationState,shapeList,startpoint);
        selectShapeCommand.excute();

        shape = selectShapeCommand.getSelectedShape();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint = e.getPoint();
        int dx =(int) (endPoint.getX() - startpoint.getX());
        int dy =(int) (endPoint.getY() - startpoint.getY());
        try {
            shape.addX(dx);
            shape.addY(dy);

            ShapeType shapeType = shape.getShapeType();
            ShapeShadingType shapeShadingType = shape.getShadingType();
            ShapeColor primaryColor = shape.getPrimaryColor();
            ShapeColor secondaryColor = shape.getSecondaryColor();

            DeleteShapeCommand deleteShapeCommand = new DeleteShapeCommand(applicationState, shapeList);
            deleteShapeCommand.excute();

            CreateShapeCommand createShapeCommand = new CreateShapeCommand(
                    shapeType,
                    shapeShadingType,
                    shape.getStartPoint(),
                    shape.getEndPoint(),
                    shapeList,
                    primaryColor,
                    secondaryColor);
            createShapeCommand.excute();

        } catch (NullPointerException e1) {
            System.out.println("Shape not Selected, Unable to Move!");
        }

    }
}
