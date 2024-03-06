package mvc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import geometry.Shape;

public class DrawingModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5768424746753225800L;
	private List<Shape> shapes = new ArrayList<>();
	private int numberOfSelectedShapes = 0;
	private PropertyChangeSupport pcs;
	
	public DrawingModel() {
		pcs = new PropertyChangeSupport(this);
	}

	public List<Shape> getShapes() {
		return shapes;
	}
	
	public void add(Shape p) {
		shapes.add(0, p);
	}
	
	public void remove(Shape p) {
		shapes.remove(p);
	}
	
	public void removeAll() {
		shapes.clear();
	}
	public void addShapeAtPosition(Shape p, int index) {
		shapes.add(index, p);
	}
	
	public void addShapeAtLastPosition(Shape p) {
		shapes.add(p);
	}
	
	
	public void setNumberOfSelectedShapes(int numberOfSelectedShapes) {
		pcs.firePropertyChange("selectedShapes", this.numberOfSelectedShapes, numberOfSelectedShapes);
		this.numberOfSelectedShapes = numberOfSelectedShapes;
	}

	//PropertyChange
	public void addPropertyListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyListener(PropertyChangeListener pcl) {
		pcs.removePropertyChangeListener(pcl);
	}
}
