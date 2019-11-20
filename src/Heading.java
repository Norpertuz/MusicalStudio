import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Heading extends JPanel {
	JLabel label = new JLabel();
	JLabel line = new JLabel();
	public Heading(String text) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints container = new GridBagConstraints();
		//Label
		label.setText(text);
		label.setForeground(Colors.darkThemeRed);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		container.gridx=0;
		container.gridy=0;
		container.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(label, container);
		// Line
		line.setBackground(Colors.darkThemeRed);
		container.gridx=0;
		container.gridy=1;
		container.gridwidth=1;
		container.weightx=1;
		container.fill = GridBagConstraints.HORIZONTAL;
		container.ipady=4;
		container.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(line, container);
	}
}
