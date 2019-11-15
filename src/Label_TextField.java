import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Label_TextField extends JPanel {
	JLabel label = new JLabel();
	TextField field = new TextField();
	
	@Override
	public Component add(Component comp) {
		comp.setBounds(this.getX(), this.getY(), this.getSize().width, this.getSize().height);
		return super.add(comp);
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		aFlag = true;
		super.setVisible(aFlag);
	}
	
	
	public Label_TextField(String name, String type) {
		// Container
//		this.getBounds().setSize(this.getSize().width, 70);
		this.setBackground(null);
		this.setOpaque(false);
		// Container - layout
		this.setLayout(new GridBagLayout());
		GridBagConstraints container = new GridBagConstraints();
		container.insets = new Insets(2, 0, 4, 0);
		// Label
		label.setText(name);
		label.setForeground(Colors.inactive);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		container.gridx=0;
		container.gridy=0;
		container.anchor = GridBagConstraints.FIRST_LINE_START;
		this.add(label, container);
		// TextField
		container.gridx=0;
		container.gridy=1;
		container.gridwidth=1;
		container.weightx=1;
		container.fill = GridBagConstraints.HORIZONTAL;
		container.ipady=15;
		container.anchor = GridBagConstraints.LINE_START;
		this.add(field, container);
		// validation
		field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				field.border(field.active, Colors.darkThemeRed);
				label.setForeground(Colors.active);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (type == "default") {
					if(field.getText().length() < 5) {
						field.border(field.err, Colors.err);
						label.setForeground(Colors.err);
						label.setText(name + " is too short");
					} else {
						field.border(field.inactive, Colors.inactive);
						label.setForeground(Colors.inactive);
						label.setText(name);
					}
				}
			}
		});
	}
}
