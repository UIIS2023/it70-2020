package command;

import java.io.Serializable;

import geometry.Circle;
import mvc.DrawingModel;

public class AddCircleCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7296737063696676270L;
	private DrawingModel model;
	private Circle circle;
	
	public AddCircleCmd(DrawingModel model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}

	@Override
	public void execute() {

		model.add(circle);
	}

	@Override
	public void unexecute() {
		model.remove(circle);
	}

	@Override
	public String toString() {
		return "AddCircleCmd [circle=" + circle + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}
}
