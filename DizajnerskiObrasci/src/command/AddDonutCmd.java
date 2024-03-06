package command;

import java.io.Serializable;

import geometry.Donut;
import mvc.DrawingModel;

public class AddDonutCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7201451085642817937L;
	private DrawingModel model;
	private Donut donut;
	
	public AddDonutCmd(DrawingModel model, Donut donut) {
		this.model = model;
		this.donut = donut;
	}

	@Override
	public void execute() {

		model.add(donut);
	}

	@Override
	public void unexecute() {
		model.remove(donut);
	}

	@Override
	public String toString() {
		return "AddDonutCmd [donut=" + donut + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}

}
