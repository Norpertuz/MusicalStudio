package Components;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

import Theme.Colors;

@SuppressWarnings("serial")
public class CellRenderer extends DefaultTableCellRenderer {
	public MatteBorder ERR = BorderFactory.createMatteBorder(3,0,3,0, Colors.DTPurple);

	@Override
	public Color getForeground() {
		if (getText().startsWith("Administrator")) {
			return Color.decode("#EE2B47");
		} else if (getText().startsWith("User")) {
			return Colors.LTGray;
		}
		return super.getForeground();
	}
	
	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        setBorder(noFocusBorder);
//    	if(hasFocus) {
//    		setBorder(ERR);
//    	}
        setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 10)));
        return this;
	}
    
}
