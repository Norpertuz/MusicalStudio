import java.sql.*;
import java.util.ResourceBundle;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Components.Button;
import Components.PasswordField;
import Components.Textfield;
import Theme.Colors;
import Theme.Theme;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

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
	
//	ResourceBundle res= ResourceBundle.getBundle("lang_PL");
	
	//ResourceBundle res= ResourceBundle.getBundle("lang_EN");
	
	
	
	
	private Theme Wrapper;
	private JLabel Logomark;
	private JLabel Close;
	private JLabel ForgotPassword;
	private JLabel AlreadyHaveAnAccount;
	private JLabel SignUp;
	int posX=0,posY=0;
	static ResourceBundle res;
	static JLabel Name;	
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
		
		if(GlobalVariables.jezyk==1)res = ResourceBundle.getBundle("lang_PL");
		if(GlobalVariables.jezyk==0)res = ResourceBundle.getBundle("lang_EN");
		
		//JOptionPane.showMessageDialog(null, GlobalVariables.jezyk);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(190, 228, 370, 468);
		Wrapper = new Theme();
		Wrapper.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Wrapper);
		Wrapper.setLayout(null);
		Wrapper.setBackground(Colors.DTBackground);
		String UsernameLabel = res.getString("username");
		Textfield Username = new Textfield("default", UsernameLabel);
		Username.setSize(292, 70);
		Username.setLocation(38, 127);
		Wrapper.add(Username);
		
		String MyPasswordLabel = res.getString("password");
		PasswordField MyPassword = new PasswordField(MyPasswordLabel);
		MyPassword.setBounds(38, 218, 292, 73);
		Wrapper.add(MyPassword);
		//Password = new newPasswordField();
		boolean isPressed = false;
		MyPassword.passwordfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_ENTER){
						if (Username.getText().equals("")) {
							Username.isEmpty(UsernameLabel);
							MyPassword.isEmpty(MyPasswordLabel);
							JOptionPane.showMessageDialog(null, res.getString("wrong"));
						} else {
							try {
								Class.forName("com.mysql.jdbc.Driver");
								Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
								Statement stmt=con.createStatement();
								String sql="Select * from users WHERE nickname='"+Username.textfield.getText()+"' and password='"+MyPassword.passwordfield.getText().toString()+"'";
								ResultSet rs=stmt.executeQuery(sql);
								if(rs.next()) {
									dispose();
									String fullnameX = rs.getString("fullname");
									int is_admin = rs.getInt("isAdmin");
									MainWindow.main1(fullnameX,is_admin);
									
									
									
									
							} else {
								JOptionPane.showMessageDialog(null, res.getString("wrong"));
								
							}
								
								
								
								con.close();
							} catch(Exception ex){System.out.print(ex);}	
						}
		            }
			} 
		}); isPressed = true;
