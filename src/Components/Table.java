package Components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;

@SuppressWarnings("serial")
public class Table extends JTable{	
	
	public Table() {
		this.setBackground(Color.RED); //temp
		this.setOpaque(false);
		this.setSelectionBackground(Color.GREEN);
		this.setShowGrid(false);
		this.setForeground(Color.WHITE);
		this.rowHeight = 50;
		this.setIntercellSpacing(new Dimension(0, 0));
		this.setRowMargin(12);
		this.setSelectionMode(0);
		this.setDefaultRenderer(Object.class, new CellRenderer());
		
	}
	
}
