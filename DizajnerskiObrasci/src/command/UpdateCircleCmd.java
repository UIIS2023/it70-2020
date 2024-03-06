package command;

import java.io.Serializable;

import geometry.Circle;
import mvc.DrawingModel;

public class UpdateCircleCmd implements Command, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8108704951684622302L;
	private Circle oldCircle;
	private Circle newCircle;
	private Circle original;
	
	public UpdateCircleCmd(Circle oldCircle, Circle newCircle) {
		this.oldCircle = oldCircle;
		this.newCircle = newCircle;
	}

	@Override
	public void execute() {
		
		original = oldCircle.clone();
		oldCircle.getCenter().setX(newCircle.getCenter().getX());
		oldCircle.getCenter().setY(newCircle.getCenter().getY());
		oldCircle.setColor(newCircle.getColor());
		oldCircle.setFillColor(newCircle.getFillColor());
		try {
			oldCircle.setRadius(newCircle.getRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unexecute() {
		
		oldCircle.getCenter().setX(original.getCenter().getX());
		oldCircle.getCenter().setY(original.getCenter().getY());
		oldCircle.setColor(original.getColor());
		oldCircle.setFillColor(original.getFillColor());
		try {
			oldCircle.setRadius(original.getRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "UpdateCircleCmd [oldCircle=" + original + ", newCircle=" + newCircle + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		// TODO Auto-generated method stub
		
	}
	
	

}
