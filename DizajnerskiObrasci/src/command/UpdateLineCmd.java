package command;

import java.io.Serializable;

import geometry.Line;
import mvc.DrawingModel;

public class UpdateLineCmd implements Command, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7977546302433262804L;
	private Line oldLine;
	private Line newLine;
	private Line original = new Line();
	
	public UpdateLineCmd(Line oldLine, Line newLine) {
		this.oldLine = oldLine;
		this.newLine = newLine;
	}

	@Override
	public void execute() {
		
		original = oldLine.clone();
		
		oldLine.getStartPoint().setX(newLine.getStartPoint().getX());
		oldLine.getStartPoint().setY(newLine.getStartPoint().getY());
		oldLine.getEndPoint().setX(newLine.getEndPoint().getX());
		oldLine.getEndPoint().setY(newLine.getEndPoint().getY());
		oldLine.setColor(newLine.getColor());
	}

	@Override
	public void unexecute() {
		oldLine.getStartPoint().setX(original.getStartPoint().getX());
		oldLine.getStartPoint().setY(original.getStartPoint().getY());
		oldLine.getEndPoint().setX(original.getEndPoint().getX());
		oldLine.getEndPoint().setY(original.getEndPoint().getY());
		oldLine.setColor(original.getColor());
	}

	@Override
	public String toString() {
		return "UpdateLineCmd [oldLine=" + original + ", newLine=" + newLine + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		// TODO Auto-generated method stub
		
	}
}
