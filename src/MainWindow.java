import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;



public class MainWindow {
	int posX=0,posY=0;
	private JFrame frame;
	private JTextField searchBar;
	private JPanel listPanel;
	public static void main1(String fullname,int admin) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zmienne_globalne.is_admin1= admin;
					Zmienne_globalne.fullname1 = fullname;
					//JOptionPane.showMessageDialog(null, Zmienne_globalne.fullname1);
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		
		initialize();
	}

	private void initialize() {
		
		//JOptionPane.showMessageDialog(null, Zmienne_globalne.fullname1);
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(1000, 780);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel DragBar = new JLabel("");
		DragBar.setBounds(0, 0, 954, 30);
		frame.getContentPane().add(DragBar);
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
				frame.setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
			}
		});
		DragBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(Color.BLUE);
		navigationPanel.setBounds(0, 0, 80, 780);
		frame.getContentPane().add(navigationPanel);
		navigationPanel.setLayout(null);
		
		JLabel Exit = new JLabel("");
		Exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] errorSoon = new String[1];
				frame.dispose();
				JOptionPane.showMessageDialog(null, "Wylogowano!");
				Login nw = new Login();
				Login.main(errorSoon);
			}
		});
		Exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Exit.setHorizontalAlignment(SwingConstants.CENTER);
		Exit.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/exit.png")));
		Exit.setBounds(0, 690, 80, 55);
		navigationPanel.add(Exit);
		
		JLabel Settings = new JLabel("");
		Settings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Settings.setHorizontalAlignment(SwingConstants.CENTER);
		Settings.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/settings.png")));
		Settings.setBounds(0, 630, 80, 55);
		navigationPanel.add(Settings);
		
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
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.WHITE);
		topPanel.setBounds(80, 0, 920, 110);
		frame.getContentPane().add(topPanel);
		topPanel.setLayout(null);	
		
		
		if(Zmienne_globalne.is_admin1==1) {
		JButton delButton = new JButton("Panel Administratora");
		delButton.setBounds(327, 58, 167, 29);
		topPanel.add(delButton);
		}
		JButton listButton = new JButton("Users");
		listButton.setBounds(518, 58, 84, 29);
		topPanel.add(listButton);
		
		JLabel textArea = new JLabel();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setBounds(651, 28, 191, 23);
		topPanel.add(textArea);
		textArea.setText(Zmienne_globalne.fullname1);
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				//okno z danymi uzytkownika
				
				user_edit nw = new user_edit();
				user_edit.okno_edycji(Zmienne_globalne.fullname1,Zmienne_globalne.is_admin1);
				
				
			}
		});
		textArea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel czy_admin = new JLabel("New label");
		if(Zmienne_globalne.is_admin1==1) {
			czy_admin.setText("Administrator");
			czy_admin.setForeground(Color.RED);
		}else {
			czy_admin.setText("Standard user");
			czy_admin.setForeground(Color.GRAY);
		}
		
		czy_admin.setBounds(651, 85, 123, 14);
		topPanel.add(czy_admin);
		
		JLabel close = new JLabel("");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0); 
			}
		});
		close.setIcon(new ImageIcon(MainWindow.class.getResource("/assets/closeIcon.png")));
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.setBounds(874, 0, 46, 30);
		topPanel.add(close);
		
		Heading htest = new Heading("Tekst");
		htest.setBounds(134, 28, 212, 61);
		topPanel.add(htest);
		
		listPanel = new JPanel();
		listPanel.setBackground(Color.WHITE);
		listPanel.setBounds(90, 120, 608, 660);
		frame.getContentPane().add(listPanel);
		listPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 45, 579, 61);
		listPanel.add(panel);
		panel.setLayout(null);
		
		JLabel PlaylistHeading = new JLabel("PLAYLIST");
		PlaylistHeading.setBounds(0, 0, 108, 25);
		PlaylistHeading.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(PlaylistHeading);
		
		JPanel headingLine = new JPanel();
		headingLine.setBackground(Color.BLUE);
		headingLine.setBounds(0, 30, 48, 4);
		panel.add(headingLine);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setBounds(710, 148, 280, 632);
		frame.getContentPane().add(infoPanel);
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
		
		JLabel label = new JLabel("PLAYLIST");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label.setBounds(15, 40, 110, 25);
		infoPanel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(15, 70, 48, 4);
		infoPanel.add(panel_1);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(Color.WHITE);
		searchPanel.setBounds(710, 120, 280, 46);
		frame.getContentPane().add(searchPanel);
		searchPanel.setLayout(null);
		
		searchBar = new JTextField();
		searchBar.setBorder(null);
		searchBar.setForeground(Color.LIGHT_GRAY);
		searchBar.setCaretColor(Color.BLUE);
		searchBar.setBounds(44, 30, 236, 46);
		searchBar.setText("Search");
		searchPanel.add(searchBar);
		searchBar.setColumns(10);
	}
}
