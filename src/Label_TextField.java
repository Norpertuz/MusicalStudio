import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Label_TextField extends JPanel {
	TextField field = new TextField();
	
	@Override
	public Component add(Component comp) {
		return super.add(comp);
	}
	
	public Label_TextField() {
		//TextField
		this.add(field);
		field.setBounds(0, 0, this.getWidth(), this.getHeight());
	}
}
