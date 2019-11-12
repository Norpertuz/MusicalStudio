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
	public void validation(String type) {
		if (type == "normal") {
			if(field.getText().length() < 4) {
				field.setText("za malo");
			}
		} else if (type == "email") {
			String symbols = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			if(field.getText().matches(symbols) != true) {
				field.setText("");
				label.setText("Nieprawidłowy e-mail");
				label.setForeground(Color.decode("#EE2B47"));
				field.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.decode("#EE2B47")));
			}
		}
	}
	
	public newTextField(String text, String type) {
		// label
		label.setText(text);
		label.setForeground(Color.orange);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(0, 0, 287, 20);
		super.add(label);
		// textfield
		field.setHorizontalAlignment(SwingConstants.LEFT);
		field.setColumns(10);
		field.setBounds(0, 25, 300, 44);
		super.add(field);
		// focus
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
		// container
		super.setBounds(38, 117, field.getWidth(), field.getHeight()+label.getHeight()+5);
		super.setVisible(true);
		super.setLayout(null);
		super.setOpaque(false);
	}
}
