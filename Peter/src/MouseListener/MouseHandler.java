package MouseListener;
import java.awt.event.*;

import model.command.DrawCommand;
import model.command.SelectCommand;
import model.interfaces.*;
import shape.interfaces.*;
import view.gui.*;
import java.awt.*;
import model.*;
import model.shape.*;
import model.shape.Point;
public class MouseHandler extends MouseAdapter {
	
	private IApplicationState appstate;
	private int[] start = new int[2];
	private int[] end = new int[2];
	private PaintCanvas canvas;
	private ShapeList shapelist;
	
	public MouseHandler(IApplicationState appstate,PaintCanvas canvas,ShapeList shapelist) {
		this.appstate=appstate;
		this.canvas=canvas;
		this.shapelist=shapelist;
	}
	public void mousePressed(MouseEvent e) {
		this.start[0]=e.getX();
		this.start[1]=e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		this.end[0]=e.getX();
		this.end[1]=e.getY();
		Point point = new Point(start,end);
		
		if(this.appstate.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.DRAW)) {
		ICommand drawcommand = new DrawCommand(shapelist,point, appstate,canvas.getGraphics2D());
		this.shapelist.addedcommands(drawcommand);
		drawcommand.run();}
		
		else if(this.appstate.getActiveStartAndEndPointMode().equals(StartAndEndPointMode.SELECT)) {
			ICommand selectcommand = new SelectCommand(point,this.shapelist);
			this.shapelist.addedcommands(selectcommand);
			selectcommand.run();}
		
	}
	
	
}
