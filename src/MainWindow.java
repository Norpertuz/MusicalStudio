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



public class MainWindow {
	
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
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(1000, 750);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(Color.BLUE);
		navigationPanel.setBounds(0, 0, 80, 728);
		frame.getContentPane().add(navigationPanel);
		navigationPanel.setLayout(null);
		
		JButton homeButton = new JButton("home");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		homeButton.setBounds(0, 164, 85, 29);
		navigationPanel.add(homeButton);
		
		JButton favButton = new JButton("playlists");
		favButton.setBounds(9, 218, 85, 29);
		navigationPanel.add(favButton);
		
		JButton shopButton = new JButton("shop");
		shopButton.setBounds(9, 257, 85, 29);
		navigationPanel.add(shopButton);
		
		JButton settingsButton = new JButton("settings");
		settingsButton.setBounds(9, 409, 85, 29);
		navigationPanel.add(settingsButton);
		
		JButton exitButton = new JButton("exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		exitButton.setBounds(9, 472, 85, 29);
		navigationPanel.add(exitButton);
		
		JButton darkmodeButton = new JButton("dark");
		darkmodeButton.setBounds(9, 298, 85, 29);
		navigationPanel.add(darkmodeButton);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.WHITE);
		topPanel.setBounds(80, 0, 920, 80);
		frame.getContentPane().add(topPanel);
		topPanel.setLayout(null);	
		
		JButton delButton = new JButton("Panel Administratora");
		delButton.setBounds(327, 28, 167, 29);
		topPanel.add(delButton);
		
		JButton listButton = new JButton("Users");
		listButton.setBounds(518, 28, 84, 29);
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
		
		czy_admin.setBounds(651, 55, 123, 14);
		topPanel.add(czy_admin);
		
		listPanel = new JPanel();
		listPanel.setBackground(Color.WHITE);
		listPanel.setBounds(90, 90, 608, 628);
		frame.getContentPane().add(listPanel);
		listPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 15, 579, 61);
		listPanel.add(panel);
		panel.setLayout(null);
		
		JLabel PlaylistHeading = new JLabel("PLAYLIST");
		PlaylistHeading.setBounds(0, 0, 89, 25);
		PlaylistHeading.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(PlaylistHeading);
		
		JPanel headingLine = new JPanel();
		headingLine.setBackground(Color.BLUE);
		headingLine.setBounds(0, 30, 48, 4);
		panel.add(headingLine);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setBounds(710, 148, 280, 570);
		frame.getContentPane().add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel albumImage = new JLabel("avatar");
		albumImage.setOpaque(true);
		albumImage.setBackground(Color.ORANGE);
		albumImage.setBounds(15, 70, 250, 250);
		infoPanel.add(albumImage);
		
		JLabel albumTitle = new JLabel("BELLA CIAO");
		albumTitle.setBounds(15, 335, 250, 16);
		infoPanel.add(albumTitle);
		
		JLabel albumAuthor = new JLabel("Sergio y Andres");
		albumAuthor.setForeground(Color.BLUE);
		albumAuthor.setBounds(15, 355, 250, 16);
		infoPanel.add(albumAuthor);
		
		JLabel albumAlbum = new JLabel("Album:");
		albumAlbum.setBounds(15, 395, 50, 16);
		infoPanel.add(albumAlbum);
		
		JLabel albumDuration = new JLabel("Duration:");
		albumDuration.setBounds(15, 415, 59, 16);
		infoPanel.add(albumDuration);
		
		JLabel albumMusicGenre = new JLabel("Music genre:");
		albumMusicGenre.setBounds(15, 435, 84, 16);
		infoPanel.add(albumMusicGenre);
		
		JLabel albumReleaseDate = new JLabel("Release date:");
		albumReleaseDate.setBounds(15, 455, 84, 16);
		infoPanel.add(albumReleaseDate);
		
		JLabel albumDescription = new JLabel("Description:");
		albumDescription.setBounds(15, 475, 84, 16);
		infoPanel.add(albumDescription);
		
		JLabel dataAlbum = new JLabel("La Casa de Papel - Soundtrack");
		dataAlbum.setForeground(Color.LIGHT_GRAY);
		dataAlbum.setBounds(68, 395, 198, 16);
		infoPanel.add(dataAlbum);
		
		JLabel dataTime = new JLabel("4:25");
		dataTime.setForeground(Color.LIGHT_GRAY);
		dataTime.setBounds(80, 415, 185, 16);
		infoPanel.add(dataTime);
		
		JLabel dataMusicGenre = new JLabel("Pop");
		dataMusicGenre.setForeground(Color.LIGHT_GRAY);
		dataMusicGenre.setBounds(102, 435, 164, 16);
		infoPanel.add(dataMusicGenre);
		
		JLabel dataReleaseDate = new JLabel("01 January 2018");
		dataReleaseDate.setForeground(Color.LIGHT_GRAY);
		dataReleaseDate.setBounds(102, 455, 164, 16);
		infoPanel.add(dataReleaseDate);
		
		JTextArea dataDescription = new JTextArea();
		dataDescription.setForeground(Color.LIGHT_GRAY);
		dataDescription.setWrapStyleWord(true);
		dataDescription.setLineWrap(true);
		dataDescription.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ...");
		dataDescription.setEditable(false);
		dataDescription.setBounds(15, 495, 250, 69);
		infoPanel.add(dataDescription);
		
		JLabel label = new JLabel("PLAYLIST");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label.setBounds(15, 10, 89, 25);
		infoPanel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(15, 40, 48, 4);
		infoPanel.add(panel_1);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(Color.WHITE);
		searchPanel.setBounds(710, 90, 280, 46);
		frame.getContentPane().add(searchPanel);
		searchPanel.setLayout(null);
		
		searchBar = new JTextField();
		searchBar.setBorder(null);
		searchBar.setForeground(Color.LIGHT_GRAY);
		searchBar.setCaretColor(Color.BLUE);
		searchBar.setBounds(44, 0, 236, 46);
		searchBar.setText("Search");
		searchPanel.add(searchBar);
		searchBar.setColumns(10);
	}
}
