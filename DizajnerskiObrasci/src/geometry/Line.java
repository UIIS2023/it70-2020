package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5521523640405487830L;
	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, Color color) {
		this(startPoint, endPoint);
		this.color = color;
	}
	
	public Line(Point startPoint, Point endPoint, Color color, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
		this.setColor(color);
	}
	
	public boolean contains(int x, int y) {
		return startPoint.distance(x, y)+ endPoint.distance(x, y) - lenght() <=2;
	}
	
	@Override
	public void draw(Graphics g) {
		
		g.setColor(color);
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(getStartPoint().getX() - 2, getStartPoint().getY() - 2, 4, 4);
			g.drawRect(getEndPoint().getX() - 2, getEndPoint().getY() - 2, 4, 4);
		}
	}
	
	public double lenght() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line pomocna = (Line)obj;
			if (this.startPoint.equals(pomocna.startPoint) && this.endPoint.equals(pomocna.endPoint)) {
				return true;
			} else
				return false;
		} else 
			return false;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint(){
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	
	public String toString() {
		return startPoint + "-->" + endPoint;
	}

	@Override
	public void moveTo(int x, int y) {
			/*int tempX = startPoint.getX() - x;
			int tempY = startPoint.getY() - y;
			startPoint.moveTo(x, y);
			endPoint.moveTo(endPoint.getX() - tempX, endPoint.getY() - tempY);*/
	}

	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			return (int) (this.lenght() - ((Line)o).lenght());
		}
		return 0;
	}
	
	@Override
	public Line clone() {
		
		Line cloneLine = new Line();	
		cloneLine.setStartPoint(new Point());
		cloneLine.setEndPoint(new Point());
		cloneLine.getStartPoint().setX(this.getStartPoint().getX());
		cloneLine.getStartPoint().setY(this.getStartPoint().getY());
		cloneLine.getEndPoint().setX(this.getEndPoint().getX());
		cloneLine.getEndPoint().setY(this.getEndPoint().getY());
		cloneLine.setColor(this.getColor());
		cloneLine.setSelected(this.isSelected());
		
		return cloneLine;
	}

	

}
