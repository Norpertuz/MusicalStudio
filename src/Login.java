
import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField Nickname;
	private JPasswordField Password;
	private JLabel NazwaStudia;
	private JLabel NazwaUzytkownika;
	private JLabel Haslo;
	private JLabel Close;
	private JLabel Forgot_Password;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	int posX=0,posY=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(190, 228, 370, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(229, 229, 229));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Nickname = new JTextField();
		Nickname.setHorizontalAlignment(SwingConstants.LEFT);
		Nickname.setBackground(Color.WHITE);
		Nickname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nickname.setBounds(38, 135, 292, 42);
		contentPane.add(Nickname);
		Nickname.setColumns(10);
		
		Password = new JPasswordField();
		Password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_ENTER){
					 try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
							Statement stmt=con.createStatement();
							String sql="Select * from users WHERE nickname='"+Nickname.getText()+"' and password='"+Password.getText().toString()+"'";
							
							ResultSet rs=stmt.executeQuery(sql);
							if(rs.next())
								JOptionPane.showMessageDialog(null, "Zalogowano");
							else
								JOptionPane.showMessageDialog(null, "Nie zalogowano");
							
							con.close();
						} 
						catch(Exception r){System.out.print(r);}
		            }
				
			}
		});
		Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Password.setBounds(38, 225, 292, 44);
		contentPane.add(Password);
		
		customButton Login = new customButton("Sign Up");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
					Statement stmt=con.createStatement();
					String sql="Select * from users WHERE nickname='"+Nickname.getText()+"' and password='"+Password.getText().toString()+"'";
					
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
						JOptionPane.showMessageDialog(null, "Zalogowano");
					else
						JOptionPane.showMessageDialog(null, "Nie zalogowano");
					
					con.close();
				} 
				catch(Exception e){System.out.print(e);}
				
			}
		});
		Login.setBounds(224, 290, 106, 37);
		contentPane.add(Login);
		
		
		NazwaStudia = new JLabel("Nazwa studia nagra\u0144");
		NazwaStudia.setForeground(new Color(3, 17, 252));
		NazwaStudia.setFont(new Font("Tahoma", Font.ITALIC, 19));
		NazwaStudia.setBounds(94, 22, 242, 59);
		contentPane.add(NazwaStudia);
		
		NazwaUzytkownika = new JLabel("Nazwa u\u017Cytkownika");
		NazwaUzytkownika.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NazwaUzytkownika.setBounds(38, 103, 131, 21);
		contentPane.add(NazwaUzytkownika);
		
		Haslo = new JLabel("Has\u0142o");
		Haslo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Haslo.setBounds(38, 193, 85, 21);
		contentPane.add(Haslo);
		
		Close = new JLabel("X");
		Close.setForeground(new Color(195, 195, 195));
		Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0); //zamyka
			}
		});
		Close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Close.setFont(new Font("Tahoma", Font.BOLD, 15));
		Close.setHorizontalAlignment(SwingConstants.CENTER);
		Close.setBounds(326, 0, 44, 30);
		contentPane.add(Close);
		
		Forgot_Password = new JLabel("Zapomnia\u0142e\u015B/a\u015B has\u0142a ?");
		Forgot_Password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Forgot_Password.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Forgot_Password.setHorizontalAlignment(SwingConstants.LEFT);
		Forgot_Password.setBounds(38, 290, 170, 37);
		contentPane.add(Forgot_Password);
		
		lblNewLabel_2 = new JLabel("Zarejestruj si\u0119!");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		lblNewLabel_1 = new JLabel("Nie masz Konta ? ");
		lblNewLabel_1.setBounds(38, 386, 102, 44);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(150, 386, 85, 44);
		contentPane.add(lblNewLabel_2);
		
		JLabel DragBar = new JLabel(""); // Przenoszenie Ramki
		DragBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				  posX=arg0.getX();
                  posY=arg0.getY();
			}
		});
		DragBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
			}
		});
		DragBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DragBar.setBounds(0, 0, 330, 30);
		contentPane.add(DragBar);
		setUndecorated(true); // Usuwanie ramki 
	}
}
