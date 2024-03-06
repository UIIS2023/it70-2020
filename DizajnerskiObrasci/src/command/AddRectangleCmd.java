package command;

import java.io.Serializable;

import geometry.Rectangle;
import mvc.DrawingModel;

public class AddRectangleCmd implements Command, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2786720747141324279L;
	private Rectangle rectangle;
	private DrawingModel model;
	
	public AddRectangleCmd(DrawingModel model, Rectangle rectangle) {
		this.rectangle = rectangle;
		this.model = model;
	}

	@Override
	public void execute() {
		model.add(rectangle);

	}

	@Override
	public void unexecute() {
		model.remove(rectangle);
	}

	@Override
	public String toString() {
		return "AddRectangleCmd [rectangle=" + rectangle + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}

}
