import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class TextField extends JTextField {
	private MatteBorder active = BorderFactory.createMatteBorder(3,3,3,3, Colors.active);
	private MatteBorder inactive = BorderFactory.createMatteBorder(3,3,3,3, Colors.inactive);
	
	@Override
	public void setBorder(Border border) {
		super.setBorder(border);
	}
	
	public TextField() {
		this.setVisible(true);
		this.setBackground(null);
		// default
		this.setBorder(inactive);
		// focus --> START
		this.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				((JComponent) e.getComponent()).setBorder(active);
				((JComponent) e.getComponent()).setBorder(
						BorderFactory.createCompoundBorder(getBorder(), 
						BorderFactory.createEmptyBorder(0, 10, 0, 10)));
				e.getComponent().setForeground(Colors.darkThemeRed);
			}
			@Override
			public void focusLost(FocusEvent e) {
				((JComponent) e.getComponent()).setBorder(inactive);
				((JComponent) e.getComponent()).setBorder(
						BorderFactory.createCompoundBorder(getBorder(), 
						BorderFactory.createEmptyBorder(0, 10, 0, 10)));
				e.getComponent().setForeground(Colors.inactive);
			}
			
		});
		// focus --> END
	}
}
