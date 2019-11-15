import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class PasswordField extends JPasswordField {
	public MatteBorder active = BorderFactory.createMatteBorder(3,3,3,3, Colors.active);
	public MatteBorder inactive = BorderFactory.createMatteBorder(3,3,3,3, Colors.inactive);
	public MatteBorder err = BorderFactory.createMatteBorder(3,3,3,3, Colors.err);
	
	@Override
	public void setBorder(Border border) {
		super.setBorder(border);
	}

	public void border (MatteBorder br, Color fontColor) {
		this.setBorder(br);
		this.setBorder(BorderFactory.createCompoundBorder(getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 10)));
		this.setForeground(fontColor);
	}
	
	public PasswordField() {
		this.setVisible(true);
		this.setBackground(null);
		border(inactive, Colors.inactive);
	}
}
