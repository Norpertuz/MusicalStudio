import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class TextField extends JTextField {
	
	@Override
	public void setBorder(Border border) {
		super.setBorder(border);
	}
	
	public TextField() {
		this.setVisible(true);
		this.setBackground(null);
		
		MatteBorder active = BorderFactory.createMatteBorder(3,3,3,3, Colors.darkThemeRed);
		this.setBorder(active);
	}
}
