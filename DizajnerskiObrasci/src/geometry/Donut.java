package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Donut extends Circle{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1916752567515496206L;
	private int innerRadius;

	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut (Point center, int radius, int innerRadius, Color color, Color fillColor) {
		this(center, radius, innerRadius);
		setColor(color);
		setFillColor(fillColor);
	}
	
	public Donut (Point center, int radius, int innerRadius, Color color, Color fillColor, boolean selected) {
		this(center, radius, innerRadius);
		this.selected = selected;
		setColor(color);
		setFillColor(fillColor);
		
	}
	@Override
	public boolean contains(int x, int y) {
		return (super.contains(x, y) && center.distance(x, y) >= innerRadius);
	}

	@Override
	public boolean contains(Point p) {
		return this.contains(p.getX(),p.getY());
	}
	
	@Override
	public double area() {
		
		return super.area() - innerRadius*innerRadius*Math.PI;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Donut) {
			Donut pomocna = (Donut)obj;
			if(getCenter().equals(pomocna.getCenter()) 
					&& getRadius() == pomocna.getRadius() 
					&& innerRadius == pomocna.innerRadius){
				return true;
			} else return false;
					
		}
		return false;
	}

	@Override
	public String toString() {
		
		return super.toString() + "innerRadius: < " + innerRadius + " >";
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	@Override
	public void draw(Graphics g) {
		
		Graphics2D g1 = (Graphics2D) g;
		g.setColor(getFillColor());
		Area outer = new Area(new Ellipse2D.Double(center.getX() - radius, center.getY() - radius, 2*radius, 2*radius));
		Area inner = new Area(new Ellipse2D.Double(center.getX() - innerRadius, center.getY() - innerRadius, 2*innerRadius, 2*innerRadius));
		outer.subtract(inner);
		g1.fill(outer);
		g.setColor(getColor());
		g.drawOval(center.getX() - radius, center.getY() - radius, 2*radius, 2*radius);
		g.drawOval(center.getX() - innerRadius, center.getY() - innerRadius, 2*innerRadius, 2*innerRadius);
		
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, center.getY() + radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - innerRadius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + innerRadius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - innerRadius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + innerRadius - 2, 4, 4);
		}
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut)o).area());
		}
		return 0;
	}
	
	@Override
	public Donut clone() {
		
		Donut cloneDonut = new Donut();
		cloneDonut.setCenter(new Point());
		cloneDonut.getCenter().setX(this.getCenter().getX());
		cloneDonut.getCenter().setY(this.getCenter().getY());
		try {
			cloneDonut.setRadius(this.getRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
		cloneDonut.setColor(this.getColor());
		cloneDonut.setInnerRadius(this.getInnerRadius());
		cloneDonut.setFillColor(this.getFillColor());
		cloneDonut.setSelected(this.isSelected());

		return cloneDonut;
	}
	
	
	
	
}
