package Components;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class headerRenderer extends JLabel implements TableCellRenderer{
	
	public headerRenderer() {
		this.setBackground(null);
		this.setOpaque(false);
		this.setBorder(null);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setText(value.toString());
		setBackground(Color.BLUE);
		return this;
	}
//	
//	  private final Border b = BorderFactory.createCompoundBorder(
//		      BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK),
//		      BorderFactory.createEmptyBorder(2,2,1,2));
//		  private final Color alphaZero = new Color(0, true);
//		  @Override public Component getTableCellRendererComponent(
//		        JTable table, Object value, boolean isSelected,
//		        boolean hasFocus, int row, int column) {
//		    this.setText(value!=null?value.toString():"");
//		    this.setHorizontalAlignment(JLabel.CENTER);
//		    this.setOpaque(false);
//		    this.setBackground(alphaZero);
//		    this.setForeground(Color.BLACK);
//		    this.setBorder(b);
//		    return this;
//		  }
	
}
