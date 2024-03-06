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
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class DlgCircle extends JDialog {

	private final JPanel pnlValues = new JPanel();
	private JTextField txtCenterX;
	private JTextField txtCenterY;
	private JTextField txtRadius;
	private Color outColor;
	private Color innerColor;
	private boolean isOk;
	JButton btnOutColor = new JButton("Choose Border Color");
	JButton btnFillColor = new JButton("Choose Fill Color");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setResizable(false);
		setTitle("Input values of circle");
		setModal(true);
		setBounds(100, 100, 338, 226);
		getContentPane().setLayout(new BorderLayout());
		pnlValues.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlValues, BorderLayout.CENTER);
		
		JLabel lblCenterX = new JLabel("Center x: ");
		lblCenterX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblCenterY = new JLabel("Center y: ");
		lblCenterY.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblRadius = new JLabel("Radius:");
		lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtCenterX = new JTextField();
		txtCenterX.setColumns(10);
		
		txtCenterY = new JTextField();
		txtCenterY.setColumns(10);
		
		txtRadius = new JTextField();
		txtRadius.setColumns(10);
		
		
		btnOutColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outColor = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
				btnOutColor.setBackground(outColor);
			}
		});
		
		
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
				btnFillColor.setBackground(innerColor);
			}
		});
		GroupLayout gl_pnlValues = new GroupLayout(pnlValues);
		gl_pnlValues.setHorizontalGroup(
			gl_pnlValues.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlValues.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addGroup(gl_pnlValues.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnlValues.createSequentialGroup()
									.addComponent(btnOutColor)
									.addGap(18)
									.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlValues.createSequentialGroup()
									.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnlValues.createSequentialGroup()
											.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
											.addGap(18))
										.addGroup(gl_pnlValues.createSequentialGroup()
											.addComponent(lblCenterY, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(18)
									.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
										.addComponent(txtRadius, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
										.addComponent(txtCenterY, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
										.addComponent(txtCenterX, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))))
							.addGap(22))
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addComponent(lblCenterX)
							.addContainerGap(245, Short.MAX_VALUE))))
		);
		gl_pnlValues.setVerticalGroup(
			gl_pnlValues.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlValues.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCenterX)
						.addComponent(txtCenterX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCenterY)
						.addComponent(txtCenterY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOutColor)
						.addComponent(btnFillColor))
					.addContainerGap(40, Short.MAX_VALUE))
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
							
							if (txtCenterX.getText().trim().isEmpty() || 
									txtCenterY.getText().trim().isEmpty() || 
									txtRadius.getText().trim().isEmpty()){
								JOptionPane.showMessageDialog(null, "Fill in all the blanks!!");
								break;
							}
							try {
								Integer.parseInt(txtCenterX.getText());
								Integer.parseInt(txtCenterY.getText());
								Integer.parseInt(txtRadius.getText());
							} catch(NumberFormatException nfe){
									JOptionPane.showMessageDialog(null, "Integers only!!");
									break;
							}
							if(Integer.parseInt(txtCenterX.getText())<0 ||
									Integer.parseInt(txtCenterY.getText())<0 ||
									Integer.parseInt(txtRadius.getText())<0) {
								JOptionPane.showMessageDialog(null, "You can't enter negative values!!");
								break;
							}
							if(Integer.parseInt(txtCenterX.getText())< Integer.parseInt(txtRadius.getText())
									|| Integer.parseInt(txtCenterY.getText()) < Integer.parseInt(txtRadius.getText())) {
								JOptionPane.showMessageDialog(null, "Radius value is to high");
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

	public JTextField getTxtCenterX() {
		return txtCenterX;
	}

	public void setTxtCenterX(JTextField txtCenterX) {
		this.txtCenterX = txtCenterX;
	}

	public JTextField getTxtCenterY() {
		return txtCenterY;
	}

	public void setTxtCenterY(JTextField txtCenterY) {
		this.txtCenterY = txtCenterY;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public Color getOutColor() {
		return outColor;
	}

	public void setOutColor(Color outColor) {
		this.outColor = outColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public JButton getBtnOutColor() {
		return btnOutColor;
	}

	public JButton getBtnFillColor() {
		return btnFillColor;
	}

	
	
}
