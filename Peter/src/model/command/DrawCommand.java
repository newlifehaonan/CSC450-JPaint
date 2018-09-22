package model.command;

import model.interfaces.ICommand;
import model.shape.Point;
import model.interfaces.IApplicationState;
import model.shape.ShapeList;
import shape.interfaces.IShape;
import model.shape.ColorAdapter;
import model.ShapeType;
import model.ShapeShadingType;
import model.ShapeColor;

import java.awt.Graphics2D;
import java.util.ArrayList;

import Factory.ShapeFactory;

public class DrawCommand implements ICommand {
	
	private Point current;
	private ShapeList shapelist;
	private ColorAdapter primarycolor;
	private ColorAdapter secondarycolor;
	private ShapeType shapetype;
	private ShapeShadingType shadetype;
	private Graphics2D graphics;
	private IShape new_shape;
	public DrawCommand(ShapeList shapelist,Point point,IApplicationState appstate,Graphics2D graphics) {
		this.shapelist=shapelist;
		this.current=point;
		this.primarycolor=new ColorAdapter(appstate.getActivePrimaryColor());
		this.secondarycolor=new ColorAdapter(appstate.getActiveSecondaryColor());
		this.shapetype=appstate.getActiveShapeType();
		this.shadetype=appstate.getActiveShapeShadingType();
		this.graphics=graphics;
		
	}

	@Override
	public void run() {
		ShapeFactory factory = new ShapeFactory();
//		factory = new ShapeFactory();
		this.new_shape = factory.createShape(shadetype, shapetype, primarycolor, secondarycolor, this.current);
		this.shapelist.addshape(new_shape);
		ArrayList<IShape> list=shapelist.getaddedshape();
		for(IShape shape: list) {
			System.out.println(shape.getpoint().getstart()[0]);
			shape.show(graphics);
		}
	}

	@Override
	public void undo() {
		ShapeFactory factory = new ShapeFactory();
		
		IShape shape = factory.createShape(ShapeShadingType.OUTLINE_AND_FILLED_IN, this.shapetype, new ColorAdapter(ShapeColor.WHITE), new ColorAdapter(ShapeColor.WHITE), this.current);
		shape.show(this.graphics);
		
		
	}

	@Override
	public void redo() {
		ShapeFactory factory = new ShapeFactory();
		IShape shape = factory.createShape(shadetype, shapetype, primarycolor, secondarycolor, this.current);
		shape.show(this.graphics);
		this.shapelist.addshape(shape);
		
	}

}
