package Components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

import Theme.Colors;

@SuppressWarnings("serial")
public class Table extends JTable{	
	public MatteBorder ERR = BorderFactory.createMatteBorder(3,3,3,3, Colors.DTPurple);
	
	public Table() {
		this.setBackground(Colors.DTPanel); //temp
		this.setOpaque(false);
		this.setSelectionBackground(Colors.DTisSelected);
		this.setShowGrid(false);
		this.setForeground(Color.WHITE);
		this.rowHeight = 65;
		this.setIntercellSpacing(new Dimension(0, 0));
		this.setRowMargin(12);
		this.setSelectionMode(0);
		this.setDefaultRenderer(Object.class, new CellRenderer());
		this.setBorder(null);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); //temp
		//this.setTableHeader(null);
//		
//		this.getTableHeader().setDefaultRenderer(new headerRenderer());
	}
	
}
