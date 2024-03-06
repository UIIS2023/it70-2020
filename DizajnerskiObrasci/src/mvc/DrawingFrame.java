package mvc;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class DrawingFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private DrawingController controller;
	private DrawingView view = new DrawingView();
	
	private ButtonGroup btnGroupShapes = new ButtonGroup();
	protected JToggleButton tglbtnPoint = new JToggleButton("Point");
	protected JToggleButton tglbtnLine = new JToggleButton("Line");
	protected JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
	protected JToggleButton tglbtnCircle = new JToggleButton("Circle");
	protected JToggleButton tglbtnDonut = new JToggleButton("Donut");
	protected JToggleButton tglbtnHexagon = new JToggleButton("Hexagon");
	protected JButton btnFillColor = new JButton("");
	protected JButton btnBorderColor = new JButton("");
	private JList<String> lstLogs = new JList<String>();
	protected JButton btnModify = new JButton("Modify");
	protected JButton btnDelete = new JButton("Delete");
	protected JButton btnUndo = new JButton("Undo");
	protected JButton btnRedo = new JButton("Redo");
	protected JButton btnPrevLogCmd = new JButton("Unexecute");
	protected JButton btnNextLogCmd = new JButton("Execute");


	/**
	 * Create the frame.
	 */
	public DrawingFrame() {
		setTitle("Lukic Milos IT70-2020");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 0, 1540, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlShapes = new JPanel();
		
		pnlShapes.setBackground(Color.WHITE);
		pnlShapes.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(pnlShapes, BorderLayout.NORTH);
		contentPane.add(view, BorderLayout.CENTER);
		view.setLayout(new CardLayout(0, 0));
		
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.mouseClicked(e);
			}
		});
		
		btnGroupShapes.add(tglbtnPoint);
		btnGroupShapes.add(tglbtnLine);
		btnGroupShapes.add(tglbtnRectangle);
		btnGroupShapes.add(tglbtnCircle);
		btnGroupShapes.add(tglbtnDonut);
		btnGroupShapes.add(tglbtnHexagon);
		
		JLabel lblShapes = new JLabel("Shapes");
		lblShapes.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblShapes.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout gl_pnlShapes = new GroupLayout(pnlShapes);
		gl_pnlShapes.setHorizontalGroup(
			gl_pnlShapes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlShapes.createSequentialGroup()
					.addGroup(gl_pnlShapes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlShapes.createSequentialGroup()
							.addGap(215)
							.addComponent(lblShapes, GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE))
						.addGroup(gl_pnlShapes.createSequentialGroup()
							.addGap(13)
							.addComponent(tglbtnPoint, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
							.addGap(34)
							.addComponent(tglbtnLine, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
							.addGap(33)
							.addComponent(tglbtnRectangle, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
							.addGap(27)
							.addComponent(tglbtnCircle, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(tglbtnDonut, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
							.addGap(0)))
					.addGap(24)
					.addComponent(tglbtnHexagon, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addGap(8))
		);
		gl_pnlShapes.setVerticalGroup(
			gl_pnlShapes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlShapes.createSequentialGroup()
					.addGap(6)
					.addComponent(lblShapes, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlShapes.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(tglbtnPoint, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnLine, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnRectangle, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnCircle, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnHexagon, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnDonut, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		pnlShapes.setLayout(gl_pnlShapes);
		
		JPanel pnlOptions = new JPanel();
		pnlOptions.setBackground(Color.WHITE);
		pnlOptions.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(pnlOptions, BorderLayout.WEST);
		
		JLabel lblOptions = new JLabel("Options");
		lblOptions.setHorizontalAlignment(SwingConstants.CENTER);
		lblOptions.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		btnGroupShapes.add(tglbtnSelect);
		
		
		btnModify.setVisible(false);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.modifyEvent(e);
			}
			});
		
		btnDelete.setVisible(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.deleteEvent(e);
			}
		});
		
		JButton btnMoveUp = new JButton("Move Up");
		btnMoveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.moveUpEvent(e);
				
			}
		});
		
		JButton btnMoveDown = new JButton("Move Down");
		btnMoveDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.moveDownEvent(e);
			}
		});
		
		JButton btnMoveToTop = new JButton("To top");
		btnMoveToTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.moveToTopEvent(e);
			}
		});
		
		JButton btnMoveToBottom = new JButton("To bottom");
		btnMoveToBottom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.moveToBottomEvent(e);
			}
		});
		
		JLabel lblBorderColor = new JLabel("Border");
		lblBorderColor.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnBorderColor.setBackground(Color.BLACK);
		btnBorderColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.borderColorSelect(e);
			}
		});
		
		JLabel lblFillColor = new JLabel("Fill");
		lblFillColor.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnFillColor.setBackground(Color.WHITE);
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.fillColorSelect(e);
			}
		});
		
		btnUndo.setVisible(false);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.undoEvent(e);
			}
		});
		
		btnRedo.setVisible(false);
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.redoEvent(e);
			}
		});
		
		GroupLayout gl_pnlOptions = new GroupLayout(pnlOptions);
		gl_pnlOptions.setHorizontalGroup(
			gl_pnlOptions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOptions.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlOptions.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlOptions.createSequentialGroup()
							.addGroup(gl_pnlOptions.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblOptions, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(tglbtnSelect, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(btnModify, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(btnDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(btnMoveUp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(btnMoveDown, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(btnMoveToTop, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(btnMoveToBottom, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(lblBorderColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addGroup(gl_pnlOptions.createSequentialGroup()
									.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
									.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
							.addGap(11))
						.addGroup(gl_pnlOptions.createSequentialGroup()
							.addGroup(gl_pnlOptions.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBorderColor, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
							.addGap(45))
						.addGroup(gl_pnlOptions.createSequentialGroup()
							.addComponent(lblFillColor, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(34)))
					.addGap(2))
		);
		gl_pnlOptions.setVerticalGroup(
			gl_pnlOptions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlOptions.createSequentialGroup()
					.addComponent(lblOptions, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(tglbtnSelect, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnModify, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addComponent(btnMoveUp, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMoveDown, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMoveToTop, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMoveToBottom, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBorderColor, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBorderColor, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFillColor, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_pnlOptions.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(31))
		);
		pnlOptions.setLayout(gl_pnlOptions);
		
		JPanel pnlLog = new JPanel();
		pnlLog.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		pnlLog.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlLog, BorderLayout.EAST);
		
		JScrollPane scrlPane = new JScrollPane();
		
		JButton btnSaveLog = new JButton("Save");
		btnSaveLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.saveLogEvent(e);
			}
		});
		
		JButton btnLoadLog = new JButton("Load");
		btnLoadLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.loadLogEvent(e);
			}
		});
		
		JLabel lblLogs = new JLabel("Log");
		lblLogs.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSaveDrawing = new JButton("Save");
		btnSaveDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.saveDrawingEvent(e);
			}
		});
		
		JButton btnLoadDrawing = new JButton("Load");
		btnLoadDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.loadDrawingEvent(e);
			}
		});
		
		JLabel lblDrawing = new JLabel("Drawing");
		
		btnPrevLogCmd.setVisible(false);
		btnPrevLogCmd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.previousCommand(e);
			}
		});
		
		btnNextLogCmd.setVisible(false);
		btnNextLogCmd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.nextCommand(e);
			}
		});
		GroupLayout gl_pnlLog = new GroupLayout(pnlLog);
		gl_pnlLog.setHorizontalGroup(
			gl_pnlLog.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlLog.createSequentialGroup()
					.addGap(107)
					.addComponent(lblDrawing, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(115))
				.addGroup(gl_pnlLog.createSequentialGroup()
					.addGroup(gl_pnlLog.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlLog.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnPrevLogCmd, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(btnNextLogCmd, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlLog.createSequentialGroup()
							.addGap(94)
							.addComponent(lblLogs, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlLog.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnlLog.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlLog.createSequentialGroup()
									.addComponent(btnSaveDrawing, GroupLayout.PREFERRED_SIZE, 66, Short.MAX_VALUE)
									.addGap(105)
									.addComponent(btnLoadDrawing, GroupLayout.PREFERRED_SIZE, 66, Short.MAX_VALUE))
								.addGroup(gl_pnlLog.createSequentialGroup()
									.addComponent(btnSaveLog, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
									.addComponent(btnLoadLog, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrlPane, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))))
					.addGap(21))
		);
		gl_pnlLog.setVerticalGroup(
			gl_pnlLog.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLog.createSequentialGroup()
					.addGap(18)
					.addComponent(lblLogs, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrlPane, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_pnlLog.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSaveLog)
						.addComponent(btnLoadLog))
					.addGap(18)
					.addGroup(gl_pnlLog.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPrevLogCmd)
						.addComponent(btnNextLogCmd))
					.addPreferredGap(ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
					.addComponent(lblDrawing)
					.addGap(29)
					.addGroup(gl_pnlLog.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSaveDrawing)
						.addComponent(btnLoadDrawing))
					.addGap(20))
		);
		
		scrlPane.setViewportView(lstLogs);
		pnlLog.setLayout(gl_pnlLog);
	}
	
	public DrawingView getView() {
		return view;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}
	
	public JList<String> getLstLogs() {
		return lstLogs;
	}
}
