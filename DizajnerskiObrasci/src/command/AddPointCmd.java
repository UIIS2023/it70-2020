package command;

import java.io.Serializable;

import geometry.Point;
import mvc.DrawingModel;

public class AddPointCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7157461642675317844L;
	private DrawingModel model;
	private Point point;
	
	public AddPointCmd(DrawingModel model, Point point) {
		this.model = model;
		this.point = point;
	}
	
	@Override
	public void execute() {
		model.add(point);

	}

	@Override
	public void unexecute() {
		model.remove(point);

	}

	@Override
	public String toString() {
		return "AddPointCmd [point=" + point + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
	}
	


}
