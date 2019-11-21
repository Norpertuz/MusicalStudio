import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField Nickname;
	private JTextField Imie_Nazwisko;
	private JTextField mail;
	private JPasswordField password;
	private JPasswordField repeat_password;
	int posX=0,posY=0;


	/**
	 * Launch the application.
	 */
	public static void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 250, 370, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(229, 229, 229));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel NazwaStudia = new JLabel("Nazwa studia nagra\u0144");
		NazwaStudia.setForeground(new Color(3, 17, 252));
		NazwaStudia.setFont(new Font("Tahoma", Font.ITALIC, 19));
		NazwaStudia.setBounds(94, 22, 242, 59);
		contentPane.add(NazwaStudia);
		
		JLabel Close = new JLabel("X");
		Close.setForeground(new Color(195, 195, 195));
		Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		Close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Close.setFont(new Font("Tahoma", Font.BOLD, 15));
		Close.setHorizontalAlignment(SwingConstants.CENTER);
		Close.setBounds(326, 0, 44, 30);
		contentPane.add(Close);
		
		JLabel NazwaUzytkownika = new JLabel("Nazwa u\u017Cytkownika");
		NazwaUzytkownika.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NazwaUzytkownika.setBounds(38, 103, 131, 21);
		contentPane.add(NazwaUzytkownika);
		
		Nickname = new JTextField();
		Nickname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nickname.setBounds(38, 133, 292, 44);
		contentPane.add(Nickname);
		Nickname.setColumns(10);
		
		JLabel ImieNazwisko = new JLabel("Imie i Nazwisko");
		ImieNazwisko.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ImieNazwisko.setBounds(38, 188, 131, 21);
		contentPane.add(ImieNazwisko);
		
		Imie_Nazwisko = new JTextField();
		Imie_Nazwisko.setBounds(38, 225, 292, 44);
		contentPane.add(Imie_Nazwisko);
		Imie_Nazwisko.setColumns(10);
		
		JLabel e_mail = new JLabel("E-mail");
		e_mail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		e_mail.setBounds(38, 280, 131, 21);
		contentPane.add(e_mail);
		
		mail = new JTextField();
		mail.setBounds(38, 312, 292, 44);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Has\u0142o");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(38, 367, 131, 21);
		contentPane.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(38, 399, 292, 44);
		contentPane.add(password);
		
		JLabel Powtorz_Haslo = new JLabel("Powt\u00F3rz has\u0142o");
		Powtorz_Haslo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Powtorz_Haslo.setBounds(38, 454, 131, 21);
		contentPane.add(Powtorz_Haslo);
		
		repeat_password = new JPasswordField();
		repeat_password.setBounds(38, 486, 292, 44);
		contentPane.add(repeat_password);
		
		JLabel lblNewLabel = new JLabel("Masz ju\u017C konto?");
		lblNewLabel.setBounds(38, 591, 110, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Zaloguj si\u0119!");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] errorSoon = new String[1];
				dispose();
				Login nw = new Login();
				Login.main(errorSoon);
				
				
			}
		});
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBounds(158, 591, 91, 28);
		contentPane.add(lblNewLabel_2);
		
		JButton btnRg = new JButton("Register");
		btnRg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int c = password.getText().length();
				if (Nickname.getText().equals("") || Imie_Nazwisko.getText().equals("") || mail.getText().equals("") || password.getText().toString().equals("")){
					JOptionPane.showMessageDialog(null, "Nie podano wszystkich danych.");
				     }
				else if(c<6) {
					JOptionPane.showMessageDialog(null, "Podano za krótkie has³o.");
				}
				
				else{
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
					String sql="INSERT INTO users values(?,?,?,?,?)";
				
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, Nickname.getText());
					stmt.setString(2, Imie_Nazwisko.getText());
					stmt.setString(3, mail.getText());
					stmt.setString(4, password.getText().toString());
					stmt.setInt(5, 0);
				
				    int rs = stmt.executeUpdate();
					
				
					if(rs!=0) {
						JOptionPane.showMessageDialog(null, "Dodano uzytkownika");
						String[] errorSoon = new String[1];
						dispose();
						Login nw = new Login();
						Login.main(errorSoon);
					}
					else
						JOptionPane.showMessageDialog(null, "Nie dodano uzytkownika(blad)");
					
					con.close();
				} 
				catch(Exception er){System.out.print(er);}
				
				}	
			}
		});
		btnRg.setBounds(223, 557, 89, 23);
		contentPane.add(btnRg);
		
		JLabel DragBar = new JLabel("");//Przenoszenie ramki
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
		DragBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DragBar.setBounds(0, 0, 327, 30);
		contentPane.add(DragBar);
		setUndecorated(true); //usuwa ramke
	}
}
