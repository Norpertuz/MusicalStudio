import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class customTextfield extends JTextField{
	public int borderSize = 3;
	public customTextfield() {
		super.setForeground(Color.decode("#EE2B47"));
		super.setBackground(null);
		super.setBorder(BorderFactory.createMatteBorder(this.borderSize,
				this.borderSize,
				this.borderSize,
				this.borderSize,
				Color.decode("#ffffff"))
				);
		super.setBorder(BorderFactory.createCompoundBorder(
				super.getBorder(), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10))
				);
	}
}
