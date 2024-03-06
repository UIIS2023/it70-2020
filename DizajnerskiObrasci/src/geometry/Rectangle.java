package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6648437576588842604L;
	private Point upperLeftPoint;
	private int height;
	private int width;
	private Color fillColor;
	
	public Rectangle() {
		
	}
	public Rectangle(Point upperLeftPoint, int width, int height) {
		
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}
	public Rectangle(Point upperLeftPoint, int width, int height,Color color,Color fillColor) {
		
		this(upperLeftPoint, width, height);
		setColor(color);
		setFillColor(fillColor);
	}
	public Rectangle(Point upperLeftPoint, int width, int height,Color color,Color fillColor, boolean selected) {
	
		this(upperLeftPoint, width, height);
		setColor(color);
		setFillColor(fillColor);
		this.selected = selected;
	}
	
	public boolean contains(int x, int y) {
		return (upperLeftPoint.getX() <= x && upperLeftPoint.getX()+width >= x) 
				&& (upperLeftPoint.getY()<=y && upperLeftPoint.getY()+height >= y);
	}
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	@Override
	public void draw(Graphics g) {
		
		g.setColor(fillColor);
		g.fillRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		g.setColor(getColor());
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(getUpperLeftPoint().getX() -2, getUpperLeftPoint().getY() - 2, 4, 4);
			g.drawRect(getUpperLeftPoint().getX() + width -2, getUpperLeftPoint().getY() - 2, 4, 4);
			g.drawRect(getUpperLeftPoint().getX() -2, getUpperLeftPoint().getY() + height - 2, 4, 4);
			g.drawRect(getUpperLeftPoint().getX() + width -2, getUpperLeftPoint().getY() + height - 2, 4, 4);
		}
	}
	
	public int area() {
		return height * width;
	}
	public int circumference() {
		return 2*width + 2*height;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle)obj;
			if (this.upperLeftPoint.equals(pomocna.upperLeftPoint) && this.width == pomocna.width && this.height == pomocna.height) {
				return true;
			} else 
				return false;
		} else 
			return false;
	}
	
	//Metode pristupa:
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint (Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	public int getHeight () {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public Color getFillColor() {
		return fillColor;
	}
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	public String toString() {
		return "Upper left point: " + this.upperLeftPoint + ", width = " + this.width + " , height = " + this.height ;
	}
	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);
		
	}
	@Override
	public void moveBy(int byX, int byY) {
		upperLeftPoint.moveBy(byX, byY);
		
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return this.area() - ((Rectangle)o).area();
		}
		return 0;
	}
	
	@Override
	public Rectangle clone() {
		
		Rectangle cloneRect = new Rectangle();
		cloneRect.setUpperLeftPoint(new Point());
		cloneRect.getUpperLeftPoint().setX(this.getUpperLeftPoint().getX());
		cloneRect.getUpperLeftPoint().setY(this.getUpperLeftPoint().getY());
		cloneRect.setHeight(this.getHeight());
		cloneRect.setWidth(this.getWidth());
		cloneRect.setColor(this.getColor());
		cloneRect.setFillColor(this.getFillColor());
		cloneRect.setSelected(this.isSelected());
		
		return cloneRect;
	}
	

}
