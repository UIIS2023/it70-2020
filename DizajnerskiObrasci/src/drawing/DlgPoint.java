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

public class DlgPoint extends JDialog {

	private final JPanel pnlValues = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private Color color;
	private boolean isOk;
	JButton btnColor = new JButton("Choose a color");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setTitle("Coordinates for point");
		setBounds(100, 100, 236, 248);
		getContentPane().setLayout(new BorderLayout());
		pnlValues.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlValues, BorderLayout.CENTER);
		setModal(true);
		
		JLabel lblX = new JLabel("X: ");
		
		JLabel lblY = new JLabel("Y: ");
		
		txtX = new JTextField();
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setColumns(10);
		
		
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Pick a color", Color.WHITE);
				btnColor.setBackground(color);
			}
		});
		GroupLayout gl_pnlValues = new GroupLayout(pnlValues);
		gl_pnlValues.setHorizontalGroup(
			gl_pnlValues.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlValues.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblX)
						.addComponent(lblY))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
						.addComponent(btnColor)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(98))
		);
		gl_pnlValues.setVerticalGroup(
			gl_pnlValues.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlValues.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(Alignment.LEADING, gl_pnlValues.createSequentialGroup()
							.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblY))
					.addGap(18)
					.addComponent(btnColor)
					.addGap(28))
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
							
							if (txtX.getText().trim().isEmpty() || 
									txtY.getText().trim().isEmpty()){
								JOptionPane.showMessageDialog(null, "Fill in all the blanks!!");
								break;
							}
							try {
								Integer.parseInt(txtX.getText());
								Integer.parseInt(txtY.getText());
							} catch(NumberFormatException nfe){
									JOptionPane.showMessageDialog(null, "Integers only!!");
									break;
							}
							if(Integer.parseInt(txtX.getText())<0 ||
									Integer.parseInt(txtY.getText())<0) {
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

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
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
