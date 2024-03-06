package command;

import java.io.Serializable;

import geometry.Point;
import mvc.DrawingModel;

public class RemovePointCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4910457250548568171L;
	private DrawingModel model;
	private Point point;
	private int index;
	
	public RemovePointCmd(DrawingModel model, Point point, int index) {
		this.model = model;
		this.point = point;
		this.index = index;
	}
	
	@Override
	public void execute() {
		model.remove(point);

	}

	@Override
	public void unexecute() {
		model.addShapeAtPosition(point, index);

	}

	@Override
	public String toString() {
		return "RemovePointCmd [point=" + point + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}

}
