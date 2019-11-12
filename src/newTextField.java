import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class newTextField extends JPanel {
	customTextfield field = new customTextfield();
	JLabel label = new JLabel();
	
	public newTextField(String text) {
		// label
		label.setText(text);
		label.setForeground(Color.orange);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(0, 0, 287, 20);
		super.add(label);
		// textfield
		field.setHorizontalAlignment(SwingConstants.LEFT);
		field.setColumns(10);
		field.setBounds(0, 25, 300, 44);
		super.add(field);
		// focus
		field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				label.setForeground(Color.cyan);
			}
			@Override
			public void focusLost(FocusEvent e) {
				label.setForeground(Color.blue);
			}
		});
		// container
		super.setBounds(38, 117, field.getWidth(), field.getHeight()+label.getHeight()+5);
		super.setVisible(true);
		super.setLayout(null);
		super.setOpaque(false);
	}
}
