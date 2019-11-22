import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Theme extends JPanel{
	
	public Theme(boolean dark, JFrame frame) {
		String Parent = frame.getClass().getName();
		if (Parent == "Login") {
			if (dark == true) {
				this.setBackground(Colors.DTBackground);
			} else {
				this.setBackground(Colors.LTPanel);
			}
		}
	}
}
