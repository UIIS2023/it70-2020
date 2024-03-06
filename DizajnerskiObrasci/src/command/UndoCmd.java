package command;

import java.io.Serializable;

import mvc.DrawingModel;

public class UndoCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7813018989557881280L;
	private Command cmd;
	
	
	public UndoCmd(Command cmd) {
		this.cmd = cmd;
	}

	@Override
	public void execute() {
		cmd.unexecute();
	}

	@Override
	public void unexecute() {
		cmd.execute();
	}

	@Override
	public String toString() {
		return "Undo [Command=" + cmd + "]";
	}

	@Override
	public void setModel(DrawingModel model) {
		
	}
	
	

}
