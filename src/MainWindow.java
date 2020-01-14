import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.RowFilter;
import javax.swing.event.*;
import java.awt.Color;

import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


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
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

import javax.swing.BorderFactory;
import javax.swing.FocusManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Components.Heading;
import Components.SearchField;
import Components.Table;
import Components.headerRenderer;
import Theme.Colors;
import java.sql.*;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel listPanel;
	private SearchField searchBar;
	int posX=0,posY=0;
	private Table table;
	
	// get a list of albums from mysql database
	
	   public ArrayList<album> getAlbumsList()
	   {
	       ArrayList<album> albumsList = new ArrayList<album>();
	       
	     
	       try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
				Statement stmt=con.createStatement();
				String sql="Select * from utowory";
				ResultSet rs=stmt.executeQuery(sql);
				album album1;
		           while(rs.next())
		           {
		               album1 = new album(rs.getString("Nazwa_utworu"),rs.getString("Nazwa_albumu"),rs.getString("Data"),rs.getString("Autor"),rs.getString("Gatunek"),rs.getString("Opis"),rs.getString("Image"));
		               albumsList.add(album1);
		           }
				
				con.close();
			} 
			catch(Exception e){System.out.print(e);}
	       
	       
	       
	       
	       
	       return albumsList;
	   }
	   
	   // Display Data In JTable
	   /*
	   public void Show_Users_In_JTable()
	   {
	       
	    }
	*/
	
	
	
	public static void main1(String fullname,int admin) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GlobalVariables.is_admin1= admin;
					GlobalVariables.fullname1 = fullname;
					
					//JOptionPane.showMessageDialog(null, Zmienne_globalne.fullname1);
					
					
	
					
					MainWindow window = new MainWindow();
					window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1000, 787);
		contentPane = new JPanel();
		contentPane.setBackground(Colors.DTBackground);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel DragBar = new JLabel("");
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
		DragBar.setBounds(0, 0, 1000, 30);
		contentPane.add(DragBar);
		
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(Colors.DTPurple);
		navigationPanel.setBounds(0, 0, 80, 810);
		getContentPane().add(navigationPanel);
		navigationPanel.setLayout(null);
		
		JLabel Home = new JLabel("");
		Home.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/home.png")));
		Home.setHorizontalAlignment(SwingConstants.CENTER);
		Home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Home.setBounds(0, 130, 80, 55);
		navigationPanel.add(Home);
		
		JLabel playlist = new JLabel("");
		playlist.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/playlist.png")));
		playlist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		playlist.setHorizontalAlignment(SwingConstants.CENTER);
		playlist.setBounds(0, 190, 80, 55);
		navigationPanel.add(playlist);
		
		JLabel cart = new JLabel("");
		cart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cart.setHorizontalAlignment(SwingConstants.CENTER);
		cart.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/shopping_cart.png")));
		cart.setBounds(0, 250, 80, 55);
		navigationPanel.add(cart);
		
		JLabel invert_colors = new JLabel("");
		invert_colors.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/invert_colors.png")));
		invert_colors.setHorizontalAlignment(SwingConstants.CENTER);
		invert_colors.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		invert_colors.setBounds(0, 310, 80, 55);
		navigationPanel.add(invert_colors);

		JLabel Settings = new JLabel("");
		Settings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Settings.setHorizontalAlignment(SwingConstants.CENTER);
		Settings.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/settings.png")));
		Settings.setBounds(0, 601, 80, 55);
		navigationPanel.add(Settings);
		
		JLabel LogOut = new JLabel("");
		LogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] errorSoon = new String[1];
				final Frame[] frames = Frame.getFrames();
				if (frames != null)
				    for (final Frame f : frames)
				    {
				        f.dispose();
				    }
				JOptionPane.showMessageDialog(null, "Wylogowano!");
				Login nw = new Login();
				Login.main(errorSoon);
			}
		});
		LogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LogOut.setHorizontalAlignment(SwingConstants.CENTER);
		LogOut.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/exit.png")));
		LogOut.setBounds(0, 661, 80, 55);
		navigationPanel.add(LogOut);
		
		JLabel close = new JLabel("");
		close.setBounds(0, 721, 80, 55);
		navigationPanel.add(close);
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0); 
			}
		});
		close.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/off.png")));
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Colors.DTPanel);
		topPanel.setBounds(80, 0, 920, 90);
		contentPane.add(topPanel);
	
		topPanel.setLayout(null);
		
		JLabel textArea = new JLabel();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setBounds(706, 32, 191, 23);
		topPanel.add(textArea);
		textArea.setText(GlobalVariables.fullname1);
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				//okno z danymi uzytkownika
				
				//UserEdit nw = new UserEdit();
				UserEdit.okno_edycji1(GlobalVariables.fullname1,GlobalVariables.is_admin1);
				
				
			}
			
		});
		textArea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textArea.setForeground(Colors.DTText);
		JLabel czy_admin = new JLabel("New label");
		if(GlobalVariables.is_admin1==1) {
			czy_admin.setText("Administrator");
			czy_admin.setForeground(Color.RED);
		}else {
			czy_admin.setText("Standard user");
			czy_admin.setForeground(Color.BLUE);
		}
		
		czy_admin.setBounds(706, 56, 123, 14);
		topPanel.add(czy_admin);
		
		JLabel user_list = new JLabel("Lista Uzytkownikow");
		user_list.setForeground(Colors.DTText);
		user_list.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/osoby.png")));
		user_list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		user_list.setBounds(320, 32, 150, 30);
		topPanel.add(user_list);
		user_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				list_users.main22(true);
			}
		});
		
		
		
		JLabel albumedit = new JLabel("edycja");
		albumedit.setForeground(Colors.DTText);
		albumedit.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/Panel_admin.png")));
		albumedit.setBounds(160, 32, 150, 30);
		albumedit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		albumedit.setVisible(false);
		topPanel.add(albumedit);
		if(GlobalVariables.is_admin1==1) {
			albumedit.setText("Edytuj/Usun Utwor");
			albumedit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			
				if(table.getSelectedRow() != -1) {Add_edit.edit_song(table.getValueAt(table.getSelectedRow(), 0).toString(),GlobalVariables.is_admin1);}
				else {JOptionPane.showMessageDialog(null, "Nie wybrano Utworu");}
				
			}
		});

			albumedit.setVisible(true);
		}
		
		
		JLabel admin_panel = new JLabel("dodawnie");
		admin_panel.setForeground(Colors.DTText);
		admin_panel.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/Panel_admin.png")));
		admin_panel.setBounds(31, 32, 123, 30);
		admin_panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		admin_panel.setVisible(false);
		topPanel.add(admin_panel);
		if(GlobalVariables.is_admin1==1) {
		admin_panel.setText("Dodaj Utwor");
		admin_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//Add_add nw = new Add_add();
				Add_add.add_song(true);
			}
		});
