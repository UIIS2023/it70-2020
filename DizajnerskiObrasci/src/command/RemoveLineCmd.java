package command;

import java.io.Serializable;

import geometry.Line;
import mvc.DrawingModel;

public class RemoveLineCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2424401101139140254L;
	private DrawingModel model;
	private Line line;
	private int index;
	
	
	public RemoveLineCmd(DrawingModel model, Line line,	int index) {
		this.model = model;
		this.line = line;
		this.index = index;
	}

	@Override
	public void execute() {
		model.remove(line);

	}

	@Override
	public void unexecute() {
		model.addShapeAtPosition(line, index);
	}

	@Override
	public String toString() {
		return "RemoveLineCmd [line=" + line + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}
	
	
}
