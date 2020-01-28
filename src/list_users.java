import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Components.Heading;
import Components.Table;
import Theme.Colors;
import Theme.Theme;

import java.sql.*;

public class list_users extends JFrame {
	
//	static ResourceBundle res= ResourceBundle.getBundle("lang_PL");
	

	private Theme contentPane;
	int posX=0,posY=0;
	static ResourceBundle res;
	private Table table;
	/**
	 * Launch the application.
	 */
	

	
	 public ArrayList<user> getUserList()
	   {
	       ArrayList<user> usersList = new ArrayList<user>();
	       
	     
	       try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
				Statement stmt=con.createStatement();
				String sql="Select * from users";
				ResultSet rs=stmt.executeQuery(sql);
				user user1;
		           while(rs.next())
		           {
		               user1 = new user(rs.getString("nickname"),rs.getString("fullname"),rs.getString("password"),rs.getString("email"),rs.getInt("isAdmin"));
		               usersList.add(user1);
		           }
				
				con.close();
			} 
			catch(Exception e){System.out.print(e);}
	       
	       
	       
	       
	       
	       return usersList;
	   }
	
	
	
	
	
	
	
	
	
	
	public static void main22(boolean test) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					list_users frame = new list_users();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public list_users() {
		
		if(GlobalVariables.jezyk==1)res = ResourceBundle.getBundle("lang_PL");
		if(GlobalVariables.jezyk==0)res = ResourceBundle.getBundle("lang_EN");
		
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 550);
		contentPane = new Theme();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel DragBar = new JLabel("");
		DragBar.setBounds(0, 0, 304, 30);
		DragBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DragBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX=e.getX();
                posY=e.getY();
			}
		});
		DragBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(DragBar);
		
		JLabel Close = new JLabel("");
		Close.setBounds(304, 0, 46, 30);
		Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		Close.setHorizontalTextPosition(SwingConstants.CENTER);
		Close.setHorizontalAlignment(SwingConstants.CENTER);
		Close.setIcon(new ImageIcon(list_users.class.getResource("/assets/closeIcon.png")));
		Close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(Close);
		
		JLabel add_users = new JLabel(" " + res.getString("addd_user"));
		add_users.setForeground(Color.WHITE);
		add_users.setBounds(10, 86, 169, 35);
		add_users.setIcon(new ImageIcon(list_users.class.getResource("/assets/person_add_light.png")));
		contentPane.add(add_users);
		add_users.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add_users.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Register.main1(true);
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 137, 330, 402);
		contentPane.add(scrollPane);
		scrollPane.setOpaque(false);
		
		
		
		
		table = new Table();
		table.setAutoCreateRowSorter(false);
		table.setDragEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		table.setEnabled(true);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setReorderingAllowed(false);
		
		String[] user = {"Nickname","Admin?"};
		String[] dane = {"",""};
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(dane);
		model.fireTableDataChanged();
		//table.getColumn(1).setPreferredWidth(15);    
		//table.getColumn(2).setPreferredWidth(400);
		scrollPane.setViewportView(table);
		
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
	    
	    JLabel useredit = new JLabel("  " + res.getString("edit"));
	    useredit.setForeground(Color.WHITE);
	    useredit.setBounds(189, 86, 161, 35);
	    contentPane.add(useredit);
	    useredit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    useredit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(table.getSelectedRow() != -1) {UserEdit.okno_edycji1(table.getValueAt(table.getSelectedRow(), 0).toString(),1);}
				else {JOptionPane.showMessageDialog(null, res.getString("n_user_select"));}
				
				
			}
		});
	    
	    
	    
	    
//		TableColumnModel colModel=table.getColumnModel();
		//colModel.getColumn(0).setPreferredWidth(15);    
		//colModel.getColumn(1).setPreferredWidth(15);  
		//colModel.getColumn(2).setPreferredWidth(15);  
		//colModel.getColumn(3).setPreferredWidth(20);
		
//		//srodkowanie kolumny isadmin:
//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
//		//table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
//		//table.setRowHeight(0, 1);
//		//table.setRowSelectionAllowed(true);
		
		
		
	// pobieranie do tabeli
		
		ArrayList<user> list = getUserList();
	       //DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
	       Object[] row = new Object[5];
	       for(int i = 0; i < list.size(); i++)
	       {
	           row[0] = list.get(i).get_Fullname();
	           if(list.get(i).get_IsAdmin()==1) {
	        	   row[1] = "Administrator"; 
	           }
	           else
	           row[1] = "User"; 
	           
	          model.addRow(row);
	       }
		
	   table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	   scrollPane.setBorder(BorderFactory.createEmptyBorder());
	   scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
	   scrollPane.getViewport().setOpaque(false);
	   contentPane.setBackground(Colors.DTBackground);
	   
	   String listUsers = res.getString("list_users");
	   Heading panel = new Heading(listUsers, Colors.DTPurple);
	   panel.setBounds(10, 42, 143, 40);
	   contentPane.add(panel);
	   
	   JLabel lblNewLabel = new JLabel(res.getString("n_user_select"));
	   lblNewLabel.setIcon(new ImageIcon(list_users.class.getResource("/assets/upWhite.png")));
	   lblNewLabel.setForeground(Color.WHITE);
	   lblNewLabel.setBounds(189, 34, 151, 48);
	   lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(table.getSelectedRow() != -1) {
					String fullname111;
					 fullname111=table.getValueAt(table.getSelectedRow(), 0).toString();
					 //JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), 1).toString());
					
					
					
					
					  try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
							Statement stmt=con.createStatement();
							String sql;
							
							if(table.getValueAt(table.getSelectedRow(), 1).toString().equals("Administrator")) {
								//fullname111=table.getValueAt(table.getSelectedRow(), 0).toString();
							    sql="update users set isAdmin='0' WHERE fullname='"+fullname111+"'";
							    JOptionPane.showMessageDialog(null, res.getString("admin_add"));
								}
							else { 
								//fullname111=table.getValueAt(table.getSelectedRow(), 0).toString();
								sql="update users set isAdmin='1' WHERE fullname='"+fullname111+"'";
							    JOptionPane.showMessageDialog(null, res.getString("admin_remove"));

								
								}
							stmt.executeUpdate(sql);
							
							
						
				
						
							stmt.close();
							con.close();
							dispose();
							list_users.main22(true);
						} 
						catch(Exception e){System.out.print(e);}
				}
				else {JOptionPane.showMessageDialog(null, res.getString("n_user_select"));}
				
				
			}
		});
	   
	   
	   
	   contentPane.add(lblNewLabel);
	   contentPane.setDarkTheme(this, GlobalVariables.isDark);
	   
	   if(GlobalVariables.is_admin1==0) {lblNewLabel.setVisible(false);add_users.setVisible(false);useredit.setVisible(false);}
		
	   
	}
}
