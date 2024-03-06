package command;

import java.io.Serializable;

import geometry.Shape;
import mvc.DrawingModel;

public class SelectCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4705616763128445850L;
	private Shape s;
	
	
	public SelectCmd (Shape s) {
		this.s = s;
	}
	@Override
	public void execute() {
		s.setSelected(true);
	}

	@Override
	public void unexecute() {
		s.setSelected(false);
	}
	@Override
	public String toString() {	
			return "Select [s=" + s + " " + "]";
	}
	@Override
	public void setModel(DrawingModel model) {
		// TODO Auto-generated method stub
		
	}
}