//		topPanel.add(admin_panel);
		admin_panel.setVisible(true);
		}
		listPanel = new JPanel();
		listPanel.setBackground(Colors.DTPanel);
		listPanel.setBounds(92, 102, 608, 673);
		getContentPane().add(listPanel);
		listPanel.setLayout(null);
		listPanel.setBorder(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setBounds(10, 88, 576, 579);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		listPanel.add(scrollPane);
		listPanel.setBorder(null);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(BorderFactory.createEmptyBorder());
		table = new Table();
		table.setFocusTraversalKeysEnabled(false);
		table.setBorder(null);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(false);
		table.setDragEnabled(false);
	   // table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		//table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		table.setEnabled(true);
		String[] ListTop = {"Nazwa Utworu","Album","Autor","Data Dodania","Gatunek"};
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		//model.setDataVector(data,ListTop);
		model.setColumnIdentifiers(ListTop);
		scrollPane.setViewportView(table);
		
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setForeground(Color.RED);
		
		//srodkowanie kolumn:
//				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
//				//table.setDefaultRenderer(String.class, centerRenderer);
//				table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
//				table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
//				table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
//				table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
//				table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
				//table.setRowHeight(0, 1);
				//table.setRowHeight(0, 1);
				//table.getRowModel().getRow(1);
				//table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		// pobieranie do tabeli
		
		ArrayList<album> list = getAlbumsList();
	       Object[] row = new Object[5];
	       for(int i = 0; i < list.size(); i++)
	       {
	    	   
	           row[0] = list.get(i).get_nazwa_utworu();
	           row[1] = list.get(i).get_nazwa_albumu();
	           row[2] = list.get(i).get_Autor();
	           row[3] = list.get(i).get_date();
	           row[4] = list.get(i).get_Gatunek(); //blank?
	          model.addRow(row);
	          //table.setRowHeight(i, 30);
	       }
	    String panelHLabel = "Lista Utworow";
		Heading panelH = new Heading(panelHLabel, Colors.DTPurple);
		panelH.setBounds(27, 27, 163, 38);
		listPanel.add(panelH);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Colors.DTPanel);
		infoPanel.setBounds(712, 160, 280, 615);
		getContentPane().add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel albumImage = new JLabel("");
		albumImage.setOpaque(true);
		albumImage.setBackground(Colors.DTPanel);
		albumImage.setBounds(15, 100, 250, 250);
		infoPanel.add(albumImage);
		
		JLabel albumTitle = new JLabel("BELLA CIAO");
		albumTitle.setForeground(Colors.DTText);
		albumTitle.setBounds(15, 365, 250, 16);
		//albumTitle.setText((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
		infoPanel.add(albumTitle);
		
		JLabel albumAuthor = new JLabel("Sergio y Andres");
		albumAuthor.setForeground(Colors.DTPurple);
		albumAuthor.setBounds(15, 385, 250, 16);
		infoPanel.add(albumAuthor);
		
		JLabel albumAlbum = new JLabel("Album:");
		albumAlbum.setForeground(Colors.DTPurple);
		albumAlbum.setBounds(15, 433, 50, 16);
		infoPanel.add(albumAlbum);
		
	
		JLabel albumMusicGenre = new JLabel("Music genre:");
		albumMusicGenre.setForeground(Colors.DTPurple);
		albumMusicGenre.setBounds(15, 453, 84, 16);
		infoPanel.add(albumMusicGenre);
		
		JLabel albumReleaseDate = new JLabel("Release date:");
		albumReleaseDate.setForeground(Colors.DTPurple);
		albumReleaseDate.setBounds(15, 473, 84, 16);
		infoPanel.add(albumReleaseDate);
		
		JLabel albumDescription = new JLabel("Description:");
		albumDescription.setForeground(Colors.DTPurple);
		albumDescription.setBounds(15, 493, 84, 16);
		infoPanel.add(albumDescription);
		
		JLabel dataAlbum = new JLabel("La Casa de Papel - Soundtrack");
		dataAlbum.setForeground(Colors.DTText);
		dataAlbum.setBounds(68, 433, 198, 16);
		infoPanel.add(dataAlbum);
		
		
		JLabel dataMusicGenre = new JLabel("Pop");
		dataMusicGenre.setForeground(Colors.DTText);
		dataMusicGenre.setBounds(102, 453, 164, 16);
		infoPanel.add(dataMusicGenre);
		
		JLabel dataReleaseDate = new JLabel("01 January 2018");
		dataReleaseDate.setForeground(Colors.DTText);
		dataReleaseDate.setBounds(102, 473, 164, 16);
		infoPanel.add(dataReleaseDate);
		
		JTextArea dataDescription = new JTextArea();
		dataDescription.setForeground(Colors.DTText);
		dataDescription.setWrapStyleWord(true);
		dataDescription.setLineWrap(true);
		dataDescription.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ...");
		dataDescription.setEditable(false);
		dataDescription.setBounds(15, 513, 250, 69);
		infoPanel.add(dataDescription);
		dataDescription.setOpaque(false);
		Heading panelh2 = new Heading("Something", Colors.DTPurple);
		panelh2.setBounds(32, 43, 145, 38);
		infoPanel.add(panelh2);
	       
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            if(table.getSelectedRow() != -1) {
	            // do some actions here, for example
	            // print first column value from selected row
	            	albumTitle.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
	            	albumAuthor.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	            	dataAlbum.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
	            	dataMusicGenre.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
	            	dataReleaseDate.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
	            	dataDescription.setText(list.get(table.getSelectedRow()).get_Opis());
	            	
	            	
	            	//System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
	            }
	        }
	    });
	
		
		
		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel()); 
		table.setRowSorter(rowSorter);
		
		searchBar = new SearchField();
		searchBar.setBounds(712, 102, 280, 46);
		contentPane.add(searchBar);
		searchBar.setBackground(Colors.DTPanel);
		searchBar.setBorder(null);
		searchBar.setForeground(Colors.DTText);
		searchBar.setCaretColor(Colors.DTPurple);		
		searchBar.setColumns(10);
		searchBar.setForeground(Colors.DTPlaceholder);
		
		
		scrollPane.setBorder(BorderFactory.createEmptyBorder()); // blue border
		searchBar.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		searchBar.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				String findText = searchBar.getText();
				if(findText.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter(findText,0,1));
				}}
			@Override
			public void removeUpdate(DocumentEvent e) {
				String findText = searchBar.getText();
				if(findText.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter(findText,0,1));
				}}
			@Override
			public void changedUpdate(DocumentEvent e) {
				throw new UnsupportedOperationException("Lorem ipsum");
			}});
		searchBar.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				e.getComponent().setForeground(Colors.DTText);
			}
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				e.getComponent().setForeground(Colors.DTPlaceholder);
			}
		});
		
		// jtable - header
		table.getTableHeader().setBackground(Colors.DTPanel);
		table.getTableHeader().setFont(new Font("sans-serif", Font.PLAIN, 10));
		table.getTableHeader().setForeground(Colors.DTPlaceholder);
		table.getTableHeader().setEnabled(false);
		UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0));
		table.getTableHeader().setPreferredSize(new Dimension(25, 25));	
		
		
		// theme
		GlobalVariables.isDark = true;
		invert_colors.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (GlobalVariables.isDark == false) {
					contentPane.setBackground(Colors.DTBackground);
					navigationPanel.setBackground(Colors.DTPurple);
					topPanel.setBackground(Colors.DTPanel);
					admin_panel.setForeground(Colors.DTText);
					user_list.setForeground(Colors.DTText);
					albumedit.setForeground(Colors.DTText);
					textArea.setForeground(Colors.DTText);
					listPanel.setBackground(Colors.DTPanel);
					panelH.line.setBackground(Colors.DTPurple);
					panelH.label.setForeground(Colors.DTText);
					searchBar.setBackground(Colors.DTPanel);
					table.setForeground(Colors.DTText);
					table.setBackground(Colors.DTPanel);
					table.getTableHeader().setBackground(Colors.DTPanel);
					table.setSelectionBackground(Colors.DTisSelected);
					table.setSelectionForeground(Color.WHITE);
					GlobalVariables.isDark = true;
				} else {
					contentPane.setBackground(Color.decode("#F6F6F6"));
					navigationPanel.setBackground(Colors.LTBlue);
					topPanel.setBackground(Colors.LTBackground);
					admin_panel.setForeground(Color.BLACK);
					user_list.setForeground(Color.BLACK);
					albumedit.setForeground(Color.BLACK);
					textArea.setForeground(Color.BLACK);
					listPanel.setBackground(Colors.LTBackground);
					panelH.line.setBackground(Colors.LTBlue);
					panelH.label.setForeground(Color.BLACK);
					searchBar.setBackground(Colors.LTBackground);
					table.setForeground(Color.BLACK);
					table.setBackground(Colors.LTBackground);
					table.getTableHeader().setBackground(Colors.LTBackground);
					table.setSelectionBackground(Color.decode("#F6F6F6"));
					table.setSelectionForeground(Color.BLACK);
					GlobalVariables.isDark = false;
				}
			}
		});
	}
}
