import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		this.setCursor(new Cursor (Cursor.HAND_CURSOR));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				e.getComponent().setBackground(Color.BLUE);
			}
		});
	}
}