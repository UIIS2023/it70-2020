package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3486027680160503836L;
	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point(int x, int y, Color color){
		this(x, y);
		this.color = color;
	}
	
	public Point(int x, int y, Color color, boolean selected){
		this(x, y);
		this.selected = selected;
		this.color = color;
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y + 2, x, y - 2);
		
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(x - 2, y - 2, 4, 4);
		}
		
	}
	
	public double distance(int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
		
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point pomocna = (Point)obj;
			if(this.x == pomocna.x && this.y == pomocna.y)
				return true;
			else 
				return false;
		} else
			return false;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "( "+x+" , "+y+" )";
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y = this.y + byY;
		
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Point) {
			return (int)(this.distance(0, 0) - ((Point)o).distance(0, 0));
		}
		return 0;
	}

	@Override
	public Point clone() {
		
		Point clonePoint = new Point();
		clonePoint.setX(this.getX());
		clonePoint.setY(this.getY());
		clonePoint.setColor(this.getColor());
		clonePoint.setSelected(this.isSelected());
		return clonePoint;
	}

	

}
