package Components;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import Theme.Colors;

@SuppressWarnings("serial")
public class TextField extends JTextField {
	public MatteBorder active = BorderFactory.createMatteBorder(3,3,3,3, Colors.active);
	public MatteBorder inactive = BorderFactory.createMatteBorder(3,3,3,3, Colors.inactive);
	public MatteBorder err = BorderFactory.createMatteBorder(3,3,3,3, Colors.ERR);
	
	//DARK THEME
	public MatteBorder DTActive = BorderFactory.createMatteBorder(3,3,3,3, Colors.active);
	
	//LIGHT THEME
	public MatteBorder LTActive = BorderFactory.createMatteBorder(3,3,3,3, Colors.LTBlue);
	
	@Override
	public void setBorder(Border border) {
		super.setBorder(border);
	}

	public void border (MatteBorder br, Color fontColor) {
		this.setBorder(br);
		this.setBorder(BorderFactory.createCompoundBorder(getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 10)));
		this.setForeground(fontColor);
	}
	
	public TextField() {
		this.setVisible(true);
		this.setBackground(null);
		border(inactive, Colors.inactive);
	}
}
