package Controller.Interfaces;

import java.awt.*;

public interface IShape {

    Point.Float getStartPoint();

    Point.Float getEndPoint();

    void setStartPoint();

    void setEndPoint();

    float getWidth();

    float getHeight();
}
