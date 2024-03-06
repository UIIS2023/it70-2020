package command;

import java.io.Serializable;

import geometry.HexagonAdapter;
import mvc.DrawingModel;

public class UpdateHexagonCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1181921236903582001L;
	private HexagonAdapter oldHexagon;
	private HexagonAdapter newHexagon;
	private HexagonAdapter original;
	
	public UpdateHexagonCmd(HexagonAdapter oldHexagon, HexagonAdapter newHexagon) {
		this.oldHexagon = oldHexagon;
		this.newHexagon = newHexagon;
	}

	@Override
	public void execute() {
		
		original = oldHexagon.clone();
		
		oldHexagon.getHexa().setX(newHexagon.getHexa().getX());
		oldHexagon.getHexa().setY(newHexagon.getHexa().getY());
		oldHexagon.getHexa().setR(newHexagon.getHexa().getR());
		oldHexagon.getHexa().setBorderColor(newHexagon.getHexa().getBorderColor());
		oldHexagon.getHexa().setAreaColor(newHexagon.getHexa().getAreaColor());
		
	}

	@Override
	public void unexecute() {
		
		oldHexagon.getHexa().setX(original.getHexa().getX());
		oldHexagon.getHexa().setY(original.getHexa().getY());
		oldHexagon.getHexa().setR(original.getHexa().getR());
		oldHexagon.getHexa().setBorderColor(original.getHexa().getBorderColor());
		oldHexagon.getHexa().setAreaColor(original.getHexa().getAreaColor());
	}

	@Override
	public String toString() {
		return "UpdateHexagonCmd [oldHexagon=" + original + ", newHexagon=" + newHexagon + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		// TODO Auto-generated method stub
		
	}

	
}
