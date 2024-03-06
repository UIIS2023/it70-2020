package command;

import java.io.Serializable;

import geometry.Shape;
import mvc.DrawingModel;

public class MoveUpCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3906393351936743939L;
	private DrawingModel model;
	private Shape s;
	private int index;
	
	public MoveUpCmd(DrawingModel model, Shape s, int index) {
		this.model = model;
		this.s = s;
		this.index = index;
	}

	@Override
	public void execute() {
		if(index > 0) {
			model.remove(s);
			model.addShapeAtPosition(s, index-1);
		}
	}

	@Override
	public void unexecute() {
		model.remove(s);
		model.addShapeAtPosition(s, index);
	}

	@Override
	public String toString() {
		return "MoveUpCmd [" + s.getClass().getCanonicalName().substring(9) + " = " + s + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}
	
	

}
