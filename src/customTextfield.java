import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class customTextfield extends JTextField{
	public customTextfield() {
		super.setForeground(Color.decode("#EE2B47"));
		super.setBackground(null);
		super.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				((JComponent) e.getComponent()).setBorder(BorderFactory.createMatteBorder(
						3,3,3,3,
						Color.pink));
				((JComponent) e.getComponent()).setBorder(BorderFactory.createCompoundBorder(
						getBorder(), 
						BorderFactory.createEmptyBorder(5, 10, 5, 10)));
				e.getComponent().setForeground(Color.decode("#EE2B47"));
			}
			@Override
			public void focusLost(FocusEvent e) {
				((JComponent) e.getComponent()).setBorder(BorderFactory.createMatteBorder(
						3,3,3,3,
						Color.orange));
				((JComponent) e.getComponent()).setBorder(BorderFactory.createCompoundBorder(
						getBorder(), 
						BorderFactory.createEmptyBorder(5, 10, 5, 10)));
				e.getComponent().setForeground(Color.decode("#c3c3c3"));
			}
		});
		super.setOpaque(false);
	}
}
