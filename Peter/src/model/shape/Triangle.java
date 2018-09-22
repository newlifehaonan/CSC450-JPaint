package model.shape;

import java.awt.Graphics2D;

import model.ShapeShadingType;
import model.ShapeType;
import shape.interfaces.IShape;
import shape.interfaces.IStrategy;
import shapestrategy.TriangleStrategy;

public class Triangle implements IShape {
	private Point point;
	private ShapeShadingType shadetype;
	private ColorAdapter primarycolor;
	private ColorAdapter secondarycolor;
	public Triangle(ShapeShadingType shadetype,ColorAdapter primarycolor,ColorAdapter secondarycolor,Point point) {
		this.shadetype=shadetype;
		this.primarycolor=primarycolor;
		this.secondarycolor=secondarycolor;
		this.point=point;
		
		
	}
	@Override
	public void show(Graphics2D graphics) {
		IStrategy s=new TriangleStrategy(shadetype,primarycolor,secondarycolor,point);
		s.drawshape(graphics);
		
	}
	public boolean contains(Point point) {
 		int[] start=point.getstart();
 		int[] end=point.getend();
 		int[] O_start=this.point.getstart();
 		int[] O_end=this.point.getend();
 		int distance = Math.abs(start[0]-end[0]) + Math.abs(start[1]-end[1]);
 		
 		int midx=(O_start[0]+O_end[0])/2;
 		int midy=(O_start[1]+O_end[1])/2;
 		
 		
 		boolean result=false;
 		if(distance<=2) {
 			result=true;
 		}
 		else if((midx-start[0])*(midx-end[0]) <0) {
 			if((midy-start[1])*(midy-end[1])<0) {
 				result=true;
 			}
 		}
 		return result;
 		
 		}
	@Override
	public Point getpoint() {
		// TODO Auto-generated method stub
		return this.point;
	}
	@Override
	public ShapeType getshape() {
		// TODO Auto-generated method stub
		return ShapeType.TRIANGLE;
	}
}
