import java.awt.Component;
import java.awt.Font;

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
		// Label
		label.setText(name);
		label.setBounds(0, 0, this.getWidth(), 10);
		label.setForeground(Colors.darkThemeRed);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.add(label);
		// TextField
		this.add(field);
	}
}
