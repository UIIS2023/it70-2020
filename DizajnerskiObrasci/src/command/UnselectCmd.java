package command;

import java.io.Serializable;

import geometry.Shape;
import mvc.DrawingModel;

public class UnselectCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7375595372157979083L;
	private Shape s;
	
	
	public UnselectCmd (Shape s) {
		this.s = s;
	}
	@Override
	public void execute() {
			s.setSelected(false);
	}

	@Override
	public void unexecute() {
		s.setSelected(true);
	}
	@Override
	public String toString() {	
			return "Unselect [s=" +s + " " + "]";
	}
	@Override
	public void setModel(DrawingModel model) {
		// TODO Auto-generated method stub
		
	}

}
