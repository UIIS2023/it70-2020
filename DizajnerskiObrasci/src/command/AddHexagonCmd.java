package command;

import java.io.Serializable;

import geometry.HexagonAdapter;
import mvc.DrawingModel;

public class AddHexagonCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7202468568095740971L;
	private DrawingModel model;
	private HexagonAdapter hexagon;
	
	public AddHexagonCmd(DrawingModel model, HexagonAdapter hexagon) {
		this.model = model;
		this.hexagon = hexagon;
	}

	@Override
	public void execute() {

		model.add(hexagon);
	}

	@Override
	public void unexecute() {
		model.remove(hexagon);
	}

	@Override
	public String toString() {
		return "AddHexagonCmd [hexagon=" + hexagon + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}
}
