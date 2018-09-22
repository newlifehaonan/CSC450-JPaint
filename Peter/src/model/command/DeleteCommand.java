package model.command;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Factory.ShapeFactory;
import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.ICommand;
import view.gui.PaintCanvas;
import view.interfaces.IEventCallback;
import model.shape.*;
import shape.interfaces.*;

public class DeleteCommand implements ICommand, IEventCallback {
	private ArrayList<IShape> deletedshapes;
	private Graphics2D graphics;
	private ShapeList shapelist;
	private PaintCanvas canvas;
	public DeleteCommand(PaintCanvas canvas,ShapeList shapelist) {
		this.graphics=canvas.getGraphics2D();
		this.deletedshapes = new ArrayList<>();
		this.shapelist=shapelist;
		this.canvas=canvas;
	}

	@Override
	public void run() {
		this.deletedshapes=shapelist.getselectshape();
		this.graphics.setColor(Color.WHITE);
		this.graphics.fillRect(canvas.getX(), canvas.getY(), canvas.getWidth(), canvas.getHeight());
		System.out.println(this.shapelist.getaddedshape().size());
		int counter=0;
		ArrayList<IShape> list=shapelist.getaddedshape();
		for(int i=0;i<list.size();i++) {
			IShape temp = list.get(i);
			temp.show(this.graphics);
			System.out.println(temp.getpoint().getstart()[0]);
			System.out.println(temp.getpoint().getstart()[1]);
			counter ++;
		}
		System.out.println(counter);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
