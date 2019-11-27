package Components;
import Theme.Colors;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Textfield extends JPanel {
	public JTextField textfield = new JTextField();
	public JLabel label = new JLabel();
	public GridBagConstraints wrapper = new GridBagConstraints();
	//DARK THEME
	public MatteBorder DTInactive = BorderFactory.createMatteBorder(3,3,3,3, Colors.DTInactive);
	public MatteBorder DTActive = BorderFactory.createMatteBorder(3,3,3,3, Colors.DTActive);
	//LIGHT THEME
	public MatteBorder LTInactive = BorderFactory.createMatteBorder(3,3,3,3, Colors.LTGray);
	public MatteBorder LTActive = BorderFactory.createMatteBorder(3,3,3,3, Colors.LTBlue);
	
	public void setTextfield (MatteBorder border, Color fontColor) {
		textfield.setBorder(border);
		textfield.setBorder(BorderFactory.createCompoundBorder(textfield.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 10)));
		textfield.setForeground(fontColor);
	}
	
	public Textfield(String type, String text) {
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
		textfield.setBackground(null);
		this.setTextfield(DTActive, Colors.DTPurple);
		wrapper.gridx=0;
		wrapper.gridy=1;
		wrapper.gridwidth=1;
		wrapper.weightx=1;
		wrapper.fill = GridBagConstraints.HORIZONTAL;
		wrapper.ipady=15;
		wrapper.anchor = GridBagConstraints.LINE_START;
		this.add(textfield, wrapper);
	}
}
