package Components;
import Theme.Colors;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class PasswordField extends JPanel {
	public JPasswordField passwordfield = new JPasswordField();
	public JLabel label = new JLabel();
	public GridBagConstraints wrapper = new GridBagConstraints();
	//DARK THEME
	public MatteBorder DTInactive = BorderFactory.createMatteBorder(3,3,3,3, Colors.DTInactive);
	public MatteBorder DTActive = BorderFactory.createMatteBorder(3,3,3,3, Colors.DTActive);
	//LIGHT THEME
	public MatteBorder LTInactive = BorderFactory.createMatteBorder(3,3,3,3, Colors.LTGray);
	public MatteBorder LTActive = BorderFactory.createMatteBorder(3,3,3,3, Colors.LTBlue);
	
	public String name;
	
	public MatteBorder ERR = BorderFactory.createMatteBorder(3,3,3,3, Colors.ERR);
	
	public void setPasswordField (MatteBorder border, Color fontColor) {
		passwordfield.setBorder(border);
		passwordfield.setBorder(BorderFactory.createCompoundBorder(passwordfield.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 10)));
		passwordfield.setForeground(fontColor);
	}
	
	public void setLabel(Color fontColor) {
		label.setForeground(fontColor);
	}
	
	public void setDefault(boolean darkMode) {
		if (darkMode == true) {
			this.setPasswordField(DTInactive, Colors.DTInactive);
			this.setLabel(Colors.DTInactive);
		} else {
			this.setPasswordField(LTInactive, Colors.LTGray);
			this.setLabel(Colors.LTGray);
		}
	}
	
	public void setFocus(boolean darkMode) {
		if (darkMode == true) {
			this.setPasswordField(DTActive, Colors.DTPurple);
			this.setLabel(Colors.DTActive);
		} else {
			this.setPasswordField(LTActive, Colors.LTBlue);
			this.setLabel(Colors.LTBlue);
		}
	}
	
	public void isEmpty(String text) {
		if (passwordfield.getPassword().length == 0) {
			setPasswordField(ERR, Colors.ERR);
			label.setForeground(Colors.ERR);
			label.setText(text + " is empty");
		}
	}
	
	public void handleValidation(String text) {
		if (passwordfield.getPassword().length == 0) {
			setPasswordField(ERR, Colors.ERR);
			label.setForeground(Colors.ERR);
			label.setText(text + " is empty");
		} else {
			if (passwordfield.getPassword().length < 3 && passwordfield.getPassword().length > 0) {
				setPasswordField(ERR, Colors.ERR);
				label.setForeground(Colors.ERR);
				label.setText("Password is too short");
			} else {
				label.setText(text);
			}
		}
	}
	
	public void handleFocus(boolean darkMode, String text) {
		if (darkMode == true) {
			passwordfield.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					setFocus(true);
				}
				@Override
				public void focusLost(FocusEvent e) {
					setDefault(true);
					handleValidation(text);
				}
			});
		} else {
			passwordfield.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					setFocus(false);
				}
				@Override
				public void focusLost(FocusEvent e) {
					setDefault(false);
					handleValidation(text);
				}
			});
		}
	}
	
	public PasswordField(String text) {
		this.name = text;
		// Wrapper
		this.setBackground(null);
		this.setLayout(new GridBagLayout());
		wrapper.insets = new Insets(2, 0, 4, 0);
		// Label
		label.setText(text);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		wrapper.gridx=0;
		wrapper.gridy=0;
		wrapper.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(label, wrapper);
		// Textfield
		passwordfield.setBackground(null);
		wrapper.gridx=0;
		wrapper.gridy=1;
		wrapper.gridwidth=1;
		wrapper.weightx=1;
		wrapper.fill = GridBagConstraints.HORIZONTAL;
		wrapper.ipady=15;
		wrapper.anchor = GridBagConstraints.LINE_START;
		this.add(passwordfield, wrapper);
		this.setDefault(true);
		this.handleFocus(true, text);
	}
}
