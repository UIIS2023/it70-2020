package command;

import java.io.Serializable;

import geometry.Circle;
import mvc.DrawingModel;

public class RemoveCircleCmd implements Command, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8234818757696992081L;
	private DrawingModel model;
	private Circle circle;
	private int index;
	
	public RemoveCircleCmd(DrawingModel model, Circle circle, int index) {
		this.model = model;
		this.circle = circle;
		this.index = index;
	}

	@Override
	public void execute() {

		model.remove(circle);
	}

	@Override
	public void unexecute() {
		model.addShapeAtPosition(circle, index);
	}

	@Override
	public String toString() {
		return "RemoveCircleCmd [circle=" + circle + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}


}
