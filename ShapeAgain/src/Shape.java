import java.awt.*;

public class Shape {

    ShapeType shapeType;
    Point startPoint;
    Point endPoint;

    public Shape(ShapeType shapeType, Point startPoint, Point endPoint) {
        this.shapeType = shapeType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public int getWidth() {
        return endPoint.x - startPoint.y;
    }

    public int getHeight() {
        return endPoint.y - startPoint.y;
    }
}
