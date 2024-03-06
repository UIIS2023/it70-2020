package command;

import java.io.Serializable;

import geometry.Point;
import mvc.DrawingModel;

public class UpdatePointCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5341530712834447186L;
	private Point oldPoint;
	private Point newPoint;
	private Point original = new Point();
	
	public UpdatePointCmd(Point oldPoint, Point newPoint) {
		this.oldPoint = oldPoint;
		this.newPoint = newPoint;
	}

	@Override
	public void execute() {
		original = oldPoint.clone();
		
		oldPoint.setX(newPoint.getX());
		oldPoint.setY(newPoint.getY());
		oldPoint.setColor(newPoint.getColor());
	}

	@Override
	public void unexecute() {
		
		oldPoint.setX(original.getX());
		oldPoint.setY(original.getY());
		oldPoint.setColor(original.getColor());

	}

	@Override
	public String toString() {
		return "UpdatePointCmd [oldPoint=" + original + ", newPoint=" + newPoint + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		// TODO Auto-generated method stub
		
	}

	
}
