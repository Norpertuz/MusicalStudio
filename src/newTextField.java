import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class newTextField extends JPanel {
	customTextfield field = new customTextfield();
	JLabel label = new JLabel();
	newPasswordField passfield = new newPasswordField();
	public void validation(String type) {
		if (type == "normal") {
			if(field.getText().length() < 4) {
				label.setText("Za mało znaków");
				label.setForeground(Color.decode("#EE2B47"));
				field.setText("");
				field.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.decode("#EE2B47")));
			}
		} else if (type == "email") {
			String symbols = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			if(field.getText().matches(symbols) != true) {
				field.setText("");
				label.setText("Nieprawidłowy e-mail");
				label.setForeground(Color.decode("#EE2B47"));
				field.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.decode("#EE2B47")));
			}
		} else if (type == "password") {
			if(passfield.getPassword().length < 3) {
				label.setText("Hasło jest za krótkie");
				label.setForeground(Color.decode("#EE2B47"));
				passfield.setText("");
				passfield.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.decode("#EE2B47")));
			}
		}
	}
	
	public newTextField(String text, String type) {
		super.setBackground(null);
		// label
		label.setText(text);
		label.setForeground(Color.decode("#4C506D"));
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(0, 0, 287, 20);
		super.add(label);
		// textfield
		if (type == "normal" || type=="email") {
			field.setHorizontalAlignment(SwingConstants.LEFT);
			field.setColumns(10);
			field.setBounds(0, 25, 300, 44);
			super.add(field);
			super.setBounds(38, 117, field.getWidth(), field.getHeight()+label.getHeight()+5);
			field.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					label.setForeground(Color.white);
					label.setText(text);
				}
				// validation
				@Override
				public void focusLost(FocusEvent e) {
					label.setForeground(Color.decode("#4C506D"));
					validation(type);
				}
			});
		} else if (type == "password") {
			passfield.setHorizontalAlignment(SwingConstants.LEFT);
			passfield.setColumns(10);
			passfield.setOpaque(false);
			passfield.setBounds(0, 25, 300, 44);
			super.add(passfield);
			super.setBounds(38, 117, passfield.getWidth(), passfield.getHeight()+label.getHeight()+5);
			passfield.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					label.setForeground(Color.white);
					label.setText(text);
				}
				// validation
				@Override
				public void focusLost(FocusEvent e) {
					label.setForeground(Color.decode("#4C506D"));
					validation(type);
				}
			});
		}
		// container
		super.setVisible(true);
		super.setLayout(null);
		super.setOpaque(false);
	}
}
