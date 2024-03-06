package geometry;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;

public class HexagonAdapter extends Shape {

	/**
	 * 
	 */
	private static final long serialVersionUID = 781254803609529090L;
	private Hexagon hexa;
	
	public HexagonAdapter() {
		hexa = new Hexagon(0, 0, 0);
	}
	
	public HexagonAdapter(Hexagon hexa, Color color, Color fillColor) {
		this.hexa = hexa;
		this.hexa.setBorderColor(color);
		this.hexa.setAreaColor(fillColor);
	}
	
	public HexagonAdapter(Hexagon hexa, Color color ,Color fillColor, boolean selected) {
		this.hexa = hexa;
		this.hexa.setBorderColor(color);
		this.hexa.setAreaColor(fillColor);
		this.selected = selected;
	}

	public Hexagon getHexa() {
		return hexa;
	}

	public void setHexa(Hexagon hexa) {
		this.hexa = hexa;
	}
	
	@Override
	public void moveTo(int x, int y) {
		hexa.setX(x);
		hexa.setY(y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.hexa.setX(this.hexa.getX() + byX);
		this.hexa.setY(this.hexa.getY() + byY);
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof HexagonAdapter) {
			return (int) (this.area() - ((HexagonAdapter)o).area());
		}
		return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		return hexa.doesContain(x, y);
	}

	@Override
	public void draw(Graphics g) {
		
		hexa.paint(g);
		if(selected)
		{
			g.setColor(Color.BLUE);
			g.drawRect(hexa.getX() - 2, hexa.getY() - 2, 4, 4);
			g.drawRect(hexa.getX() - hexa.getR() - 2, hexa.getY() - 2, 4, 4);
			g.drawRect(hexa.getX() + hexa.getR() - 2, hexa.getY() - 2, 4, 4);
		}
	}
	
	public double area() {
		return (3 * (hexa.getR() * hexa.getR()) * Math.sqrt(3))/2;
	}

	@Override
	public HexagonAdapter clone() {
		
		HexagonAdapter cloneHexagon = new HexagonAdapter();
		cloneHexagon.getHexa().setX(this.hexa.getX());
		cloneHexagon.getHexa().setY(this.hexa.getY());
		cloneHexagon.getHexa().setR(this.hexa.getR());
		cloneHexagon.getHexa().setBorderColor(this.hexa.getBorderColor());
		cloneHexagon.getHexa().setAreaColor(this.hexa.getAreaColor());
		cloneHexagon.setSelected(this.isSelected());
		return cloneHexagon;
	}

	@Override
	public String toString() {
		
		return "Center: " + "( "+this.hexa.getX()+" , "+this.hexa.getY()+" )" + " , radius =< " + this.hexa.getR() + " >";
	}
	
	

}
