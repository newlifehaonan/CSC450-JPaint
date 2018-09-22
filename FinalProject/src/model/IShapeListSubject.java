package model;

import view.interfaces.IDrawShape;
import view.interfaces.IShadedShape;

import java.util.ArrayList;

public interface IShapeListSubject {
    void add(IDrawShape shape);
    void remove(IDrawShape shape);
    ArrayList<IDrawShape> getShapeList();
    void register(IShapeListObserver paintCanvas);
    void unsubscribe(IShapeListObserver paintCanvas);
    void notifyObserver();
}
