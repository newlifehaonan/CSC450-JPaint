package shape.interfaces;
import java.awt.Graphics2D;
import model.shape.*;
import model.*;
public interface IShape {
	public void show(Graphics2D graphics);
	public boolean contains(Point point);
	public  Point getpoint();
	public ShapeType getshape();
}
