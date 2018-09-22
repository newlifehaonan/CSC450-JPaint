package Model.Interfaces;

import View.Enum.ShapeColor;
import View.Enum.ShapeShadingType;
import View.Enum.ShapeType;
import View.Enum.StartAndEndPointMode;

public interface IApplicationState  {

    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();

    void registerObserver(MouseObserver o);
    void notifyObservers();
}
