package command;

import java.io.Serializable;

import geometry.Donut;
import mvc.DrawingModel;

public class RemoveDonutCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8288355001824885226L;
	private DrawingModel model;
	private Donut donut;
	private int index;
	
	
	
	public RemoveDonutCmd(DrawingModel model, Donut donut, 	int index) {
		this.model = model;
		this.donut = donut;
		this.index = index;
	}

	@Override
	public void execute() {

		model.remove(donut);
	}

	@Override
	public void unexecute() {
		model.addShapeAtPosition(donut, index);
	}

	@Override
	public String toString() {
		return "RemoveDonutCmd [donut=" + donut + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}

}
