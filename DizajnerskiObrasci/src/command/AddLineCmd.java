package command;

import java.io.Serializable;

import geometry.Line;
import mvc.DrawingModel;

public class AddLineCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2436177910755065773L;
	private DrawingModel model;
	private Line line;
	
	
	public AddLineCmd(DrawingModel model, Line line) {
		this.model = model;
		this.line = line;
	}

	@Override
	public void execute() {
		model.add(line);
	}

	@Override
	public void unexecute() {
		model.remove(line);
	}

	@Override
	public String toString() {
		return "AddLineCmd [line=" + line + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}
}
