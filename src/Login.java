
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
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private newPasswordField Password;
	private JLabel NazwaStudia;
	private JLabel Close;
	private JLabel Forgot_Password;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	int posX=0,posY=0;
	
	//dark theme
	public Color dt_red = Color.decode("#EE2B47");
	public Color dt_bg = Color.decode("#34374C");
	
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
		contentPane.setBackground(this.dt_bg);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		newTextField test = new newTextField("Nazwa u¿ytkownika", "normal");
		contentPane.add(test);
		newTextField mypass = new newTextField("Password", "password");
		mypass.setBounds(38, 218, 370, 73);
		contentPane.add(mypass);
		//Password = new newPasswordField();
		mypass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_ENTER){
					 try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
							Statement stmt=con.createStatement();
							String sql="Select * from users WHERE nickname='"+test.field.getText()+"' and password='"+mypass.passfield.getText().toString()+"'";
							ResultSet rs=stmt.executeQuery(sql);
							if(rs.next()) {
								dispose();
								String fullnameX = rs.getString("fullname");
								int is_admin = rs.getInt("isAdmin");
								JOptionPane.showMessageDialog(null, "Zalogowano");
								MainWindow nw = new MainWindow();
								MainWindow.main1(fullnameX,is_admin);
						}
							else
								JOptionPane.showMessageDialog(null, "Nie zalogowano");
							
							con.close();
						} 
						catch(Exception er){System.out.print(er);}
		            }
				
			} 
		});
//		Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		Password.setBounds(38, 250, 292, 44);
//		contentPane.add(Password);
		
		customButton Login = new customButton("Sign Up", "dark");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
					Statement stmt=con.createStatement();
					String sql="Select * from users WHERE nickname='"+test.field.getText()+"' and password='"+mypass.passfield.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						dispose();
						String fullnameX = rs.getString("fullname");
						int is_admin = rs.getInt("isAdmin");
						JOptionPane.showMessageDialog(null, "Zalogowano");
						MainWindow nw = new MainWindow();
						MainWindow.main1(fullnameX,is_admin);
				}
					else
						JOptionPane.showMessageDialog(null, "Nie zalogowano");
					
					con.close();
				} 
				catch(Exception e){System.out.print(e);}
				
			}
		});
		Login.setBounds(224, 315, 106, 37);
		contentPane.add(Login);
		
		
		NazwaStudia = new JLabel("Nazwa studia nagra\u0144");
		NazwaStudia.setIcon(new ImageIcon(Login.class.getResource("/assets/logomark.png")));
		NazwaStudia.setForeground(new Color(3, 17, 252));
		NazwaStudia.setFont(new Font("Tahoma", Font.BOLD, 18));
		NazwaStudia.setBounds(38, 48, 287, 67);
		contentPane.add(NazwaStudia);
		
		Close = new JLabel("");
		Close.setIcon(new ImageIcon(Login.class.getResource("/assets/closeIcon.png")));
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
		Close.setBounds(324, 6, 46, 30);
		contentPane.add(Close);
		
		Forgot_Password = new JLabel("Zapomnia\u0142e\u015B/a\u015B has\u0142a ?");
		Forgot_Password.setForeground(Color.decode("#4C506D"));
		Forgot_Password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Forgot_Password.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Forgot_Password.setHorizontalAlignment(SwingConstants.LEFT);
		Forgot_Password.setBounds(38, 315, 170, 37);
		contentPane.add(Forgot_Password);
		
		lblNewLabel_2 = new JLabel("Zarejestruj si\u0119!");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Register nw = new Register();
				Register.main1();
				
			}
		});
		
		lblNewLabel_1 = new JLabel("Nie masz Konta ? ");
		lblNewLabel_1.setBounds(38, 386, 117, 44);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(151, 386, 117, 44);
		lblNewLabel_1.setForeground(Color.decode("#4C506D"));
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
