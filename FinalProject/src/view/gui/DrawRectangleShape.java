package view.gui;

import controller.Point;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import model.dialogs.ColorAdapter;
import view.interfaces.IDrawShape;
import java.awt.*;

public class DrawRectangleShape implements IDrawShape {

    private ShapeConfiguration shapeConfiguration;
    private ShapeShadingType shapeShadingType;
    private Color primaryColor;
    private Color secondaryColor;
    private int width;
    private int height;
    private Point adjustedStart;
    private Point adjustedEnd;
    private Point startPoint;
    private Point endPoint;
    private ShapeType shapeType;

    public DrawRectangleShape(ShapeConfiguration shapeConfiguration) {
        this.shapeConfiguration = shapeConfiguration;
        this.shapeShadingType = shapeConfiguration.getShadingType();
        this.primaryColor = ColorAdapter.getColor(shapeConfiguration.getPrimaryColor());
        this.secondaryColor = ColorAdapter.getColor(shapeConfiguration.getSecondaryColor());
        this.width = shapeConfiguration.getWidth();
        this.height = shapeConfiguration.getHeight();
        this.adjustedStart = shapeConfiguration.getAdjustedStart();
        this.adjustedEnd = shapeConfiguration.getAdjustedEnd();
        this.startPoint = shapeConfiguration.getStartPoint();
        this.shapeType = shapeConfiguration.getShapeType();
        this.endPoint = shapeConfiguration.getEndPoint();

    }


    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(5));
            g.drawRect(adjustedStart.getX(), adjustedStart.getY(), width, height);
        } else if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
            g.setColor(secondaryColor);
            g.fillRect(adjustedStart.getX(), adjustedStart.getY(), width, height);
        } else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(5));
            g.drawRect(adjustedStart.getX(), adjustedStart.getY(), width, height);
            g.setColor(secondaryColor);
            g.fillRect(adjustedStart.getX(), adjustedStart.getY(), width, height);
        }
    }

    public boolean contains(Point startPoint) {
        return (adjustedStart.getX() < startPoint.getX() && adjustedStart.getY() < startPoint.getY()
                && adjustedStart.getX() + width > startPoint.getX() && adjustedStart.getY() + height > startPoint.getY());
    }

    public Point getStartPoint(){
        return startPoint;
    }


    public ShapeConfiguration getShapeConfiguration() {
        return shapeConfiguration;
    }

    public ShapeShadingType getShapeShadingType() {
        return shapeShadingType;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Point getAdjustedStart() {
        return adjustedStart;
    }

    public Point getAdjustedEnd() {
        return adjustedEnd;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }


    @Override
    public void addX(int dx) {
//        Something wrong in here
        startPoint.setX(startPoint.getX() + dx);
        endPoint.setX(endPoint.getX() + dx);
//        width += dx;
    }

    @Override
    public void addY(int dy) {
//        somthing wrong here.
        startPoint.setY(startPoint.getY() + dy);
        endPoint.setY(endPoint.getY() + dy);
//        height += dy;
    }


}

