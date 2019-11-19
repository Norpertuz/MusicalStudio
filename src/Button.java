import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.Border;

public class Button extends JButton {
	public String ubuntuURL = "assets/fonts/Ubuntu-Regular.ttf";
	
	@Override
	public void setFont(Font Ubuntu) {
		Ubuntu = new Font("Tahoma", Font.BOLD, 12);
		super.setFont(Ubuntu);
	}
	
	@Override
	public void setBorder(Border border) {
		border = null;
		super.setBorder(border);
	}
	
	@Override
	public void setOpaque(boolean isOpaque) {
		isOpaque = true;
		super.setOpaque(isOpaque);
	}
	
	public Button(String text) {
		this.setText(text);
		this.setBackground(Color.GREEN);
		this.setBackground(Color.yellow);
	}
}