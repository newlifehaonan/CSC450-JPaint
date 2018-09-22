package View;

import View.Adaptor.EllipseMouseAdaptor;
import View.Adaptor.RectangleMouseAdaptor;
import View.Adaptor.TriangleMouseAdaptor;
import View.Enum.ShapeType;
import View.Interfaces.TypeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame {

    private Toolbar toolbar;

    private ShapePanel canvas;

    public MainFrame() {

        super("Graphic 2D demo");

        this.toolbar = new Toolbar();

        this.canvas = new ShapePanel();

        MouseAdapter rectangleMouseAdaptor = new RectangleMouseAdaptor(canvas);
        MouseAdapter ellipseMouseAdaptor = new EllipseMouseAdaptor(canvas);
        MouseAdapter triangleMouseAdaptor = new TriangleMouseAdaptor(canvas);

        toolbar.setTypeListener(new TypeListener() {
            @Override
            public void TypeEmitted(ShapeType shapeType) {
                canvas.setType(shapeType);
                ShapeType type = canvas.getType();
                System.out.println(canvas.getType());

                MouseListener[] mouseListeners = canvas.getMouseListeners();
                for(MouseListener mouseListener : mouseListeners) {
                    canvas.removeMouseListener(mouseListener);
                }

                if(type == ShapeType.rectangle) {
                    canvas.addMouseListener(rectangleMouseAdaptor);
                }
                else if (type == ShapeType.ellipse) {
//                    canvas.removeMouseListener(rectangleMouseAdaptor);
                    canvas.addMouseListener(ellipseMouseAdaptor);
                }
                else if (type == shapeType.triangle) {

                    canvas.addMouseListener(triangleMouseAdaptor);
                }
            }
        });



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(700,700);

        setVisible(true);

        setLayout(new BorderLayout());

        add(toolbar, BorderLayout.NORTH);

        add(canvas, BorderLayout.CENTER);

    }

}
