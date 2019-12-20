import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Components.Heading;
import Theme.Colors;
import java.sql.*;

public class list_users extends JFrame {

	private JPanel contentPane;
	int posX=0,posY=0;
	private JTable table;
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
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 550);
		contentPane = new JPanel();
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
		
		JLabel Users_Label = new JLabel("Lista Uzytkownikow");
		Users_Label.setBounds(10, 40, 165, 35);
		Users_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(Users_Label);
		
		JLabel add_users = new JLabel("  Dodaj uzytkownika");
		add_users.setBounds(185, 40, 155, 35);
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
		scrollPane.setBounds(10, 100, 330, 439);
		contentPane.add(scrollPane);
		
		table = new JTable();
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
		//table.getColumn(1).setPreferredWidth(15);    
		//table.getColumn(2).setPreferredWidth(400);
		scrollPane.setViewportView(table);
		
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		TableColumnModel colModel=table.getColumnModel();
		//colModel.getColumn(0).setPreferredWidth(15);    
		//colModel.getColumn(1).setPreferredWidth(15);  
		//colModel.getColumn(2).setPreferredWidth(15);  
		//colModel.getColumn(3).setPreferredWidth(20);
		
		//srodkowanie kolumny isadmin:
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		//table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		//table.setRowHeight(0, 1);
		//table.setRowSelectionAllowed(true);
		
		
		
	// pobieranie do tabeli
		
		ArrayList<user> list = getUserList();
	       //DefaultTableModel model = (DefaultTableModel)jTable_Display_Users.getModel();
	       Object[] row = new Object[5];
	       for(int i = 0; i < list.size(); i++)
	       {
	           row[0] = list.get(i).get_Nickname();
	           if(list.get(i).get_IsAdmin()==1)
	           row[1] = "Administrator"; 
	           else
	           row[1] = "User"; 
	           
	          model.addRow(row);
	       }
		
		
		
		
		
		
	}
}
