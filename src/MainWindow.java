import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;

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
		listPanel.setBounds(90, 90, 554, 577);
		frame.getContentPane().add(listPanel);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setBounds(656, 160, 334, 507);
		frame.getContentPane().add(infoPanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(656, 90, 334, 58);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		panel.add(txtSearch);
		txtSearch.setColumns(10);
	}
}
