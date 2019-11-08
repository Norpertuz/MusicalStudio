import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;

public class customButton extends JButton{
	public Color blue = Color.decode("#0311FC");
	public Color white = Color.decode("#FFFFFF");
	public String ubuntuURL = "assets/fonts/Ubuntu-Regular.ttf";
	
	@Override
	public void setFont(Font Ubuntu) {
		Ubuntu = new Font("Tahoma", Font.BOLD, 5);
		super.setFont(Ubuntu);
	}
	
	public customButton(String text) {
		super(text);
		super.setBackground(this.blue);
		super.setBorder(null);
		super.setOpaque(true);
		super.setForeground(this.white);
	}
}
