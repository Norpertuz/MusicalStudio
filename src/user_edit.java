import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;

public class user_edit {

	private JFrame frame;
	private Label_TextField textField;
    static String user1;
    static int admin;
	/**
	 * Launch the application.
	 */
	public static void okno_edycji(String user,int is_Admin) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user1=user;
					admin = is_Admin;
					
					
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
		frame.setBounds(100, 100, 451, 790);
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
		
		textField = new Label_TextField("Nickname","default");
		textField.setBounds(28, 240, 350, 82);
		frame.getContentPane().add(textField);
		
		customButton customButton_ = new customButton("Zapisz zmiany", "light");
		customButton_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		customButton_.setBounds(225, 671, 153, 46);
		frame.getContentPane().add(customButton_);
		
		Label_TextField label_TextField = new Label_TextField("Imie i Nazwisko", "default");
		GridBagLayout gridBagLayout = (GridBagLayout) label_TextField.getLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.columnWidths = new int[]{0};
		label_TextField.setBounds(28, 350, 350, 82);
		frame.getContentPane().add(label_TextField);
		
		Label_TextField label_TextField_1 = new Label_TextField("Password", "default");
		GridBagLayout gridBagLayout_1 = (GridBagLayout) label_TextField_1.getLayout();
		gridBagLayout_1.rowWeights = new double[]{0.0, 0.0};
		gridBagLayout_1.rowHeights = new int[]{0, 0};
		gridBagLayout_1.columnWeights = new double[]{0.0};
		gridBagLayout_1.columnWidths = new int[]{0};
		label_TextField_1.setBounds(28, 452, 350, 82);
		frame.getContentPane().add(label_TextField_1);
		
		Label_TextField label_TextField_2 = new Label_TextField("Email", "default");
		GridBagLayout gridBagLayout_2 = (GridBagLayout) label_TextField_2.getLayout();
		gridBagLayout_2.rowWeights = new double[]{0.0, 0.0};
		gridBagLayout_2.rowHeights = new int[]{0, 0};
		gridBagLayout_2.columnWeights = new double[]{0.0};
		gridBagLayout_2.columnWidths = new int[]{0};
		label_TextField_2.setBounds(28, 566, 350, 82);
		frame.getContentPane().add(label_TextField_2);
		
		JLabel nickname1 = new JLabel("New label");
		nickname1.setBounds(28, 221, 46, 14);
		frame.getContentPane().add(nickname1);
		
		if(admin==1) {
		customButton customButton__1 = new customButton("Usun konto", "light");
		customButton__1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		customButton__1.setBounds(28, 671, 153, 46);
		frame.getContentPane().add(customButton__1);
		}
		
	}
}
