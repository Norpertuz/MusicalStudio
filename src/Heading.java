import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Heading extends JPanel {
	JLabel label = new JLabel();
	JLabel line = new JLabel();
	
	public Heading(String text, Color Color) {
		//Label
		label.setText(text.toUpperCase());
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(0, 0, 300, 25);
		this.add(label);
		// Line
		line.setOpaque(true);
		line.setBounds(0,30, 48, 4);
		this.add(line);
		//Panel
		this.setBackground(null);
		this.setLayout(null);
		if (Color == Colors.DTPurple) {
<<<<<<< HEAD
			line.setBackground(Colors.DTActive);
			label.setForeground(Colors.DTPurple);
=======
			line.setBackground(Colors.DTPurple);
			label.setForeground(Colors.DTActive);
>>>>>>> 421e8be70c9ead31d1fd87cde5172f850f51a32a
		}
	}
}
