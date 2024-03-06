package command;

import java.io.Serializable;

import geometry.HexagonAdapter;
import mvc.DrawingModel;

public class RemoveHexagonCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9152727609515355024L;
	private DrawingModel model;
	private HexagonAdapter hexagon;
	int index;
	
	
	
	public RemoveHexagonCmd(DrawingModel model, HexagonAdapter hexagon, int index) {
		this.model = model;
		this.hexagon = hexagon;
		this.index = index;
	}

	@Override
	public void execute() {
		model.remove(hexagon);
	}

	@Override
	public void unexecute() {
		model.addShapeAtPosition(hexagon, index);
	}

	@Override
	public String toString() {
		return "RemoveHexagonCmd [hexagon=" + hexagon + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		this.model = model;
		
	}

}
