package Controller.Command;

import Controller.Interfaces.ICommand;
import Controller.Interfaces.IUndoable;
import Model.Interfaces.IApplicationState;
import Model.Interfaces.IShape;
import View.ShapeList;

import java.util.ArrayList;


public class DeleteShapeCommand implements ICommand, IUndoable {

    IApplicationState applicationState;
    ShapeList shapeList;

    ArrayList<IShape> selectedShapes;

    public DeleteShapeCommand(IApplicationState applicationState, ShapeList shapeList) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
    }

    @Override
    public void excute() {

        selectedShapes = shapeList.getSelectedShapes();

        if(selectedShapes.isEmpty()){
            System.out.println("No Shape Selected");
        }else {
            shapeList.removeAllSelectedShapes();
            System.out.println("Selected Shapes Removed!");
            CommandHistory.add(this);
        }
    }

    @Override
    public void undo() {
        for(IShape shape : selectedShapes) {
            shapeList.add(shape);
        }
    }

    @Override
    public void redo() {
        for(IShape shape : selectedShapes) {
            shapeList.remove(shapeList.getShapeIndex(shape));
        }
    }
}
