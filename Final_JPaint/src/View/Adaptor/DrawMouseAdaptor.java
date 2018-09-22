package View.Adaptor;

import Controller.Command.CreateShapeCommand;
import Model.Interfaces.IApplicationState;
import View.Enum.ShapeColor;
import View.ShapeList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawMouseAdaptor extends MouseAdapter {

    private Point startpoint;
    private Point endPoint;
    private IApplicationState applicationState;
    private ShapeList shapeList;
    public DrawMouseAdaptor(IApplicationState applicationState, ShapeList shapeList) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        startpoint = e.getPoint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        endPoint = e.getPoint();

        CreateShapeCommand createShapeCommand = new CreateShapeCommand(applicationState, startpoint, endPoint, shapeList);
        createShapeCommand.excute();

    }
}
