package command;

import java.io.Serializable;

import geometry.Donut;
import mvc.DrawingModel;

public class UpdateDonutCmd implements Command, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2903597822887863441L;
	private Donut oldDonut;
	private Donut newDonut;
	private Donut original;
	
	public UpdateDonutCmd(Donut oldDonut, Donut newDonut) {
		this.oldDonut = oldDonut;
		this.newDonut = newDonut;
	}

	@Override
	public void execute() {
		
		original = oldDonut.clone();
		
		oldDonut.getCenter().setX(newDonut.getCenter().getX());
		oldDonut.getCenter().setY(newDonut.getCenter().getY());
		try {
			oldDonut.setRadius(newDonut.getRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldDonut.setColor(newDonut.getColor());
		oldDonut.setInnerRadius(newDonut.getInnerRadius());
		oldDonut.setFillColor(newDonut.getFillColor());
	}

	@Override
	public void unexecute() {
		oldDonut.getCenter().setX(original.getCenter().getX());
		oldDonut.getCenter().setY(original.getCenter().getY());
		try {
			oldDonut.setRadius(original.getRadius());
		} catch (Exception e) {
			e.printStackTrace();
		}
		oldDonut.setColor(original.getColor());
		oldDonut.setInnerRadius(original.getInnerRadius());
		oldDonut.setFillColor(original.getFillColor());
		
	}

	@Override
	public String toString() {
		return "UpdateDonutCmd [oldDonut=" + original + ", newDonut=" + newDonut + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		// TODO Auto-generated method stub
		
	}

	
}
