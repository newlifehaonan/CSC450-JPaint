package view.gui;

import controller.CommandHistory;
import model.IShapeListObserver;
import model.IShapeListSubject;
import model.ShapeConfiguration;
import view.interfaces.IDrawShape;
import view.interfaces.IShadedShape;

import javax.swing.JComponent;
import java.awt.*;
import java.util.List;

public class PaintCanvas extends JComponent implements IShapeListObserver {
    private final IShapeListSubject shapelist;


    public PaintCanvas(IShapeListSubject shapelist) {
        this.shapelist = shapelist;
        shapelist.register(this);
    }

    @Override
    public void update() {
        System.out.println("In PaintCanvas drawing to canvas. Iterating list.");
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (IDrawShape shape : shapelist.getShapeList()) {
            shape.paint(g);
        }
    }

    public Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphics();
    }
}
