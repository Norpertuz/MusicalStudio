import java.awt.event.ActionListener;
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
		// focus --> START
		this.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				((JComponent) e.getComponent()).setBorder(active);	
			}
			@Override
			public void focusLost(FocusEvent e) {
				((JComponent) e.getComponent()).setBorder(inactive);	
			}
			
		});
		// focus --> END
	}
}
