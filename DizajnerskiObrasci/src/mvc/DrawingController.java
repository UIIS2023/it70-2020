package mvc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import command.AddCircleCmd;
import command.AddDonutCmd;
import command.AddHexagonCmd;
import command.AddLineCmd;
import command.AddPointCmd;
import command.AddRectangleCmd;
import command.Command;
import command.MoveDownCmd;
import command.MoveToBottomCmd;
import command.MoveToTopCmd;
import command.MoveUpCmd;
import command.RedoCmd;
import command.RemoveCircleCmd;
import command.RemoveDonutCmd;
import command.RemoveHexagonCmd;
import command.RemoveLineCmd;
import command.RemovePointCmd;
import command.RemoveRectangleCmd;
import command.SelectCmd;
import command.UndoCmd;
import command.UnselectCmd;
import command.UpdateCircleCmd;
import command.UpdateDonutCmd;
import command.UpdateHexagonCmd;
import command.UpdateLineCmd;
import command.UpdatePointCmd;
import command.UpdateRectangleCmd;
import drawing.DlgCircle;
import drawing.DlgDonut;
import drawing.DlgHexagon;
import drawing.DlgLine;
import drawing.DlgPoint;
import drawing.DlgRectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.HexagonAdapter;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import hexagon.Hexagon;
import strategy.FileDrawing;
import strategy.FileLog;
import strategy.FileManipulation;
import strategy.FileManipulationManager;

public class DrawingController implements PropertyChangeListener {

	DrawingFrame frame;
	DrawingModel model;
	
