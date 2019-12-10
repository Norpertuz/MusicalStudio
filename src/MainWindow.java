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

import Components.Heading;
import Theme.Colors;
import java.sql.*;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel listPanel;
	private JTextField searchBar;
	int posX=0,posY=0;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
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
		setSize(1000, 780);
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
		navigationPanel.setBounds(0, 0, 80, 780);
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
		Settings.setBounds(0, 580, 80, 55);
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
		LogOut.setBounds(0, 640, 80, 55);
		navigationPanel.add(LogOut);
		
		JLabel close = new JLabel("");
		close.setBounds(0, 700, 80, 55);
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
		topPanel.setBackground(Color.GRAY);
		topPanel.setBounds(80, 0, 920, 110);
		contentPane.add(topPanel);
	
		topPanel.setLayout(null);
		
		JLabel textArea = new JLabel();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setBounds(651, 58, 191, 23);
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
		
		JLabel czy_admin = new JLabel("New label");
		if(GlobalVariables.is_admin1==1) {
			czy_admin.setText("Administrator");
			czy_admin.setForeground(Color.RED);
		}else {
			czy_admin.setText("Standard user");
			czy_admin.setForeground(Color.BLUE);
		}
		
		czy_admin.setBounds(651, 85, 123, 14);
		topPanel.add(czy_admin);
		
		JLabel nazwa_studia = new JLabel("");
		nazwa_studia.setBounds(0, 22, 123, 48);
		topPanel.add(nazwa_studia);
		
		JLabel user_list = new JLabel("Lista Uzytkownikow");
		user_list.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/osoby.png")));
		user_list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		user_list.setBounds(470, 60, 150, 30);
		topPanel.add(user_list);
		user_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				list_users.main22(true);
			}
		});
		
		
		JLabel admin_panel = new JLabel("new label");
		admin_panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	if(GlobalVariables.is_admin1==1) {
		admin_panel.setText("Panel administratora");
		admin_panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				//Add_add nw = new Add_add();
				Add_add.add_song(true);
			}
		});
		admin_panel.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/Panel_admin.png")));
		admin_panel.setBounds(300, 60, 170, 30);
		topPanel.add(admin_panel);
		}
		listPanel = new JPanel();
		listPanel.setBackground(Color.BLACK);
		listPanel.setBounds(90, 120, 608, 660);
		getContentPane().add(listPanel);
		listPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 576, 549);
		listPanel.add(scrollPane);
		
		table = new JTable();
		
		table.setAutoCreateRowSorter(false);
		table.setDragEnabled(false);
	   // table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		table.setEnabled(false);
		String[] ListTop = {"Nazwa Utworu","Album","Autor","Data Dodania","Gatunek"};
		String[][] data = {{null,null,null,null,null}};
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		model.setDataVector(data,ListTop);
		scrollPane.setViewportView(table);
		
		
		
		//srodkowanie kolumn:
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				//table.setDefaultRenderer(String.class, centerRenderer);
				table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
				table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
				table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
				table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
				table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
				table.setRowHeight(0, 1);
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
	          table.setRowHeight(i+1, 30);
	       }
		
		Heading panelH = new Heading("Lista Utworow", Colors.DTPurple);
		panelH.setBounds(27, 27, 163, 38);
		listPanel.add(panelH);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.BLACK);
		infoPanel.setBounds(710, 165, 280, 615);
		getContentPane().add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel albumImage = new JLabel("avatar");
		albumImage.setOpaque(true);
		albumImage.setBackground(Color.ORANGE);
		albumImage.setBounds(15, 100, 250, 250);
		infoPanel.add(albumImage);
		
		JLabel albumTitle = new JLabel("BELLA CIAO");
		albumTitle.setBounds(15, 365, 250, 16);
		infoPanel.add(albumTitle);
		
		JLabel albumAuthor = new JLabel("Sergio y Andres");
		albumAuthor.setForeground(Color.BLUE);
		albumAuthor.setBounds(15, 385, 250, 16);
		infoPanel.add(albumAuthor);
		
		JLabel albumAlbum = new JLabel("Album:");
		albumAlbum.setBounds(15, 425, 50, 16);
		infoPanel.add(albumAlbum);
		
		JLabel albumDuration = new JLabel("Duration:");
		albumDuration.setBounds(15, 445, 59, 16);
		infoPanel.add(albumDuration);
		
		JLabel albumMusicGenre = new JLabel("Music genre:");
		albumMusicGenre.setBounds(15, 465, 84, 16);
		infoPanel.add(albumMusicGenre);
		
		JLabel albumReleaseDate = new JLabel("Release date:");
		albumReleaseDate.setBounds(15, 485, 84, 16);
		infoPanel.add(albumReleaseDate);
		
		JLabel albumDescription = new JLabel("Description:");
		albumDescription.setBounds(15, 505, 84, 16);
		infoPanel.add(albumDescription);
		
		JLabel dataAlbum = new JLabel("La Casa de Papel - Soundtrack");
		dataAlbum.setForeground(Color.LIGHT_GRAY);
		dataAlbum.setBounds(68, 425, 198, 16);
		infoPanel.add(dataAlbum);
		
		JLabel dataTime = new JLabel("4:25");
		dataTime.setForeground(Color.LIGHT_GRAY);
		dataTime.setBounds(80, 445, 185, 16);
		infoPanel.add(dataTime);
		
		JLabel dataMusicGenre = new JLabel("Pop");
		dataMusicGenre.setForeground(Color.LIGHT_GRAY);
		dataMusicGenre.setBounds(102, 465, 164, 16);
		infoPanel.add(dataMusicGenre);
		
		JLabel dataReleaseDate = new JLabel("01 January 2018");
		dataReleaseDate.setForeground(Color.LIGHT_GRAY);
		dataReleaseDate.setBounds(102, 485, 164, 16);
		infoPanel.add(dataReleaseDate);
		
		JTextArea dataDescription = new JTextArea();
		dataDescription.setForeground(Color.LIGHT_GRAY);
		dataDescription.setWrapStyleWord(true);
		dataDescription.setLineWrap(true);
		dataDescription.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ...");
		dataDescription.setEditable(false);
		dataDescription.setBounds(15, 525, 250, 69);
		infoPanel.add(dataDescription);
		
		Heading panelh2 = new Heading("Something", Colors.DTPurple);
		panelh2.setBounds(32, 43, 145, 38);
		infoPanel.add(panelh2);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(Color.WHITE);
		searchPanel.setBounds(710, 120, 280, 46);
		getContentPane().add(searchPanel);
		searchPanel.setLayout(null);
		
		searchBar = new JTextField();
		searchBar.setBorder(null);
		searchBar.setForeground(Color.LIGHT_GRAY);
		searchBar.setCaretColor(Color.BLUE);
		searchBar.setBounds(0, 0, 280, 46);
		searchBar.setText("Search");
		searchPanel.add(searchBar);
		searchBar.setColumns(10);
		
		
		
	}
}