//		Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		Password.setBounds(38, 250, 292, 44);
//		contentPane.add(Password);
		
		Button SignIn = new Button();
		SignIn.setBackground(Colors.DTPurple);
		String SignInLabel = res.getString("login");
		SignIn.setText(SignInLabel);
		SignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Username.getText().equals("")) {
					Username.isEmpty(UsernameLabel);
					MyPassword.isEmpty(MyPasswordLabel);
					JOptionPane.showMessageDialog(null, res.getString("wrong"));
				} else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
						Statement stmt=con.createStatement();
						String sql="Select * from users WHERE nickname='"+Username.textfield.getText()+"' and password='"+MyPassword.passwordfield.getText().toString()+"'";
						ResultSet rs=stmt.executeQuery(sql);
						if(rs.next()) {
							dispose();
							String fullnameX = rs.getString("fullname");
							int is_admin = rs.getInt("isAdmin");
							MainWindow.main1(fullnameX,is_admin);
					} else {JOptionPane.showMessageDialog(null, res.getString("wrong"));}
						
						
						
						
						con.close();
					} catch(Exception e){System.out.print(e);}	
				}
			}
		});
		
		SignIn.setBounds(224, 314, 106, 37);
		Wrapper.add(SignIn);
		
		
		Button lbutton = new Button();
		lbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(GlobalVariables.jezyk==1)GlobalVariables.jezyk=0;
				else {GlobalVariables.jezyk=1;}
				final Frame[] frames = Frame.getFrames();
				if (frames != null)
				    for (final Frame f : frames)
				    {
				        f.dispose();
				    }
				String[] errorSoon = new String[1];
				Login.main(errorSoon);
			
				
				
			}
		});
		String lbuttonLabel = res.getString("language_name");
		lbutton.setText(lbuttonLabel);
		lbutton.setBounds(205, 434, 155, 23);
		lbutton.setBackground(Colors.DTPurple);
		lbutton.setForeground(Colors.DTText);
		Wrapper.add(lbutton);
		
		String NameLabel = res.getString("studio_name");
		Name = new JLabel(NameLabel);
		Name.setInheritsPopupMenu(false);
		Name.setForeground(Colors.DTPurple);
		Name.setFont(new Font("Tahoma", Font.BOLD, 18));
		Name.setBounds(96, 48, 234, 67);
		Wrapper.add(Name);
		
		
		Logomark = new JLabel("");
		Logomark.setHorizontalTextPosition(SwingConstants.CENTER);
		Logomark.setHorizontalAlignment(SwingConstants.CENTER);
		Logomark.setInheritsPopupMenu(false);
		Logomark.setIcon(new ImageIcon(Login.class.getResource("/assets/logo.png")));
		Logomark.setForeground(Colors.DTPurple);
		Logomark.setFont(new Font("Tahoma", Font.BOLD, 18));
		Logomark.setBounds(38, 48, 46, 67);
		Wrapper.add(Logomark);
		
		Close = new JLabel("");
		Close.setBackground(Color.CYAN);
		Close.setIcon(new ImageIcon(Login.class.getResource("/assets/closeIcon.png")));
		Close.setForeground(Color.PINK);
		Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0); //zamyka
			}
		});
		Close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Close.setFont(new Font("Tahoma", Font.BOLD, 15));
		Close.setHorizontalAlignment(SwingConstants.CENTER);
		Close.setBounds(324, 5, 46, 30);
		Wrapper.add(Close);
		
		String ForgotPasswordLabel = res.getString("forgot");
		ForgotPassword = new JLabel(ForgotPasswordLabel);
		ForgotPassword.setForeground(Color.decode("#4C506D"));
		ForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, res.getString("remind"));
			}
		});
		ForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ForgotPassword.setHorizontalAlignment(SwingConstants.LEFT);
		ForgotPassword.setBounds(38, 315, 121, 37);
		Wrapper.add(ForgotPassword);
		
		String SignUpLabel = res.getString("signup");
		SignUp = new JLabel(SignUpLabel);
		SignUp.setForeground(Colors.DTPurple);
		SignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				//Register nw = new Register();
				Register.main1(false);
				
			}
		});
		String AlreadyHaveAnAccountLabel = res.getString("dont");
		AlreadyHaveAnAccount = new JLabel(AlreadyHaveAnAccountLabel);
		AlreadyHaveAnAccount.setBounds(38, 386, 155, 44);
		Wrapper.add(AlreadyHaveAnAccount);
		SignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SignUp.setHorizontalAlignment(SwingConstants.CENTER);
		SignUp.setBounds(158, 393, 121, 30);		
		AlreadyHaveAnAccount.setForeground(Color.decode("#4C506D"));
		Wrapper.add(SignUp);
		
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
		DragBar.setBounds(0, 0, 324, 30);
		Wrapper.add(DragBar);
		setUndecorated(true); // Usuwanie ramki 
		
		
		Wrapper.setBackground(Colors.DTBackground);
		Username.handleFocus(true, Username.type, Username.name);
		MyPassword.handleFocus(true, MyPassword.name);
		SignIn.setBackground(Colors.DTPurple);
		
		
		
		Wrapper.setDarkTheme(this, false);
	}
}