	private Point pt1;
	private Point pt2;
	private boolean isFirstClick = true;
	private Color borderColor;
	private Color fillColor;
	private Stack<Command> undoCommands = new Stack<>();
	private Stack<Command> redoCommands = new Stack<>();
	private DefaultListModel<Command> logCommands = new DefaultListModel<>();
	private DefaultListModel<String> logCommandsString = new DefaultListModel<>();
	private int logIndex = 0;
	
	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
		frame.getLstLogs().setModel(logCommandsString);
	}
	
	public void mouseClicked(MouseEvent e) {
		if(frame.tglbtnPoint.isSelected()) {
			DlgPoint dlg = new DlgPoint();
			pt1 = new Point (e.getX(), e.getY());
			String [] split = pt1.toString().split(" ");
			dlg.getTxtX().setText(split [1]);
			dlg.getTxtY().setText(split [3]);
			dlg.getTxtX().setEditable(false);
			dlg.getTxtY().setEditable(false);
			dlg.getBtnColor().setVisible(false);
			dlg.setVisible(true);
			
			if(dlg.isOk())
			{
				Command cmd = new AddPointCmd(model, new Point(Integer.parseInt(dlg.getTxtX().getText()),
						Integer.parseInt(dlg.getTxtY().getText()), frame.btnBorderColor.getBackground()));
				cmd.execute();
				undoCommands.push(cmd);
		        redoCommands.clear();
		        logCommands.addElement(cmd);
		        logCommandsString.addElement(cmd.toString());
			}
		} else if(frame.tglbtnLine.isSelected()) {
			if(isFirstClick)
	        {
				pt1 = new Point (e.getX(), e.getY());
	            isFirstClick = false;
	        }
	        else
	        {
	        	pt2 = new Point (e.getX(), e.getY());
	        	DlgLine dlg = new DlgLine();
				String [] split1 = pt1.toString().split(" ");
				String [] split2 = pt2.toString().split(" ");
				dlg.getTxtX1().setText(split1 [1]);
				dlg.getTxtY1().setText(split1 [3]);
				dlg.getTxtX2().setText(split2 [1]);
				dlg.getTxtY2().setText(split2 [3]);
				dlg.getTxtX1().setEditable(false);
				dlg.getTxtY1().setEditable(false);
				dlg.getTxtX2().setEditable(false);
				dlg.getTxtY2().setEditable(false);
				dlg.getBtnColor().setVisible(false);
				dlg.setVisible(true);
				if(dlg.isOk())
				{
					Command cmd = new AddLineCmd(model, new Line(new Point(Integer.parseInt(dlg.getTxtX1().getText()),Integer.parseInt(dlg.getTxtY1().getText())), 
							new Point(Integer.parseInt(dlg.getTxtX2().getText()),Integer.parseInt(dlg.getTxtY2().getText())), frame.btnBorderColor.getBackground()));
					cmd.execute();
					
					undoCommands.push(cmd);
			        redoCommands.clear();
			        logCommands.addElement(cmd);
			        logCommandsString.addElement(cmd.toString());
				}
	            isFirstClick = true;
	        }
		}else if(frame.tglbtnRectangle.isSelected()) {
			DlgRectangle dlg = new DlgRectangle();
			pt1 = new Point (e.getX(), e.getY());
			String [] split = pt1.toString().split(" ");
			dlg.getTxtUpperLeftPointX().setText(split [1]);
			dlg.getTxtUpperLeftPointY().setText(split [3]);
			dlg.getTxtUpperLeftPointX().setEditable(false);
			dlg.getTxtUpperLeftPointY().setEditable(false);
			dlg.getBtnOutColor().setVisible(false);
			dlg.getBtnFillColor().setVisible(false);
			dlg.setVisible(true);
			if(dlg.isOk()) {
				Command cmd = new AddRectangleCmd(model, new Rectangle (new Point(Integer.parseInt(dlg.getTxtUpperLeftPointX().getText()),
						Integer.parseInt(dlg.getTxtUpperLeftPointY().getText())), 
						Integer.parseInt(dlg.getTxtWidth().getText()),
						Integer.parseInt(dlg.getTxtHeight().getText()), frame.btnBorderColor.getBackground(), frame.btnFillColor.getBackground()));
				cmd.execute();
				undoCommands.push(cmd);
		        redoCommands.clear();
		        logCommands.addElement(cmd);
		        logCommandsString.addElement(cmd.toString());
			}
		} else if(frame.tglbtnCircle.isSelected()) {
			DlgCircle dlg = new DlgCircle();
			pt1 = new Point (e.getX(), e.getY());
			String [] split = pt1.toString().split(" ");
			dlg.getTxtCenterX().setText(split [1]);
			dlg.getTxtCenterY().setText(split [3]);
			dlg.getTxtCenterX().setEditable(false);
			dlg.getTxtCenterY().setEditable(false);
			dlg.getBtnOutColor().setVisible(false);
			dlg.getBtnFillColor().setVisible(false);
			dlg.setVisible(true);
			if(dlg.isOk()) {
				Command cmd = new AddCircleCmd(model, new Circle (new Point(Integer.parseInt(dlg.getTxtCenterX().getText()),Integer.parseInt(dlg.getTxtCenterY().getText())),
						Integer.parseInt(dlg.getTxtRadius().getText()), frame.btnBorderColor.getBackground(), frame.btnFillColor.getBackground()));
				cmd.execute();
				undoCommands.push(cmd);
		        redoCommands.clear();
		        logCommands.addElement(cmd);
		        logCommandsString.addElement(cmd.toString());
			}
		}
		else if(frame.tglbtnDonut.isSelected()) {
			DlgDonut dlg = new DlgDonut();
			pt1 = new Point (e.getX(), e.getY());
			String [] split = pt1.toString().split(" ");
			dlg.getTxtCenterX().setText(split [1]);
			dlg.getTxtCenterY().setText(split [3]);
			dlg.getTxtCenterX().setEditable(false);
			dlg.getTxtCenterY().setEditable(false);
			dlg.getBtnOutColor().setVisible(false);
			dlg.getBtnFillColor().setVisible(false);
			dlg.setVisible(true);
			if(dlg.isOk()) {
				
				Command cmd = new AddDonutCmd(model, new Donut(new Point(Integer.parseInt(dlg.getTxtCenterX().getText()),Integer.parseInt(dlg.getTxtCenterY().getText())),
						Integer.parseInt(dlg.getTxtOuterRadius().getText()), 
						Integer.parseInt(dlg.getTxtInnerRadius().getText()), frame.btnBorderColor.getBackground(), frame.btnFillColor.getBackground()));
				cmd.execute();
				undoCommands.push(cmd);
		        redoCommands.clear();
		        logCommands.addElement(cmd);
		        logCommandsString.addElement(cmd.toString());
			}
		} 
		else if(frame.tglbtnHexagon.isSelected()) {
			DlgHexagon dlg = new DlgHexagon();
			pt1 = new Point (e.getX(), e.getY());
			String [] split = pt1.toString().split(" ");
			dlg.getTxtCenterX().setText(split [1]);
			dlg.getTxtCenterY().setText(split [3]);
			dlg.getTxtCenterX().setEditable(false);
			dlg.getTxtCenterY().setEditable(false);
			dlg.getBtnOutColor().setVisible(false);
			dlg.getBtnFillColor().setVisible(false);
			dlg.setVisible(true);
			if(dlg.isOk()) {
				
				Command cmd = new AddHexagonCmd(model, new HexagonAdapter(new Hexagon(Integer.parseInt(dlg.getTxtCenterX().getText()),
						Integer.parseInt(dlg.getTxtCenterY().getText()), 
						Integer.parseInt(dlg.getTxtRadius().getText())), frame.btnBorderColor.getBackground(), frame.btnFillColor.getBackground()));
				cmd.execute();
				undoCommands.push(cmd);
		        redoCommands.clear();
		        logCommands.addElement(cmd);
		        logCommandsString.addElement(cmd.toString());
			}
		}
			else {
			Iterator <Shape> it = model.getShapes().iterator();
            while(it.hasNext()) {
    			Shape s = it.next();
    			if (s.contains(e.getX(), e.getY())) {
    				Command cmd;
    				if(s.isSelected()) {
    					cmd = new UnselectCmd(s);
    				} else {
        				cmd = new SelectCmd(s);
    				}
    				cmd.execute();
    				undoCommands.add(cmd);
    				redoCommands.clear();
    				logCommands.addElement(cmd);
    				logCommandsString.addElement(cmd.toString());
    				break;
    			}
    		}
		}
		countSelectedShapes();
		visibleUndoButton(undoCommands.size());
		visibleRedoButton(redoCommands.size());
		frame.getView().repaint();
	}
	
	public void modifyEvent(ActionEvent e) {
		boolean isModified = false;
		Iterator <Shape> it = model.getShapes().iterator();
        while(it.hasNext()) {
			Shape s = it.next();
			if (s.isSelected()) {
				if(s instanceof Point) {
					DlgPoint dlg = new DlgPoint();
					String [] split = s.toString().split(" ");
					dlg.getTxtX().setText(split [1]);
					dlg.getTxtY().setText(split [3]);
					dlg.setColor(s.getColor());
					dlg.getBtnColor().setBackground(s.getColor());
					
					dlg.setVisible(true);
					if(dlg.isOk()) {
						Command cmd = new UpdatePointCmd((Point)s, new Point(Integer.parseInt(dlg.getTxtX().getText()),
								Integer.parseInt(dlg.getTxtY().getText()), dlg.getColor()));
						undoCommands.push(cmd);
						cmd.execute();
				        redoCommands.clear();
						logCommands.addElement(cmd);
						logCommandsString.addElement(cmd.toString());
					}
					isModified = true;
					break;
				} else if(s instanceof Line) {
					DlgLine dlg = new DlgLine();
					String [] split1 = ((Line) s).getStartPoint().toString().split(" ");
					String [] split2 = ((Line) s).getEndPoint().toString().split(" ");
					dlg.getTxtX1().setText(split1 [1]);
					dlg.getTxtY1().setText(split1 [3]);
					dlg.getTxtX2().setText(split2 [1]);
					dlg.getTxtY2().setText(split2 [3]);
					dlg.setColor(s.getColor());
					dlg.getBtnColor().setBackground(s.getColor());
					dlg.setVisible(true);
					if(dlg.isOk()) {
						
						Command cmd = new UpdateLineCmd((Line)s, new Line(
								new Point(Integer.parseInt(dlg.getTxtX1().getText()),Integer.parseInt(dlg.getTxtY1().getText())), 
								new Point(Integer.parseInt(dlg.getTxtX2().getText()),Integer.parseInt(dlg.getTxtY2().getText())), 
								dlg.getColor()));
						cmd.execute();
						undoCommands.push(cmd);
						redoCommands.clear();
						logCommands.addElement(cmd);
						logCommandsString.addElement(cmd.toString());
					}
					isModified = true;
					break;
				} else if(s instanceof Rectangle) {
					DlgRectangle dlg = new DlgRectangle();
					String[] split = s.toString().split(" ");
					dlg.getTxtUpperLeftPointX().setText(split [4]);
					dlg.getTxtUpperLeftPointY().setText(split [6]);
					dlg.getTxtWidth().setText(split[10]);
					dlg.getTxtHeight().setText(split[14]);
					dlg.setOutColor(s.getColor());
					dlg.setInnerColor(((Rectangle) s).getFillColor());
					dlg.getBtnOutColor().setBackground(s.getColor());
					dlg.getBtnFillColor().setBackground(((Rectangle) s).getFillColor());
					dlg.setVisible(true);
					if(dlg.isOk()) {
						
						Command cmd = new UpdateRectangleCmd((Rectangle)s, new Rectangle(
								new Point(Integer.parseInt(dlg.getTxtUpperLeftPointX().getText()),Integer.parseInt(dlg.getTxtUpperLeftPointY().getText())), 
								Integer.parseInt(dlg.getTxtWidth().getText()), 
								Integer.parseInt(dlg.getTxtHeight().getText()), dlg.getOutColor(), dlg.getInnerColor()));
						cmd.execute();
						undoCommands.push(cmd);
						redoCommands.clear();
						logCommands.addElement(cmd);
						logCommandsString.addElement(cmd.toString());
					}
					isModified = true;
					break;
				}else if(s instanceof Donut) {
					DlgDonut dlg = new DlgDonut();
					String [] split = s.toString().split(" ");
					dlg.getTxtCenterX().setText(split[2]);
					dlg.getTxtCenterY().setText(split[4]);
					dlg.getTxtOuterRadius().setText(split[9]);
					dlg.getTxtInnerRadius().setText(split[12]);
					dlg.setOutColor(s.getColor());
					dlg.setInnerColor(((Donut) s).getFillColor());
					dlg.getBtnOutColor().setBackground(s.getColor());;
					dlg.getBtnFillColor().setBackground(((Donut) s).getFillColor());
					dlg.setVisible(true);
					if(dlg.isOk()) {
						Command cmd = new UpdateDonutCmd((Donut)s, new Donut(
								new Point(Integer.parseInt(dlg.getTxtCenterX().getText()),Integer.parseInt(dlg.getTxtCenterY().getText())),
								Integer.parseInt(dlg.getTxtOuterRadius().getText()), 
								Integer.parseInt(dlg.getTxtInnerRadius().getText()), dlg.getOutColor(), dlg.getInnerColor()));
						cmd.execute();
						undoCommands.push(cmd);
						redoCommands.clear();
						logCommands.addElement(cmd);
						logCommandsString.addElement(cmd.toString());
						
					}
					isModified = true;
					break;
				} else if(s instanceof Circle) {
					DlgCircle dlg = new DlgCircle();
					String [] split = s.toString().split(" ");
					dlg.getTxtCenterX().setText(split[2]);
					dlg.getTxtCenterY().setText(split[4]);
					dlg.getTxtRadius().setText(split[9]);
					dlg.setOutColor(s.getColor());
					dlg.setInnerColor(((Circle) s).getFillColor());
					dlg.getBtnOutColor().setBackground(s.getColor());;
					dlg.getBtnFillColor().setBackground(((Circle) s).getFillColor());
					dlg.setVisible(true);
					if(dlg.isOk()) {
						Command cmd = new UpdateCircleCmd((Circle)s, new Circle(
								new Point(Integer.parseInt(dlg.getTxtCenterX().getText()),Integer.parseInt(dlg.getTxtCenterY().getText())),
								Integer.parseInt(dlg.getTxtRadius().getText()), dlg.getOutColor(), dlg.getInnerColor()));
						cmd.execute();
						undoCommands.push(cmd);
				        redoCommands.clear();
						logCommands.addElement(cmd);
						logCommandsString.addElement(cmd.toString());
					}
					isModified = true;
					break;
				} else if (s instanceof HexagonAdapter)
				{
					DlgHexagon dlg = new DlgHexagon();
					String [] split = s.toString().split(" ");
					dlg.getTxtCenterX().setText(split[2]);
					dlg.getTxtCenterY().setText(split[4]);
					dlg.getTxtRadius().setText(split[9]);
					dlg.setOutColor(((HexagonAdapter)s).getHexa().getBorderColor());
					dlg.setInnerColor(((HexagonAdapter)s).getHexa().getAreaColor());
					dlg.getBtnOutColor().setBackground(((HexagonAdapter)s).getHexa().getBorderColor());;
					dlg.getBtnFillColor().setBackground(((HexagonAdapter)s).getHexa().getAreaColor());
					dlg.setVisible(true);
					if(dlg.isOk()) {
						
						Command cmd = new UpdateHexagonCmd((HexagonAdapter)s, new HexagonAdapter(new Hexagon(Integer.parseInt(dlg.getTxtCenterX().getText()),
								Integer.parseInt(dlg.getTxtCenterY().getText()), Integer.parseInt(dlg.getTxtRadius().getText())), dlg.getOutColor(), dlg.getInnerColor()));
						cmd.execute();
						undoCommands.push(cmd);
				        redoCommands.clear();
						logCommands.addElement(cmd);
						logCommandsString.addElement(cmd.toString());
					}
					isModified = true;
					break;
				}
			} 
		}
        if (!isModified) {
        	JOptionPane.showMessageDialog(null, "Select a shape to modify");
        }
        visibleUndoButton(undoCommands.size());
		visibleRedoButton(redoCommands.size());
        countSelectedShapes();
        frame.getView().repaint();
	}

	public void deleteEvent(ActionEvent e)
	{
		boolean isDeleted = false;
		int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want do delete?");
		if(ans == 0) {
			for(int i = 0; i < model.getShapes().size(); i++)
			{
				Shape s = model.getShapes().get(i);
				if (s.isSelected()) {
					
					if (s instanceof Point)
					{
						Command cmd = new RemovePointCmd(model, (Point)s, i);
						undoCommands.push(cmd);
						cmd.execute();
				        redoCommands.clear();
						logCommands.addElement(cmd);
						logCommandsString.addElement(cmd.toString());
					}
					else if (s instanceof Line)
					{
						Command cmd = new RemoveLineCmd(model, (Line)s, i);
						undoCommands.push(cmd);
						cmd.execute();
				        redoCommands.clear();
						logCommands.addElement(cmd);
						logCommandsString.addElement(cmd.toString());
					}
					else if (s instanceof Rectangle)
					{
						Command cmd = new RemoveRectangleCmd(model, (Rectangle)s, i);
						undoCommands.push(cmd);
						cmd.execute();
				        redoCommands.clear();
						logCommands.addElement(cmd);
						logCommandsString.addElement(cmd.toString());
					}
					else if (s instanceof Donut)
					{
						Command cmd = new RemoveDonutCmd(model, (Donut)s, i);
						undoCommands.push(cmd);
						cmd.execute();
				        redoCommands.clear();
						logCommands.addElement(cmd);
						logCommandsString.addElement(cmd.toString());
					}
					else if (s instanceof Circle)
					{
						Command cmd = new RemoveCircleCmd(model, (Circle)s, i);
						undoCommands.push(cmd);
						cmd.execute();
				        redoCommands.clear();
						logCommands.addElement(cmd);
						logCommandsString.addElement(cmd.toString());
					}
					else if (s instanceof HexagonAdapter)
					{
						Command cmd = new RemoveHexagonCmd(model, (HexagonAdapter)s, i);
						undoCommands.push(cmd);
						cmd.execute();
				        redoCommands.clear();
						logCommands.addElement(cmd);
						logCommandsString.addElement(cmd.toString());
					}
				isDeleted = true;
				i--;
				frame.getView().repaint();
				} else isDeleted = true;
			}
		}
		visibleUndoButton(undoCommands.size());
		visibleRedoButton(redoCommands.size());
        countSelectedShapes();
        if (isDeleted == false) {
        	JOptionPane.showMessageDialog(null, "Select a shape to delete");
        }}
	
	public void undoEvent(ActionEvent e)
	{
		if (!undoCommands.isEmpty())
		{
			Command cmd = undoCommands.pop();
			Command undo = new UndoCmd(cmd);
			undo.execute();
			redoCommands.push(cmd);
			logCommands.addElement(undo);
			logCommandsString.addElement(undo.toString());
		} else
		{
			JOptionPane.showMessageDialog(null, "No commands to undo");
		}
		visibleUndoButton(undoCommands.size());
		visibleRedoButton(redoCommands.size());
		countSelectedShapes();
		frame.getView().repaint();
	}
	
	public void redoEvent(ActionEvent e)
	{
		if (!redoCommands.isEmpty())
		{
			Command cmd = redoCommands.pop();
			Command redo = new RedoCmd(cmd);
			redo.execute();
			undoCommands.push(cmd);
			logCommands.addElement(redo);
			logCommandsString.addElement(redo.toString());
		} else
		{
			JOptionPane.showMessageDialog(null, "No commands to redo");
		}
		visibleUndoButton(undoCommands.size());
		visibleRedoButton(redoCommands.size());
		countSelectedShapes();
		frame.getView().repaint();
		
	}
	
	public void borderColorSelect(ActionEvent e) {
		
		borderColor = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
		frame.btnBorderColor.setBackground(borderColor);
	}
	
	public void fillColorSelect(ActionEvent e) {
		fillColor = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
		frame.btnFillColor.setBackground(fillColor);
	}
	
	public void moveUpEvent(ActionEvent e) {
		Iterator <Shape> it = model.getShapes().iterator();
        while(it.hasNext()) {
			Shape s = it.next();
			int index = model.getShapes().indexOf(s);
			if (s.isSelected()) {
				if(index > 0) {
					Command cmd = new MoveUpCmd(model, s, index);
					cmd.execute();
					undoCommands.push(cmd);
					redoCommands.clear();
					logCommands.addElement(cmd);
					logCommandsString.addElement(cmd.toString());
					frame.getView().repaint();
					}
				break;
			}
		}
        visibleUndoButton(undoCommands.size());
		visibleRedoButton(redoCommands.size());
	}
	
	public void moveDownEvent(ActionEvent e) {
		Iterator <Shape> it = model.getShapes().iterator();
        while(it.hasNext()) {
			Shape s = it.next();
			int index = model.getShapes().indexOf(s);
			if (s.isSelected()) {
				if(index + 1 < model.getShapes().size()) {
					Command cmd = new MoveDownCmd(model, s, index);
					cmd.execute();
					undoCommands.push(cmd);
					redoCommands.clear();
					logCommands.addElement(cmd);
					logCommandsString.addElement(cmd.toString());
				frame.getView().repaint();
				}
				break;
			}
		}
        visibleUndoButton(undoCommands.size());
		visibleRedoButton(redoCommands.size());
	}
	
	public void moveToTopEvent(ActionEvent e) {
		Iterator <Shape> it = model.getShapes().iterator();
        while(it.hasNext()) {
			Shape s = it.next();
			int index = model.getShapes().indexOf(s);
			if (s.isSelected()) {
				if(index != 0) {
					Command cmd = new MoveToTopCmd(model, s, index);
					cmd.execute();
					undoCommands.push(cmd);
					redoCommands.clear();
					logCommands.addElement(cmd);
					logCommandsString.addElement(cmd.toString());
					frame.getView().repaint();
				}
				break;
			}
		}
	}
	
	public void moveToBottomEvent(ActionEvent e) {
		Iterator <Shape> it = model.getShapes().iterator();
        while(it.hasNext()) {
			Shape s = it.next();
			int index = model.getShapes().indexOf(s);
			if (s.isSelected()) {
				if (index != model.getShapes().size()-1) {
					Command cmd = new MoveToBottomCmd(model, s, index);
					cmd.execute();
					undoCommands.push(cmd);
					redoCommands.clear();
					logCommands.addElement(cmd);
					logCommandsString.addElement(cmd.toString());
					frame.getView().repaint();
				}
				break;
			}
		}
        visibleUndoButton(undoCommands.size());
		visibleRedoButton(redoCommands.size());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("selectedShapes")) {
			if((int)evt.getNewValue() < 1) {
				changeButtonVisible(frame.btnModify, false);
				changeButtonVisible(frame.btnDelete, false);
			} else if ((int)evt.getNewValue() > 1)
			{
				changeButtonVisible(frame.btnModify, false);
				changeButtonVisible(frame.btnDelete, true);
			} else {
				changeButtonVisible(frame.btnModify, true);
				changeButtonVisible(frame.btnDelete, true);
			}
		}
	}
	
	public void visibleUndoButton(int size) {
		if(size < 1) {
			frame.btnUndo.setVisible(false);
		} else {
			frame.btnUndo.setVisible(true);
		}
	}
	
	public void visibleRedoButton(int size) {
		if (size == 0) {
			frame.btnRedo.setVisible(false);
		} else {
			frame.btnRedo.setVisible(true);
		}
	}
	
	public void changeButtonVisible(AbstractButton btn, boolean select) {
		btn.setVisible(select);
	}
	
	public void countSelectedShapes() {
		int pom = 0;
		Iterator <Shape> it = model.getShapes().iterator();
        while(it.hasNext()) {
			Shape s = it.next();
			if (s.isSelected()) {
				pom++;
			}
		}
        model.setNumberOfSelectedShapes(pom);
	}

	public void saveDrawingEvent(ActionEvent e) {
		JFileChooser fc = new JFileChooser("D:\\Faks\\3.godina\\1.semestar\\Dizajnerski obrasci\\Projekat - fajlovi\\Drawings");
		FileFilter ff = new FileNameExtensionFilter(".bin", "bin");
		fc.addChoosableFileFilter(ff);
		fc.setFileFilter(ff);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int resault = fc.showSaveDialog(fc);
		if(resault== JFileChooser.APPROVE_OPTION) {
			FileManipulation saveFile = new FileDrawing(model);
			FileManipulation fmm = new FileManipulationManager(saveFile);
			for(int i = 0; i<model.getShapes().size(); i++) {
				model.getShapes().get(i).setSelected(false);
			}
			String fileName = fc.getSelectedFile().toString() + ".bin";
			fmm.saveFile(fileName);	
		}
	}
	
	public void loadDrawingEvent(ActionEvent e) {
		JFileChooser fc = new JFileChooser("D:\\Faks\\3.godina\\1.semestar\\Dizajnerski obrasci\\Projekat - fajlovi\\Drawings");
		FileFilter ff = new FileNameExtensionFilter(".bin", "bin");
		fc.addChoosableFileFilter(ff);
		fc.setFileFilter(ff);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int resault = fc.showOpenDialog(fc);
		if(resault== JFileChooser.APPROVE_OPTION) {
			FileManipulation loadFile = new FileDrawing(model);
			FileManipulation fmm = new FileManipulationManager(loadFile);
			String fileName = fc.getSelectedFile().toString();
			fmm.loadFile(fileName);
			frame.getView().repaint();
		}
	}

	public void saveLogEvent(ActionEvent e) {
		
		JFileChooser fc = new JFileChooser("D:\\Faks\\3.godina\\1.semestar\\Dizajnerski obrasci\\Projekat - fajlovi\\Logs");
		FileFilter ff = new FileNameExtensionFilter(".txt", "txt");
		fc.addChoosableFileFilter(ff);
		fc.setFileFilter(ff);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int resault = fc.showSaveDialog(fc);
		if(resault== JFileChooser.APPROVE_OPTION) {
			for(int i = logCommands.size()-1; i >= 0; i--) {
				logCommands.get(i).unexecute();
			}
			FileManipulation saveFile = new FileLog(model, logCommands, logCommandsString);
			FileManipulation fmm = new FileManipulationManager(saveFile);
			String fileName = fc.getSelectedFile().toString();
			fmm.saveFile(fileName);
			for(int i = 0; i < logCommands.size(); i++) {
				logCommands.get(i).execute();
			}
		}
	}

	public void loadLogEvent(ActionEvent e) {
		JFileChooser fc = new JFileChooser("D:\\Faks\\3.godina\\1.semestar\\Dizajnerski obrasci\\Projekat - fajlovi\\Logs");
		FileFilter ff = new FileNameExtensionFilter(".txt", "txt");
		fc.addChoosableFileFilter(ff);
		fc.setFileFilter(ff);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int resault = fc.showOpenDialog(fc);
		if(resault== JFileChooser.APPROVE_OPTION) {
			FileManipulation loadFile = new FileLog(model, logCommands, logCommandsString);
			FileManipulation fmm = new FileManipulationManager(loadFile);
			String fileName = fc.getSelectedFile().toString();
			fmm.loadFile(fileName);
			frame.getView().repaint();
			frame.btnNextLogCmd.setVisible(true);
			frame.getLstLogs().setSelectedIndex(logIndex);
		}
	}

	public void previousCommand(ActionEvent e) {
		logIndex--;
		selectElement(logIndex);
		logCommands.get(logIndex).unexecute();
		previousCommandVisible();
		nextCommandVisible();
		frame.getView().repaint();
	}

	public void nextCommand(ActionEvent e) {
		logCommands.get(logIndex).execute();
		logIndex++;
		previousCommandVisible();
		selectElement(logIndex);
		nextCommandVisible();
		frame.getView().repaint();
		
	}
	
	public void previousCommandVisible() {
		if (logIndex == 0) {
			frame.btnPrevLogCmd.setVisible(false);
		}
		else frame.btnPrevLogCmd.setVisible(true);
	}
	
	public void nextCommandVisible() {
		if (logIndex == logCommands.size()) {
			frame.btnNextLogCmd.setVisible(false);
		} else {
			frame.btnNextLogCmd.setVisible(true);
		}
	}
	
	public void selectElement(int index) {
		frame.getLstLogs().setSelectedIndex(index);
	}
	
}
