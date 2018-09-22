package View;

import Model.Interfaces.IShape;
import View.Enum.ShapeType;
import View.Interfaces.IDrawCanvas;
import View.Interfaces.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DrawCanvas extends JPanel implements IDrawCanvas, Observer {

    ShapeList shapeList;

    public DrawCanvas(ShapeList shapeList) {
        this.shapeList = shapeList;
        shapeList.registerObserver(this);
    }


    public ArrayList<IShape> getShapes() {
        return shapeList.getShapes();
    }

    @Override
    protected void paintComponent(Graphics g) {

        for(IShape shape : getShapes()) {
            shape.draw(g);
        }
    }

    @Override
    public void update() {
        repaint();
    }
}
