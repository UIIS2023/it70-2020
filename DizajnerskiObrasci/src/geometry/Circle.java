package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5899244045084385005L;
	protected Point center;
	protected int radius;
	protected Color fillColor;
	
	public Circle() {
		
	}
	public Circle(Point center, int radius) {
			this.center = center;
			this.radius = radius;
		}
	
	public Circle(Point center, int radius, Color color, Color fillColor) {
		
		this(center, radius);
		setColor(color);
		setFillColor(fillColor);
	}

	public Circle(Point center, int radius, Color color, Color fillColor, boolean selected) {
		
		this(center, radius);
		setColor(color);
		this.fillColor = fillColor;
		this.selected = selected;
		
	}
	
	public boolean contains(int x, int y) {
		return center.distance(x, y) <= radius;
	}
	
	//overloading
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(fillColor);
		g.fillOval(center.getX() - radius, center.getY() - radius, radius + radius + 1, radius + radius + 1);
		g.setColor(getColor());
		g.drawOval(center.getX() - radius, center.getY() - radius, radius + radius + 1, radius + radius + 1);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, center.getY() + radius - 2, 4, 4);
			
		}	
	}
	
	public double area() {
		return radius * radius * Math.PI;
	}
	public double circumference() {
		return 2 * radius * Math.PI;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle pomocna = (Circle)obj;
			if(this.center.equals(pomocna.center) && this.radius == pomocna.radius) {
				return true;
			} else 
				return false;
		} else 
			return false;
	}
	
	public Point getCenter() {
		return this.center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return this.radius;
	}
	public void setRadius(int radius) throws Exception {
		if(radius < 0) {
			throw new Exception("Radius ne moze biti manji od 0");
		}
		this.radius = radius;
	}
	
	public Color getFillColor() {
		return fillColor;
	}
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	public String toString() {
		return "Center: " + this.center + " , radius =< " + radius + " >";
	}
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
		
	}
	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
		
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			return (int) (this.area() - ((Circle)o).area());
		}
		return 0;
	}
	@Override
	public Circle clone() {
		Circle cloneCircle = new Circle();
		cloneCircle.setCenter(new Point());
		cloneCircle.getCenter().setX(this.getCenter().getX());
		cloneCircle.getCenter().setY(this.getCenter().getY());
		cloneCircle.setColor(this.getColor());
		cloneCircle.setFillColor(this.getFillColor());
		try {
			cloneCircle.setRadius(this.getRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
		cloneCircle.setSelected(this.isSelected());
		return cloneCircle;
	}
	

}
