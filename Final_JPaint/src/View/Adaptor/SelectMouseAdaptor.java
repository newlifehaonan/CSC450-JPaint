package View.Adaptor;

import Controller.Command.SelectShapeCommand;
import Model.Interfaces.IApplicationState;
import Model.Interfaces.IShape;
import View.ShapeList;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectMouseAdaptor extends MouseAdapter {

    private Point startpoint;
    private Point endPoint;
    private IApplicationState applicationState;
    private ShapeList shapeList;
    private IShape shape;

    public SelectMouseAdaptor(IApplicationState applicationState, ShapeList shapeList) {
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
}
