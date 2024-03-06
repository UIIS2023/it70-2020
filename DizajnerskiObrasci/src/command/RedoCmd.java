package command;

import java.io.Serializable;
import mvc.DrawingModel;

public class RedoCmd implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -827615661908448761L;
	private Command cmd;
	
	public RedoCmd(Command cmd){
		this.cmd = cmd;
	}
	@Override
	public void execute() {
		cmd.execute();
	}

	@Override
	public void unexecute() {
		cmd.unexecute();
	}
	@Override
	public String toString() {
		return "Redo [Command=" + cmd + "]";
	}
	@Override
	public void setModel(DrawingModel model) {
	}
	
	

}
