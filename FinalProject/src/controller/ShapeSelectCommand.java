package controller;

import model.IShapeListSubject;
import model.ShapeConfiguration;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.interfaces.IDrawShape;

public class ShapeSelectCommand implements ICommand{

    private IShapeListSubject shapeList;
    private IDrawShape selectedShape;
    private ShapeConfiguration shapeConfiguration;
    private ApplicationState applicationState;

    public ShapeSelectCommand(ApplicationState applicationState, IShapeListSubject shapeList, ShapeConfiguration shapeConfiguration){
        this.shapeList = shapeList;
        this.shapeConfiguration = shapeConfiguration;
        this.applicationState = applicationState;
         }


    @Override
    public void run() {
        System.out.println("ShapeSelectCommand running...");

        for (IDrawShape shape : shapeList.getShapeList()) {
            boolean contain = shape.contains(applicationState.getStartPoint());
            if (contain) {
                System.out.println(">> Shape selected.");
                selectedShape = shape;
            break; }
            else
            {
                System.out.println("Shape not selected.");
            }
        }
    }

    public IDrawShape getSelectedShape(){
        return selectedShape;
    }
}
