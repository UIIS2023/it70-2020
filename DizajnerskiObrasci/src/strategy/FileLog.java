package strategy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.DefaultListModel;

import command.Command;
import mvc.DrawingModel;

public class FileLog implements FileManipulation {

	private DrawingModel model;
	private DefaultListModel<Command> logCommands;
	private DefaultListModel<String> logCommandsText;
	
	public FileLog(DrawingModel model, DefaultListModel<Command> logCommands, DefaultListModel<String> logCommandsText) {
		this.model = model;
		this.logCommands = logCommands;
		this.logCommandsText = logCommandsText;
	}

	@Override
	public void saveFile(String fileName) {
		
		try {
			FileOutputStream fileBin = new FileOutputStream(fileName + "Log.txt");
			ObjectOutputStream outBin = new ObjectOutputStream(fileBin);
		
			outBin.writeObject(logCommands);
			outBin.close();
			fileBin.close();
		} catch (IOException ex) {
			System.out.println("IOException is caught");
			System.out.println(ex);
		}
	}

	@Override
	public void loadFile(String fileName) {
		
		try {
			FileInputStream fileBin = new FileInputStream(fileName);
			ObjectInputStream inBin = new ObjectInputStream(fileBin);
			
			DefaultListModel<Command> cmd = new DefaultListModel<>();
			cmd = (DefaultListModel<Command>)inBin.readObject();
			for(int i = 0; i<cmd.size(); i++) {
				cmd.get(i).setModel(model);
				logCommandsText.addElement(cmd.get(i).toString());
				logCommands.addElement(cmd.get(i));
			}
			inBin.close();
			fileBin.close();
			
			System.out.println("Object has been deserialized\n"
                    + "Data after Deserialization.");
		} catch (IOException ex) {
			System.out.println("IOException is caught");
			System.out.println(ex);
		} catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                    " is caught");
            }
	}
}
