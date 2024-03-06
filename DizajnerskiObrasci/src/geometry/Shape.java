package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Moveable, Comparable, Cloneable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -224770593192069888L;
	protected boolean selected;
	protected Color color;
	

	public Shape(){
		
	}
	
	public Shape(Color color) {
		this.color = color;
	}
	
	public Shape(Color color, boolean selected) {
		this(color);
		this.selected = selected;
	}
	
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);
	public abstract Shape clone();
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	
}
