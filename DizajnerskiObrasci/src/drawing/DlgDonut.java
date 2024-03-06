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

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class DlgDonut extends JDialog {

	private final JPanel pnlValues = new JPanel();
	private JTextField txtCenterX;
	private JTextField txtCenterY;
	private JTextField txtOuterRadius;
	private JTextField txtInnerRadius;
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
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setTitle("Input values of donut");
		setModal(true);
		setBounds(100, 100, 431, 268);
		getContentPane().setLayout(new BorderLayout());
		pnlValues.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlValues, BorderLayout.NORTH);
		JLabel lblCenterX = new JLabel("Center x: ");
		lblCenterX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JLabel lblCenterY = new JLabel("Center y: ");
		lblCenterY.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCenterX = new JTextField();
		txtCenterX.setColumns(10);
		txtCenterY = new JTextField();
		txtCenterY.setColumns(10);
		JLabel lblOutterRadius = new JLabel("Outer radius:");
		lblOutterRadius.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtOuterRadius = new JTextField();
		txtOuterRadius.setColumns(10);
		JLabel lblInnerRadius = new JLabel("Inner radius:");
		lblInnerRadius.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtInnerRadius = new JTextField();
		txtInnerRadius.setColumns(10);
		
		
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
					.addGap(10)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addComponent(lblCenterX)
							.addGap(58)
							.addComponent(txtCenterX, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addComponent(lblCenterY, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtCenterY, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addComponent(lblOutterRadius, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtOuterRadius, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addComponent(lblInnerRadius, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addComponent(btnOutColor, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))
		);
		gl_pnlValues.setVerticalGroup(
			gl_pnlValues.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlValues.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addGap(1)
							.addComponent(lblCenterX))
						.addComponent(txtCenterX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addGap(1)
							.addComponent(lblCenterY))
						.addComponent(txtCenterY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addGap(1)
							.addComponent(lblOutterRadius))
						.addComponent(txtOuterRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlValues.createSequentialGroup()
							.addGap(1)
							.addComponent(lblInnerRadius))
						.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOutColor)
						.addComponent(btnFillColor)))
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
									txtOuterRadius.getText().trim().isEmpty()|| 
									txtInnerRadius.getText().trim().isEmpty()){
								JOptionPane.showMessageDialog(null, "Fill in all the blanks!!");
								break;
							}
							try {
								Integer.parseInt(txtCenterX.getText());
								Integer.parseInt(txtCenterY.getText());
								Integer.parseInt(txtOuterRadius.getText());
								Integer.parseInt(txtInnerRadius.getText());
							} catch(NumberFormatException nfe){
									JOptionPane.showMessageDialog(null, "Integers only!!");
									break;
							}
							if(Integer.parseInt(txtCenterX.getText())<0 ||
									Integer.parseInt(txtCenterY.getText())<0 ||
									Integer.parseInt(txtOuterRadius.getText())<0 ||
									Integer.parseInt(txtInnerRadius.getText())<0) {
								JOptionPane.showMessageDialog(null, "You can't enter negative values!!");
								break;
							}
							if(Integer.parseInt(txtInnerRadius.getText()) >= Integer.parseInt(txtOuterRadius.getText())) {
								JOptionPane.showMessageDialog(null, "Inner radius can't be bigger that outer radius!!");
								break;
							}
							if(Integer.parseInt(txtCenterX.getText())< Integer.parseInt(txtOuterRadius.getText())
									|| Integer.parseInt(txtCenterY.getText()) < Integer.parseInt(txtOuterRadius.getText())) {
								JOptionPane.showMessageDialog(null, "Outer radius value is to high");
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

	public JTextField getTxtOuterRadius() {
		return txtOuterRadius;
	}

	public void setTxtOuterRadius(JTextField txtOuterRadius) {
		this.txtOuterRadius = txtOuterRadius;
	}

	public JTextField getTxtInnerRadius() {
		return txtInnerRadius;
	}

	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.txtInnerRadius = txtInnerRadius;
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
