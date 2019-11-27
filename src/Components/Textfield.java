package Components;
import Theme.Colors;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Textfield extends JPanel {
	public JTextField textfield = new JTextField();
	public JPasswordField passwordfield = new JPasswordField();
	public JLabel label = new JLabel();
	
	public Textfield(String type) {
		// Wrapper
		this.setBackground(null);
		this.setLayout(new GridBagLayout());
		GridBagConstraints wrapper = new GridBagConstraints();
//		wrapper.insets = new Insets(2, 0, 4, 0);
		// Label
		label.setText("Test");
		label.setForeground(Colors.inactive);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		wrapper.gridx=0;
		wrapper.gridy=0;
		wrapper.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(label, wrapper);
		// Textfield
		wrapper.gridx=0;
		wrapper.gridy=1;
		wrapper.gridwidth=1;
		wrapper.weightx=1;
		wrapper.fill = GridBagConstraints.HORIZONTAL;
		wrapper.ipady=15;
		wrapper.anchor = GridBagConstraints.LINE_START;
		if (type == "default") {
			this.add(textfield, wrapper);
		} else if (type == "") {
			this.add(passwordfield, wrapper);
		}
	}
}
