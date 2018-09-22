package View.Interfaces;

public interface IShapeListSubject {
    void registerObserver(Observer o);
    void notifyObservers();
}
