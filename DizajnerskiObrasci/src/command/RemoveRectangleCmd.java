package command;

import java.io.Serializable;

import geometry.Rectangle;
import mvc.DrawingModel;

public class RemoveRectangleCmd implements Command, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1071664458231863438L;
	private Rectangle rectangle;
	private DrawingModel model;
	private int index;
	
	public RemoveRectangleCmd(DrawingModel model, Rectangle rectangle, 	int index) {
		this.rectangle = rectangle;
		this.model = model;
		this.index = index;
	}

	@Override
	public void execute() {
		model.remove(rectangle);

	}

	@Override
	public void unexecute() {
		model.addShapeAtPosition(rectangle, index);

	}

	@Override
	public String toString() {
		return "RemoveRectangleCmd [rectangle=" + rectangle + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}

}
