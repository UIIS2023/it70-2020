package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class DlgLine extends JDialog {

	private final JPanel pnlValues = new JPanel();
	private JTextField txtX1;
	private JTextField txtY1;
	private JTextField txtX2;
	private JTextField txtY2;
	private Color color;
	private boolean isOk;
	JButton btnColor = new JButton("Choose color");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setTitle("Input values of line");
		setBounds(100, 100, 245, 271);
		getContentPane().setLayout(new BorderLayout());
		pnlValues.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlValues, BorderLayout.CENTER);
		setModal(true);
		
		JLabel lblX1 = new JLabel("Start point x:");
		
		JLabel lblY1 = new JLabel("Start point y:");
		
		JLabel lblX2 = new JLabel("End point x:");
		
		JLabel lblY2 = new JLabel("End point y:");
		
		txtX1 = new JTextField();
		txtX1.setColumns(10);
		
		txtY1 = new JTextField();
		txtY1.setColumns(10);
		
		txtX2 = new JTextField();
		txtX2.setColumns(10);
		
		txtY2 = new JTextField();
		txtY2.setColumns(10);

		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
				btnColor.setBackground(color);
			}
		});
		GroupLayout gl_pnlValues = new GroupLayout(pnlValues);
		gl_pnlValues.setHorizontalGroup(
			gl_pnlValues.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlValues.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblY2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblY1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblX2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(19)
							.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtY2)
								.addComponent(txtX2)
								.addComponent(txtX1)
								.addComponent(txtY1, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
						.addComponent(lblX1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnColor))
					.addGap(94))
		);
		gl_pnlValues.setVerticalGroup(
			gl_pnlValues.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlValues.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtX1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblX1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtY1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblY1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtX2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblX2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtY2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblY2))
					.addGap(18)
					.addComponent(btnColor)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		pnlValues.setLayout(gl_pnlValues);
		{
			JPanel pnlConfirmCancel = new JPanel();
			pnlConfirmCancel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
			pnlConfirmCancel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlConfirmCancel, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							while(isOk == false) {
							
							if (txtX1.getText().trim().isEmpty() || 
									txtY1.getText().trim().isEmpty() || 
									txtX2.getText().trim().isEmpty() || 
									txtY2.getText().trim().isEmpty()){
								JOptionPane.showMessageDialog(null, "Fill in all the blanks!!");
								break;
							}
							try {
								Integer.parseInt(txtX1.getText());
								Integer.parseInt(txtY1.getText());
								Integer.parseInt(txtX2.getText());
								Integer.parseInt(txtY2.getText());
							} catch(NumberFormatException nfe){
									JOptionPane.showMessageDialog(null, "Integers only!!");
									break;
							}
							if(Integer.parseInt(txtX1.getText())<0 ||
									Integer.parseInt(txtY1.getText())<0 || 
									Integer.parseInt(txtX2.getText())<0 ||
									Integer.parseInt(txtY2.getText())<0) {
								JOptionPane.showMessageDialog(null, "You can't enter negative values!!");
								break;
							}
								
							setOk(true);
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				pnlConfirmCancel.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				pnlConfirmCancel.add(cancelButton);
			}
		}
	}

	public JTextField getTxtX1() {
		return txtX1;
	}

	public void setTxtX1(JTextField txtX1) {
		this.txtX1 = txtX1;
	}

	public JTextField getTxtY1() {
		return txtY1;
	}

	public void setTxtY1(JTextField txtY1) {
		this.txtY1 = txtY1;
	}

	public JTextField getTxtX2() {
		return txtX2;
	}

	public void setTxtX2(JTextField txtX2) {
		this.txtX2 = txtX2;
	}

	public JTextField getTxtY2() {
		return txtY2;
	}

	public void setTxtY2(JTextField txtY2) {
		this.txtY2 = txtY2;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public JButton getBtnColor() {
		return btnColor;
	}	
	
}
