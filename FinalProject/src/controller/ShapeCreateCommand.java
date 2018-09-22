package controller;

import model.IShapeListSubject;
import model.ShapeConfiguration;
import model.ShapeFactory;
import model.persistence.ApplicationState;
import view.interfaces.IDrawShape;


public class ShapeCreateCommand implements ICommand{

    ShapeFactory shapeFactory = new ShapeFactory();
    private final ApplicationState applicationState;
    private ShapeConfiguration shapeConfiguration;
    private IShapeListSubject shapeList;
    private IDrawShape shape;

    public ShapeCreateCommand(ApplicationState applicationState, IShapeListSubject shapeList, ShapeConfiguration shapeConfiguration){
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
 }

    @Override
    public void run() {
        System.out.println("ShapeCreateCommand running... ");
        shapeConfiguration = applicationState.getCurrentShapeConfiguration();
        shape = shapeFactory.createShape(shapeConfiguration);
        shapeList.add(shape);
    }
}
