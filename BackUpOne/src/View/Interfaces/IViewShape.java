package View.Interfaces;

import Model.Interfaces.IShape;
import View.Enum.ShapeType;

public interface IViewShape {
    void addShape(IShape shape);

    void setType(ShapeType type);

   ShapeType getType();
}
