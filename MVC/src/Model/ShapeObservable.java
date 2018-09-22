package Model;


import Utility.Observable;
import Utility.Observer;

import java.util.ArrayList;
import java.util.Iterator;


public class ShapeObservable implements Observable {

    ArrayList<Observer> observers = new ArrayList<Observer>();
    Observable shape;

    public ShapeObservable(Observable shape) {
        this.shape = shape;
    }

    @Override
    public void registerObservers(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {

        Iterator<Observer> iterator = observers.iterator();

        while (iterator.hasNext()) {

            Observer observer = iterator.next();
            observer.update();
        }
    }
}
