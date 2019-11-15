import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Label_TextField extends JPanel {
	TextField field = new TextField();
	JLabel label = new JLabel();
	
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
	
	public Label_TextField(String name) {
		// Container
		this.setBackground(null);
		this.setOpaque(false);
		// Container - layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints container = new GridBagConstraints();
		container.insets = new Insets(5, 0, 10, 0);
		// Label
		label.setText(name);
		label.setForeground(Colors.darkThemeRed);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		container.gridx=0;
		container.gridy=0;
		container.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(label, container);
		// TextField
		container.gridx=0;
		container.gridy=1;
		container.gridwidth=1;
		container.weightx=1;
		container.fill = GridBagConstraints.HORIZONTAL;
		container.ipady=10;
		container.anchor = GridBagConstraints.LINE_START;
		this.add(field, container);
	}
}
