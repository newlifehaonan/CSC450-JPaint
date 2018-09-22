package Utility;

import Utility.Observer;

public interface Observable {

    void registerObservers(Observer observer);

    void notifyObservers();

}
