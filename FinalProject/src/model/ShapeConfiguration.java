package model;

import controller.Point;
import model.persistence.ApplicationState;

public class ShapeConfiguration {

    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private Point startPoint;
    private Point endPoint;
    private ShapeShadingType shadingType;
    private ShapeType shapeType;

    public void setPrimaryColor(ShapeColor primaryColor) {
        this.primaryColor = primaryColor;
    }

    public void setSecondaryColor(ShapeColor secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public void setShadingType(ShapeShadingType shadingType) {
        this.shadingType = shadingType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public ShapeShadingType getShadingType() {
        return shadingType;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public int getWidth() {
        Point  adjustedStart = getAdjustedStart();
        Point  adjustedEnd = getAdjustedEnd();
        return adjustedEnd.getX() - adjustedStart.getX();
    }

    public int getHeight() {
        Point  adjustedStart = getAdjustedStart();
        Point  adjustedEnd = getAdjustedEnd();
        return adjustedEnd.getY() - adjustedStart.getY();
    }

    public Point getAdjustedStart(){
        int startX = Math.min(startPoint.getX(), endPoint.getX());
        int startY = Math.min(startPoint.getY(), endPoint.getY());
        return new Point(startX, startY);
    }

    public Point getAdjustedEnd(){
        int endX = Math.max(startPoint.getX(), endPoint.getX());
        int endY = Math.max(startPoint.getY(), endPoint.getY());
        return new Point(endX, endY);
    }


}
