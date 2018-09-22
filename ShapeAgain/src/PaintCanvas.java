import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class PaintCanvas extends JPanel {

    ArrayList<Shape> shapes = new ArrayList<Shape>();
    Point startPoint;
    Point endPoint;
    Shape shape;

    public PaintCanvas() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endPoint = e.getPoint();
            }
        });


        shape = new Shape(ShapeType.rectangle, startPoint, endPoint);
        shapes.add(shape);

        Rectangle2D rec = new Rectangle2D.Float()
    }



}
