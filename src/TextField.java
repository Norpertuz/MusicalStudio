import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class TextField extends JTextField {
	
	public void focusGained(ActionListener e) {
		((JComponent) ((ComponentEvent) e).getComponent()).setBorder(
				BorderFactory.createMatteBorder(3,3,3,3,Color.decode("#FFFFFF")));
		((JComponent) ((ComponentEvent) e).getComponent()).setBorder(
				BorderFactory.createCompoundBorder(getBorder(), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		((ComponentEvent) e).getComponent().setForeground(Color.decode("#EE2B47"));
	}
	
	public void focusLost(ActionListener e) {
		((JComponent) ((ComponentEvent) e).getComponent()).setBorder(BorderFactory.createMatteBorder(
				3,3,3,3,
				Color.decode("#4C506D")));
		((JComponent) ((ComponentEvent) e).getComponent()).setBorder(BorderFactory.createCompoundBorder(
				getBorder(), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		((ComponentEvent) e).getComponent().setForeground(Color.decode("#4C506D"));
	}
	
	@Override
	public synchronized void addActionListener(ActionListener l) {
		focusGained(l);
		focusLost(l);
		super.addActionListener(l);
	}
	
	public TextField() {
		this.setVisible(true);
		this.setBackground(null);
	}
}
