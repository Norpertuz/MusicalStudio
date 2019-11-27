package Theme;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Components.Label_TextField;
import Components.Textfield;

@SuppressWarnings("serial")
public class Theme extends JPanel{
	
	public void Login(boolean dark, String Parent) {
		if (dark == true) {
			if (Parent == "Login") {
				//DARK THEME
				this.setBackground(Colors.DTBackground);
				this.getComponent(3).setForeground(Colors.DTPurple); 
				this.getComponent(6).setForeground(Colors.DTInactive);
				this.getComponent(7).setForeground(Colors.DTInactive);
				this.getComponent(8).setForeground(Colors.DTPurple);
			}
		} else {
			if (Parent == "Login") {
				//LIGHT THEME
				this.setBackground(Colors.LTBackground);
				Textfield username = (Textfield) this.getComponent(0);
				this.getComponent(2).setBackground(Colors.LTBlue);
				this.getComponent(3).setForeground(Colors.LTBlue);
				this.getComponent(6).setForeground(Colors.LTGray);
				this.getComponent(7).setForeground(Colors.LTGray);
				this.getComponent(8).setForeground(Colors.LTBlue);
			}
		}
	}
	
	public void setDarkTheme(JFrame frame, boolean dark) {
		String Parent = frame.getClass().getName();
		Login(dark, Parent);
	}
	public Theme() {
		//nothing
	}
}
