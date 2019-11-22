import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Theme extends JPanel{
	public Theme(boolean dark) {
		if (dark == true) {
			this.setBackground(Colors.DTBackground);
		} else {
			this.setBackground(Colors.LTPanel);
		}
	}
}
