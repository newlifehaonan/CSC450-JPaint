package GUI;

import Controller.DrawShape.Shape;
import GUI.interfaces.IViewShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GuiRectangle implements IViewShape {

    PaintCanvas canvas;
    Shape shape;

    public GuiRectangle(PaintCanvas canvas, Shape shape) {
        this.canvas = canvas;
        this.shape = shape;
    }

    @Override
    public void drawShape() {
        Graphics2D g2d = canvas.getGraphics2D();
        g2d.setPaint(Color.red);
        Rectangle2D.Float rectangle = new Rectangle2D.Float(shape.getStartPoint().x, shape.getStartPoint().y, shape.getWidth(), shape.getHeight());
        g2d.draw(rectangle);
    }

    @Override
    public void fillShape() {
        Graphics2D g2d = canvas.getGraphics2D();
        g2d.setPaint(Color.red);
        Rectangle2D.Float rectangle = new Rectangle2D.Float(shape.getStartPoint().x, shape.getStartPoint().y, shape.getWidth(), shape.getHeight());
        g2d.fill(rectangle);
    }


}
