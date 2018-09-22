package model;

import view.interfaces.IDrawShape;
import view.interfaces.IShadedShape;

import java.util.ArrayList;
import java.util.List;

public class ShapeList implements IShapeListSubject {
    private final ArrayList<IDrawShape> internalShapesList = new ArrayList<IDrawShape>();
    private final ArrayList<IShapeListObserver> observers = new ArrayList<IShapeListObserver>();


    public void add(IDrawShape shapes) {
        System.out.println("ShapeList adding");
        internalShapesList.add(shapes);
        notifyObserver();
    }

    public void remove(IDrawShape shapes) {
        System.out.println("ShapeList adding");
        internalShapesList.remove(shapes);
        notifyObserver();
    }

    @Override
    public void register(IShapeListObserver observer) {
        observers.add(observer);
    }


    @Override
    public void unsubscribe(IShapeListObserver observer) {
        observers.remove(observer);

    }

    public ArrayList<IDrawShape> getShapeList(){
        return internalShapesList;
    }


    @Override
    public void notifyObserver() {
        System.out.println("ShapeList notifying " + observers.size() + " Observers...");
        System.out.println("InternalShapeList number of shapes: " + internalShapesList.size());

       for(IShapeListObserver newObserver : observers){
           newObserver.update();
       }
    }
}