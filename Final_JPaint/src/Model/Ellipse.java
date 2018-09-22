package Model;

import Model.Interfaces.IShape;
import View.Adaptor.ColorAdapter;
import View.Enum.ShapeColor;
import View.Enum.ShapeShadingType;
import View.Enum.ShapeType;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

public class Ellipse implements IShape,Serializable {

    int[]x = new int[2];
    int[]y = new int[2];
    int width;
    int height;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;
    ShapeShadingType shapeShadingType;
    ColorAdapter primaryColorAdaptor;
    ColorAdapter secondaryColorAdaptor;


    public Ellipse(Point mousePressPoint, Point mouseReleasePoint, ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shapeShadingType) {
        selectMaxandMin(mousePressPoint, mouseReleasePoint);
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shapeShadingType = shapeShadingType;
        primaryColorAdaptor = new ColorAdapter(primaryColor);
        secondaryColorAdaptor = new ColorAdapter(secondaryColor);
    }

    public void selectMaxandMin(Point start, Point end){
        int maxx =(int) Math.max(start.getX(), end.getX());
        int maxy =(int) Math.max(start.getY(), end.getY());
        int minx =(int) Math.min(start.getX(), end.getX());
        int miny =(int) Math.min(start.getY(), end.getY());

        x[0] = minx; x[1] = maxx; y[0] = miny; y[1] = maxy;
        width = maxx - minx; height = maxy - miny;
    }


    public void draw(Graphics g) {
//        System.out.println(primaryColorAdaptor.getColor(primaryColor));
        Graphics2D g2 = (Graphics2D) g;
        if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
            g2.setStroke(new BasicStroke(5));
            g.setColor(primaryColorAdaptor.getColor(primaryColor));
            g.drawOval(x[0], y[0], width, height);
        } else if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
            g2.setStroke(new BasicStroke(5));
            g.setColor(secondaryColorAdaptor.getColor(secondaryColor));
            g.fillOval(x[0], y[0], width, height);
        }else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            g2.setStroke(new BasicStroke(5));
            g.setColor(primaryColorAdaptor.getColor(primaryColor));
            g.drawOval(x[0], y[0], width, height);
            g.setColor(secondaryColorAdaptor.getColor(secondaryColor));
            g.fillOval(x[0], y[0], width, height);
        }
    }

    @Override
    public Boolean contain(Point startpoint) {
        return ( x[0] < startpoint.getX() &&
                 y[0] < startpoint.getY() &&
                 x[0] + width > startpoint.getX() &&
                 y[0] + height > startpoint.getY());
    }

    public void addX(int x) {

        this.x[0] += x;
        this.x[1] += x;
    }

    public void addY(int y) {

        this.y[0] += y;
        this.y[1] += y;
    }


    public Point getStartPoint() {
        return new Point(x[0], y[0]);
    }

    public Point getEndPoint() {
        return new Point(x[1], y[1]);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.ellipse;
    }

    @Override
    public ShapeShadingType getShadingType() {
        return shapeShadingType;
    }

    @Override
    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    @Override
    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    @Override
    public void setPrimaryColor(ShapeColor primaryColor) {
        this.primaryColor = primaryColor;
    }

    @Override
    public void setSecondaryColor(ShapeColor secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    @Override
    public void setShadingColor(ShapeShadingType shapeShadingType) {
        this.shapeShadingType = shapeShadingType;
    }
}
