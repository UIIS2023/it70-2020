package strategy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import geometry.Shape;
import mvc.DrawingModel;

public class FileDrawing implements FileManipulation {

	private DrawingModel model;
	
	
	public FileDrawing(DrawingModel model) {
		this.model = model;
	}

	@Override
	public void saveFile(String fileName) {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(model.getShapes());
			out.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("IOException is caught");
			System.out.println(ex);
		}
	}

	public void loadFile(String fileName) {
		
		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);
			ArrayList <Shape> shapes = (ArrayList<Shape>)in.readObject();
			for(int i = shapes.size()-1; i>=0; i--) {
				shapes.get(i).setSelected(false);
				model.add(shapes.get(i));;
			}
			in.close();
			file.close();
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
