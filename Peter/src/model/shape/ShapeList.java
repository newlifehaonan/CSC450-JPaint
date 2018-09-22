package model.shape;
import shape.interfaces.*;
import model.interfaces.*;
import java.util.*;
import model.shape.*;
public class ShapeList {
	private ArrayList<IShape> addedshapes;
	private ArrayList<IShape> selectedshapes;
	private Stack<ICommand> addedcommands;
	private Stack<ICommand> deletedcommands;
	public ShapeList() {
		this.addedshapes= new ArrayList<IShape>();
		this.selectedshapes= new ArrayList<IShape>();
		this.addedcommands=new Stack<>();
		this.deletedcommands= new Stack<>();
	}
	public void addshape(IShape shape) {
		this.addedshapes.add(shape);
		
		
	}
	public void addedcommands(ICommand command) {
		this.addedcommands.push(command);
	}
	public void selectshape(Point point) {
		
		ArrayList<IShape> new_shapes= new ArrayList<>();
		for (int i=0;i<this.addedshapes.size();i++) {
			IShape shape =this.addedshapes.get(i);
			if(shape.contains(point)) {
				this.selectedshapes.add(shape);	}
			else {new_shapes.add(shape);}
			}
		this.addedshapes=new_shapes;
		
		}
	public void undoselectshape(Point point) {
		
		ArrayList<IShape> new_shapes= new ArrayList<>();
		for (int i=0;i<this.selectedshapes.size();i++) {
			IShape shape =this.selectedshapes.get(i);
			if(shape.contains(point)) {
				this.selectedshapes.add(shape);	}
			else {new_shapes.add(shape);}
			}
		this.selectedshapes=new_shapes;
		}
	public ArrayList<IShape> getselectshape(){
		return this.selectedshapes;
	}
	public void deleteselectshape() {
		this.selectedshapes = new ArrayList<IShape>();
	}
	public ArrayList<IShape> getaddedshape(){
		return this.addedshapes;
	}
	
	

}
