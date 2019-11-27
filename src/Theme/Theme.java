package Theme;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Components.Label_TextField;
import Components.PasswordField;
import Components.Textfield;

@SuppressWarnings("serial")
public class Theme extends JPanel{
	
	public void Login(boolean dark, String Parent) {
		if (dark == true) {
			if (Parent == "Login") {
				//DARK THEME
				this.setBackground(Colors.DTBackground);
				Textfield username = (Textfield) this.getComponent(0);
				username.handleFocus(true);
				PasswordField password = (PasswordField) this.getComponent(1);
				password.handleFocus(true);
				this.getComponent(2).setBackground(Colors.DTPurple);
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
				username.handleFocus(false);
				PasswordField password = (PasswordField) this.getComponent(1);
				password.handleFocus(false);
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
