import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class user_edit {

	private JFrame frame;
	private Label_TextField textField;

	/**
	 * Launch the application.
	 */
	public static void okno_edycji(String user) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_edit window = new user_edit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public user_edit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EDYTUJ PROFIL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(28, 39, 137, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setBounds(28, 96, 137, 114);
		frame.getContentPane().add(lblNewLabel_1);
		
		customButton btnNewButton = new customButton("Zmien obraz", "light");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(225, 96, 153, 46);
		frame.getContentPane().add(btnNewButton);
		
		customButton btnNewButton_1 = new customButton("Usun obraz", "light");
		btnNewButton_1.setBounds(225, 164, 153, 46);
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new Label_TextField("nazwa1","default");
		textField.setBounds(28, 240, 350, 82);
		frame.getContentPane().add(textField);
		
		customButton customButton_ = new customButton("Zapisz zmiany", "light");
		customButton_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		customButton_.setBounds(225, 585, 153, 46);
		frame.getContentPane().add(customButton_);
	}
}
