package controller;

import model.IShapeListSubject;
import model.ShapeConfiguration;
import model.ShapeFactory;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.IDrawShape;

public class ShapeMoveCommand implements ICommand{
    private ApplicationState applicationState;
    private IShapeListSubject shapeList;
    private ShapeConfiguration shapeConfiguration;
    private IDrawShape selectedShape;

    public ShapeMoveCommand(ApplicationState applicationState, IShapeListSubject shapeList, ShapeConfiguration shapeConfiguration){
       this.applicationState = applicationState;
       this.shapeList = shapeList;
       this.shapeConfiguration = shapeConfiguration;

   }



    @Override
    public void run() {
        System.out.println("ShapeMoveCommand running...");

        ShapeSelectCommand selectCommand = new ShapeSelectCommand(applicationState, shapeList, shapeConfiguration);
        selectCommand.run();
        selectedShape = selectCommand.getSelectedShape();

            int dx = (int) applicationState.getAdjustedEnd().getX() - applicationState.getAdjustedStart().getX();
            int dy = (int) applicationState.getAdjustedEnd().getY() - applicationState.getAdjustedStart().getY();

            shapeList.remove(selectedShape);

            selectedShape.addX(dx);
            selectedShape.addY(dy);

            ShapeCreateCommand shapeCreateCommand = new ShapeCreateCommand(applicationState,shapeList, selectedShape.getShapeConfiguration());
            shapeCreateCommand.run();

    }
}
