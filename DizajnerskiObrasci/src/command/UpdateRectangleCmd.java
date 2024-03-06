package command;

import java.io.Serializable;

import geometry.Rectangle;
import mvc.DrawingModel;

public class UpdateRectangleCmd implements Command, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7408181647811551450L;
	private Rectangle oldRectangle;
	private Rectangle newRectangle;
	private Rectangle original = new Rectangle();
	
	
	
	public UpdateRectangleCmd(Rectangle oldRectangle, Rectangle newRectangle) {
		this.oldRectangle = oldRectangle;
		this.newRectangle = newRectangle;
	}

	@Override
	public void execute() {
		
		original = oldRectangle.clone();
		
		oldRectangle.getUpperLeftPoint().setX(newRectangle.getUpperLeftPoint().getX());
		oldRectangle.getUpperLeftPoint().setY(newRectangle.getUpperLeftPoint().getY());
		oldRectangle.setHeight(newRectangle.getHeight());
		oldRectangle.setWidth(newRectangle.getWidth());
		oldRectangle.setColor(newRectangle.getColor());
		oldRectangle.setFillColor(newRectangle.getFillColor());
	}

	@Override
	public void unexecute() {
		
		oldRectangle.getUpperLeftPoint().setX(original.getUpperLeftPoint().getX());
		oldRectangle.getUpperLeftPoint().setY(original.getUpperLeftPoint().getY());
		oldRectangle.setHeight(original.getHeight());
		oldRectangle.setWidth(original.getWidth());
		oldRectangle.setColor(original.getColor());
		oldRectangle.setFillColor(original.getFillColor());
	}

	@Override
	public String toString() {
		return "UpdateRectangleCmd [oldRectangle=" + original + ", newRectangle=" + newRectangle + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		// TODO Auto-generated method stub
		
	}
}
