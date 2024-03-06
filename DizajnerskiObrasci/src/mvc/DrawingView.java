package mvc;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;


import geometry.Shape;

import java.awt.Color;

import java.awt.Graphics;


public class DrawingView extends JPanel {
	
	/**
	 * 
	 */
	private DrawingModel model = new DrawingModel();

	/**
	 * Create the panel.
	 */
	public DrawingView() {
		
		setBorder(new LineBorder(new Color(0, 0, 0), 0));
		setBackground(Color.WHITE);		
	}
	
	//Novo
	
		public void setModel(DrawingModel model) {
			this.model = model;
		}
		
		@Override
		public void paint(Graphics g) {
			
			super.paint(g);
			Object [] draw1 = model.getShapes().toArray();
			for(int i = draw1.length - 1; i>=0; i--) {
				Shape p = (Shape) draw1[i];
				p.draw(g);
				}
		}

}
