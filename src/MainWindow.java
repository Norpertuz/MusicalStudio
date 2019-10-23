import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JTextArea;

public class MainWindow {

	private JFrame frame;
	private JTextField txtSearch;
	private JPanel listPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(1000, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(Color.BLUE);
		navigationPanel.setBounds(0, 0, 80, 678);
		frame.getContentPane().add(navigationPanel);
		navigationPanel.setLayout(null);
		
		JButton homeButton = new JButton("home");
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
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(295, 28, 75, 29);
		topPanel.add(addButton);
		
		JButton delButton = new JButton("Delete");
		delButton.setBounds(392, 28, 75, 29);
		topPanel.add(delButton);
		
		JButton listButton = new JButton("Users");
		listButton.setBounds(518, 28, 84, 29);
		topPanel.add(listButton);
		
		listPanel = new JPanel();
		listPanel.setBackground(Color.WHITE);
		listPanel.setBounds(90, 90, 608, 577);
		frame.getContentPane().add(listPanel);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setBounds(710, 148, 280, 519);
		frame.getContentPane().add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel albumImage = new JLabel("avatar");
		albumImage.setOpaque(true);
		albumImage.setBackground(Color.ORANGE);
		albumImage.setBounds(10, 10, 260, 260);
		infoPanel.add(albumImage);
		
		JLabel albumTitle = new JLabel("BELLA CIAO");
		albumTitle.setBounds(10, 280, 260, 16);
		infoPanel.add(albumTitle);
		
		JLabel albumAuthor = new JLabel("Sergio y Andres");
		albumAuthor.setBounds(10, 300, 260, 16);
		infoPanel.add(albumAuthor);
		
		JLabel albumAlbum = new JLabel("Album:");
		albumAlbum.setBounds(10, 340, 50, 16);
		infoPanel.add(albumAlbum);
		
		JLabel albumDuration = new JLabel("Duration:");
		albumDuration.setBounds(10, 360, 84, 16);
		infoPanel.add(albumDuration);
		
		JLabel albumMusicGenre = new JLabel("Music genre:");
		albumMusicGenre.setBounds(10, 380, 84, 16);
		infoPanel.add(albumMusicGenre);
		
		JLabel albumReleaseDate = new JLabel("Release date:");
		albumReleaseDate.setBounds(10, 400, 84, 16);
		infoPanel.add(albumReleaseDate);
		
		JLabel albumDescription = new JLabel("Description:");
		albumDescription.setBounds(10, 420, 84, 16);
		infoPanel.add(albumDescription);
		
		JLabel dataAlbum = new JLabel("La Casa de Papel - Soundtrack");
		dataAlbum.setBounds(62, 340, 208, 16);
		infoPanel.add(dataAlbum);
		
		JLabel dataTime = new JLabel("4:25");
		dataTime.setBounds(75, 360, 195, 16);
		infoPanel.add(dataTime);
		
		JLabel dataMusicGenre = new JLabel("Pop");
		dataMusicGenre.setBounds(96, 380, 174, 16);
		infoPanel.add(dataMusicGenre);
		
		JLabel dataReleaseDate = new JLabel("01 January 2018");
		dataReleaseDate.setBounds(96, 400, 174, 16);
		infoPanel.add(dataReleaseDate);
		
		JTextArea dataDescription = new JTextArea();
		dataDescription.setWrapStyleWord(true);
		dataDescription.setLineWrap(true);
		dataDescription.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.");
		dataDescription.setEditable(false);
		dataDescription.setBounds(10, 440, 260, 69);
		infoPanel.add(dataDescription);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(710, 90, 280, 46);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		panel.add(txtSearch);
		txtSearch.setColumns(10);
	}
}
