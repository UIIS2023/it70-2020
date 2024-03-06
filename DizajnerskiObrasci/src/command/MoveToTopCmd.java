package command;

import java.io.Serializable;

import geometry.Shape;
import mvc.DrawingModel;

public class MoveToTopCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8099427992805020593L;
	DrawingModel model;
	Shape s;
	int index;
	
	
	public MoveToTopCmd(DrawingModel model, Shape s, int index) {
		this.model = model;
		this.s = s;
		this.index = index;
	}
	@Override
	public void execute() {
		model.remove(s);
		model.add(s);
	}

	@Override
	public void unexecute() {
		model.remove(s);
		model.addShapeAtPosition(s, index);
	}
	@Override
	public String toString() {
		return "MoveToTopCmd [ "+ s.getClass().getCanonicalName().substring(9) + " = " + s + "]";
	}
	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}	
	
	

}
