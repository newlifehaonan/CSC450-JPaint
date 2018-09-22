package View;

import Model.ApplicationState;
import Model.Interfaces.IApplicationState;
import Model.Interfaces.IShape;
import Model.Interfaces.MouseObserver;
import View.Adaptor.ColorAdapter;
import View.Interfaces.IDrawCanvas;
import View.Interfaces.IShapeListSubject;
import View.Interfaces.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShapeList implements IShapeListSubject, MouseObserver {

    ArrayList<Observer> Observers;
    ArrayList<IShape> shapes;
    ArrayList<IShape> selectedShapes;
    IApplicationState applicationState;



    public ShapeList(IApplicationState applicationState) {
        Observers = new ArrayList<Observer>();
        shapes = new ArrayList<IShape>();
        selectedShapes = new ArrayList<IShape>();
        this.applicationState = applicationState;

        applicationState.registerObserver(this);
    }

    @Override
    public void registerObserver(Observer o) {
        Observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : Observers) {
            observer.update();
        }
    }

    public void add(IShape shape) {
        shapes.add(shape);
        notifyObservers();
    }

    public void remove(int i) {
        shapes.remove(i);
        notifyObservers();
    }

    public void updateShape() {

        for(IShape shape : selectedShapes) {
            shape.setPrimaryColor(applicationState.getActivePrimaryColor());
            shape.setSecondaryColor(applicationState.getActiveSecondaryColor());
            shape.setShadingColor(applicationState.getActiveShapeShadingType());
        }

        notifyObservers();
    }

    public void addToSelectedShapeList(IShape shape) {
        selectedShapes.add(shape);
    }

    public ArrayList<IShape> getSelectedShapes() {
        return selectedShapes;
    }

    public void removeAllSelectedShapes() {
        shapes.removeAll(selectedShapes);
        notifyObservers();
    }

    public void clearshapelist() {
        shapes.clear();
    }

    public void addToList(List<IShape> arrayList){
        for(IShape shape: arrayList) {
            shapes.add(shape);
        }
    }

    public void clearAllSelected() {
        selectedShapes.clear();
    }

    public int getShapeIndex(IShape shape) {
        return shapes.indexOf(shape);
    }

    public ArrayList<IShape> getShapes() {
        return  shapes;
    }

    @Override
    public void update() {
        updateShape();
    }
}
