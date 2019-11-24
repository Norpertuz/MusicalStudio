package Theme;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Theme extends JPanel{	
	

	
	
	public void setDarkTheme(JFrame frame, boolean dark) {
		String Parent = frame.getClass().getName();
		if (dark == true) {
			if (Parent == "Login") {
				this.setBackground(Colors.DTBackground); //Background
				this.getComponent(3).setForeground(Colors.DTPurple); // Name
				this.getComponent(6).setForeground(Colors.DTInactive); // Forgot password
				this.getComponent(7).setForeground(Colors.DTInactive); //Don't have an account
				this.getComponent(8).setForeground(Colors.DTPurple); // Sign up button
			}
		} else {
			if (Parent == "Login") {
				this.setBackground(Colors.LTPanel); //Background
				this.getComponent(2).setBackground(Colors.LTBlue); // Sign in button
				this.getComponent(3).setForeground(Colors.LTBlue); // Name
				this.getComponent(6).setForeground(Colors.LTGray); // Forgot password
				this.getComponent(7).setForeground(Colors.LTGray); //Don't have an account
				this.getComponent(8).setForeground(Colors.LTBlue); // Sign up button
			}
		}
	}
	
	public Theme() {
		// nothing
	}
}
