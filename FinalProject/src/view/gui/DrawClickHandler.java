package view.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.Point;
import controller.ShapeCreateCommand;
import controller.ShapeMoveCommand;
import controller.ShapeSelectCommand;
import model.IShapeListSubject;
import model.ShapeConfiguration;
import model.StartAndEndPointMode;
import model.persistence.ApplicationState;
import view.interfaces.IDrawShape;


public class DrawClickHandler extends MouseAdapter {
    private Point startPoint;
    private Point endPoint;
    private ApplicationState applicationState;
    private IShapeListSubject shapeList;
    private ShapeConfiguration shapeConfiguration;


    public DrawClickHandler(ApplicationState applicationState, IShapeListSubject shapeList, ShapeConfiguration shapeConfiguration) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(), e.getY());
        applicationState.setStartPoint(startPoint);
        System.out.println("DrawClickHandler reporting Mouse was pressed. Point (Start): " + "(" + startPoint.getX() + "," + startPoint.getY() + ")");
    }


    @Override
    public void mouseReleased(MouseEvent e) {

        endPoint = new Point(e.getX(), e.getY());
        applicationState.setEndPoint(endPoint);
        StartAndEndPointMode mouseMode = applicationState.getActiveStartAndEndPointMode();
        System.out.println("DrawClickHandler reporting Mouse was released. Point(End): " + "(" + endPoint.getX() + "," + endPoint.getY() + ")");


        switch (mouseMode) {
            case DRAW:
                ShapeCreateCommand newShape = new ShapeCreateCommand(applicationState, shapeList, shapeConfiguration );
                newShape.run();
                break;

            case MOVE:
                ShapeMoveCommand newMove = new ShapeMoveCommand(applicationState,shapeList, shapeConfiguration);
                newMove.run();
                break;

            case SELECT:
                ShapeSelectCommand newSelect = new ShapeSelectCommand(applicationState, shapeList, shapeConfiguration);
                newSelect.run();
                break;
        }
    }
}
