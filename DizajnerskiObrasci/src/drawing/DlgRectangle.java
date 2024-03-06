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

public class DlgRectangle extends JDialog {

	private final JPanel pnlValues = new JPanel();
	private JTextField txtUpperLeftPointX;
	private JTextField txtUpperLeftPointY;
	private JTextField txtWidth;
	private JTextField txtHeight;
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
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setTitle("Input values for rectangle");
		setModal(true);
		setBounds(100, 100, 365, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlValues.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlValues, BorderLayout.CENTER);
		
		JLabel lblUpperLeftPointX = new JLabel("Upper Left Point X: ");
		
		JLabel lblUpperLeftPointY = new JLabel("Upper Left Point Y: ");
		
		JLabel lblWidth = new JLabel("Width: ");
		
		JLabel lblHeight = new JLabel("Height: ");
		
		txtUpperLeftPointX = new JTextField();
		txtUpperLeftPointX.setColumns(10);
		
		txtUpperLeftPointY = new JTextField();
		txtUpperLeftPointY.setColumns(10);
		
		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		
		btnOutColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outColor = JColorChooser.showDialog(null, "Choose color", Color.WHITE);
				btnOutColor.setBackground(outColor);
			}
		});
		
		
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(null, "Choose color", Color.WHITE);
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
							.addComponent(btnOutColor)
							.addGap(18)
							.addComponent(btnFillColor))
						.addGroup(Alignment.TRAILING, gl_pnlValues.createSequentialGroup()
							.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnlValues.createSequentialGroup()
										.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
										.addGap(35))
									.addGroup(gl_pnlValues.createSequentialGroup()
										.addGroup(gl_pnlValues.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblUpperLeftPointX, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblUpperLeftPointY, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_pnlValues.createSequentialGroup()
									.addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addGap(35)))
							.addGroup(gl_pnlValues.createParallelGroup(Alignment.LEADING)
								.addComponent(txtHeight, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
								.addComponent(txtWidth, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
								.addComponent(txtUpperLeftPointY, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
								.addComponent(txtUpperLeftPointX, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
							.addGap(17)))
					.addGap(119))
		);
		gl_pnlValues.setVerticalGroup(
			gl_pnlValues.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlValues.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUpperLeftPointX)
						.addComponent(txtUpperLeftPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUpperLeftPointY)
						.addComponent(txtUpperLeftPointY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_pnlValues.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOutColor)
						.addComponent(btnFillColor))
					.addContainerGap(32, Short.MAX_VALUE))
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
							
							if (txtUpperLeftPointX.getText().trim().isEmpty() || 
									txtUpperLeftPointY.getText().trim().isEmpty() || 
									txtWidth.getText().trim().isEmpty() ||
									txtHeight.getText().trim().isEmpty()){
								JOptionPane.showMessageDialog(null, "Fill in all the blanks!!");
								break;
							}
							try {
								Integer.parseInt(txtUpperLeftPointX.getText());
								Integer.parseInt(txtUpperLeftPointY.getText());
								Integer.parseInt(txtWidth.getText());
								Integer.parseInt(txtHeight.getText());
							} catch(NumberFormatException nfe){
									JOptionPane.showMessageDialog(null, "Integers only!!");
									break;
							}
							if(Integer.parseInt(txtUpperLeftPointX.getText())<0 ||
									Integer.parseInt(txtUpperLeftPointY.getText())<0 ||
									Integer.parseInt(txtWidth.getText())<0 ||
									Integer.parseInt(txtHeight.getText())<0) {
								JOptionPane.showMessageDialog(null, "You can't enter negative values!!");
								break;
							}
							if(Integer.parseInt(txtUpperLeftPointX.getText())<Integer.parseInt(txtWidth.getText()) ||
									Integer.parseInt(txtUpperLeftPointY.getText())< Integer.parseInt(txtHeight.getText())) {
								JOptionPane.showMessageDialog(null, "Width and height values are to high!!");
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

	public JTextField getTxtUpperLeftPointX() {
		return txtUpperLeftPointX;
	}

	public void setTxtUpperLeftPointX(JTextField txtUpperLeftPointX) {
		this.txtUpperLeftPointX = txtUpperLeftPointX;
	}

	public JTextField getTxtUpperLeftPointY() {
		return txtUpperLeftPointY;
	}

	public void setTxtUpperLeftPointY(JTextField txtUpperLeftPointY) {
		this.txtUpperLeftPointY = txtUpperLeftPointY;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
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
