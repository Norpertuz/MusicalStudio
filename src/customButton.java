import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class customButton extends JButton{
	public Color dt_red = Color.decode("#EE2B47");
	public Color lt_blue = Color.decode("#0311FC");
	public Color white = Color.decode("#FFFFFF");
	
	public String ubuntuURL = "assets/fonts/Ubuntu-Regular.ttf";
	
	@Override
	public void setFont(Font Ubuntu) {
		Ubuntu = new Font("Tahoma", Font.BOLD, 12);
		super.setFont(Ubuntu);
	}
	
	public customButton(String text, String theme) {
		super(text);
		super.setBorder(null);
		super.setOpaque(true);
		super.setForeground(this.white);
		if (theme == "light") {
			super.setBackground(this.lt_blue);
		} else if (theme == "dark"){
			super.setBackground(this.dt_red);
		}
	}
}
