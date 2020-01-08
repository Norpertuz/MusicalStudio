package Components;
import java.awt.Graphics2D;
import javax.swing.FocusManager;
import javax.swing.JTextField;

import Theme.Colors;

@SuppressWarnings("serial")
public class SearchField extends JTextField{
	public String searchBarLabel = "Enter album title or artist";
		@Override
		protected void paintComponent(java.awt.Graphics g) {
		    super.paintComponent(g);

		    if(getText().isEmpty() && ! (FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)){
		        Graphics2D g2 = (Graphics2D)g.create();
		        g2.setBackground(Colors.DTPlaceholder);
		        g2.drawString(searchBarLabel, 10, 28); //figure out x, y from font's FontMetrics and size of component.
		        g2.dispose();
		    }
		}
	
}
