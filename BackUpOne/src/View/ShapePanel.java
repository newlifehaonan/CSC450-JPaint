package View;

import Model.Interfaces.IShape;
import View.Enum.ShapeType;
import View.Interfaces.IViewShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShapePanel extends JPanel implements IViewShape {

    ShapeType type;
    ArrayList<IShape> shapes = new ArrayList<IShape>();

    public void addShape(IShape shape) {
        shapes.add(shape);

        System.out.println(type);

        this.repaint();
    }


    public void setType(ShapeType type) {
        this.type = type;
    }

    public ShapeType getType() {
        return type;
    }

    @Override
    protected void paintComponent(Graphics g) {

        for(IShape shape : shapes) {
            shape.draw(g);
        }

    }

}
