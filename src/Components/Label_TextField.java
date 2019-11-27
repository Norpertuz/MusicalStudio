package Components;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Theme.Colors;

@SuppressWarnings("serial")
public class Label_TextField extends JPanel {
	public JLabel label = new JLabel();
	public TField field = new TField();
	public PassField passwordfield = new PassField();
	
	@Override
	public Component add(Component comp) {
		comp.setBounds(this.getX(), this.getY(), this.getSize().width, this.getSize().height);
		return super.add(comp);
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		aFlag = true;
		super.setVisible(aFlag);
	}
	
	private void setDefault(String name) {
		passwordfield.border(passwordfield.inactive, Colors.DTInactive);
		field.border(field.inactive, Colors.DTInactive);
		label.setForeground(Colors.DTInactive);
		label.setText(name);
	}
	
	private void handleTextFieldErr(String name, String message) {
		passwordfield.border(passwordfield.err, Colors.ERR);
		field.border(field.err, Colors.ERR);
		label.setForeground(Colors.ERR);
		label.setText(name + " " + message);
	}
	
	private void handleValidation(String name, String type) {
		if (type == "default") {
			if(field.getText().length() < 3) {
				handleTextFieldErr(name, "is too short");
			} else {
				setDefault(name);
			}
		} else if (type == "email") {
			String email = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			if(field.getText().matches(email) != true) {
				handleTextFieldErr(name, "Please enter a valid e-mail address");
			} else {
				setDefault(name);
			}
		} else if (type == "password") {
			if(passwordfield.getPassword().length < 3) {
				handleTextFieldErr(name, "is too short");
			} else {
				setDefault(name);
			}
		}
	}
	
	public void setDarkMode() {
		label.setForeground(Colors.DTInactive);
	}
	
	public void setLightMode() {
		label.setForeground(Colors.LTGray);
	}
	
	public Label_TextField(String name, String type) {
		// Container
		this.setBackground(null);
		this.setOpaque(false);
		// Container - layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints container = new GridBagConstraints();
		container.insets = new Insets(2, 0, 4, 0);
		// Label
		label.setText(name);
		label.setForeground(Colors.inactive);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		container.gridx=0;
		container.gridy=0;
		container.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(label, container);
		if (type == "password") {
			container.gridx=0;
			container.gridy=1;
			container.gridwidth=1;
			container.weightx=1;
			container.fill = GridBagConstraints.HORIZONTAL;
			container.ipady=15;
			container.anchor = GridBagConstraints.LINE_START;
			this.add(passwordfield, container);
			// validation
			passwordfield.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					passwordfield.border(field.active, Colors.DTPurple);
					label.setForeground(Colors.active);
				}
				@Override
				public void focusLost(FocusEvent e) {
					handleValidation(name, type);
				}
			});
		} else {
			// TextField
			container.gridx=0;
			container.gridy=1;
			container.gridwidth=1;
			container.weightx=1;
			container.fill = GridBagConstraints.HORIZONTAL;
			container.ipady=15;
			container.anchor = GridBagConstraints.LINE_START;
			this.add(field, container);
			// validation
			field.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					field.border(field.active, Colors.DTPurple);
					label.setForeground(Colors.active);
				}
				@Override
				public void focusLost(FocusEvent e) {
					handleValidation(name, type);
				}
			});
		}
	}
}
