package Components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.Border;
import Theme.Colors;

@SuppressWarnings("serial")
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

	@Override
	public void setText(String text) {
		super.setText(text);
	}
	
	@Override
	public void setBackground(Color background) {
		super.setBackground(background);
	}
	
	public Button() {
		this.setForeground(Colors.DTText);
		this.setCursor(new Cursor (Cursor.HAND_CURSOR));
	}
}