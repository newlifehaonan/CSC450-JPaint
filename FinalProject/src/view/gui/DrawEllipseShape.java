package view.gui;

import controller.Point;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;
import model.dialogs.ColorAdapter;
import view.interfaces.IDrawShape;
import java.awt.*;

public class DrawEllipseShape implements IDrawShape {

    private ShapeConfiguration shapeConfiguration;
    private ShapeShadingType shapeShadingType;
    private Color primaryColor;
    private Color secondaryColor;
    private int width;
    private int height;
    private Point adjustedStart;
    private Point startPoint;


  public DrawEllipseShape(ShapeConfiguration shapeConfiguration){
        this.shapeConfiguration = shapeConfiguration;
        this.shapeShadingType = shapeConfiguration.getShadingType();
        this.primaryColor = ColorAdapter.getColor(shapeConfiguration.getPrimaryColor());
        this.secondaryColor = ColorAdapter.getColor(shapeConfiguration.getSecondaryColor());
        this.width = shapeConfiguration.getWidth();
        this.height = shapeConfiguration.getHeight();
        this.adjustedStart = shapeConfiguration.getAdjustedStart();
        this.startPoint = shapeConfiguration.getStartPoint();
    }


    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(5));
            g.drawOval(adjustedStart.getX(), adjustedStart.getY(), width, height);
        } else if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
            g.setColor(secondaryColor);
            g.fillOval(adjustedStart.getX(), adjustedStart.getY(), width, height);
        } else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            g.setColor(primaryColor);
            g2.setStroke(new BasicStroke(5));
            g.drawOval(adjustedStart.getX(), adjustedStart.getY(), width, height);
            g.setColor(secondaryColor);
            g.fillOval(adjustedStart.getX(), adjustedStart.getY(), width, height);
        }
    }

    public boolean contains(Point startPoint){
      return (adjustedStart.getX() < startPoint.getX() && adjustedStart.getY() < startPoint.getY()
              && adjustedStart.getX() + width > startPoint.getX() && adjustedStart.getY() + height > startPoint.getY());
    }

    public Point getStartPoint(){
        return startPoint;
    }

    @Override
    public void addX(int dx) {

    }

    @Override
    public void addY(int dy) {

    }

    @Override
    public Point getAdjustedEnd() {
        return null;
    }

    @Override
    public Point getAdjustedStart() {
        return null;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public Color getSecondaryColor() {
        return null;
    }

    @Override
    public Color getPrimaryColor() {
        return null;
    }

    @Override
    public ShapeShadingType getShapeShadingType() {
        return null;
    }

    @Override
    public ShapeType getShapeType() {
        return null;
    }

    @Override
    public ShapeConfiguration getShapeConfiguration() {
        return null;
    }
}

