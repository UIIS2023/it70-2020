package command;

import java.io.Serializable;

import geometry.Shape;
import mvc.DrawingModel;

public class MoveToBottomCmd implements Command , Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 443193019413510632L;
	private DrawingModel model;
	private Shape s;
	private int index;

	public MoveToBottomCmd(DrawingModel model, Shape s, int index) {
		this.model = model;
		this.s = s;
		this.index = index;
	}

	@Override
	public void execute() {
		model.remove(s);
		model.addShapeAtLastPosition(s);
	}

	@Override
	public void unexecute() {
		model.remove(s);
		model.addShapeAtPosition(s, index);
	}

	@Override
	public String toString() {
		return "MoveToBottomCmd ["+ s.getClass().getCanonicalName().substring(9) +" = " + s + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}

}
