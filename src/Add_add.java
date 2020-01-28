import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Components.Button;
import Components.Heading;
import Components.Textfield;
import Theme.Colors;
import Theme.Theme;

import java.sql.*;
import java.util.ResourceBundle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
@SuppressWarnings("serial")
public class Add_add extends JFrame {
	
	
	private Theme contentPane;
	int posX=0,posY=0;
	ResourceBundle res;
	/**
	 * Launch the application.
	 */
	public static void add_song(boolean test) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_add frame = new Add_add();
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
	public Add_add() {
		if(GlobalVariables.jezyk==1)res = ResourceBundle.getBundle("lang_PL");
		if(GlobalVariables.jezyk==0)res = ResourceBundle.getBundle("lang_EN");
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 580);
		contentPane = new Theme();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Colors.DTBackground);
		
		JLabel Close = new JLabel("");
		Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); // zamykamy tylko okno nie program
			}
		});
		Close.setIcon(new ImageIcon(Add_edit.class.getResource("/assets/closeIcon.png")));
		Close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Close.setHorizontalAlignment(SwingConstants.CENTER);
		Close.setBounds(519, 0, 46, 30);
		contentPane.add(Close);
		
		JLabel DragBar = new JLabel("");
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
		DragBar.setBounds(0, 0, 521, 30);
		contentPane.add(DragBar);
		
		Heading Edit_text = new Heading(res.getString("add_track"), Colors.DTPurple);
//		Edit_text.setHorizontalAlignment(SwingConstants.CENTER);
		Edit_text.setFont(new Font("Tahoma", Font.BOLD, 17));
		Edit_text.setBounds(10, 30, 167, 40);
		contentPane.add(Edit_text);
		
		String album = res.getString("album_title");
		Textfield Nazwa_Albumu = new Textfield("default", album);
		Nazwa_Albumu.setBounds(10, 93, 268, 70);
		contentPane.add(Nazwa_Albumu);
		
		String title = res.getString("title");
		Textfield Title_textfield = new Textfield("default", title);
		Title_textfield.label.setText("Tytul");
		Title_textfield.setBounds(10, 173, 268, 70);
		contentPane.add(Title_textfield);
		
		String Author = res.getString("author");
		Textfield Author_textfield = new Textfield("default", Author);
		Author_textfield.setBounds(10, 253, 268, 70);
		contentPane.add(Author_textfield);
		
		String Genere = res.getString("genere");
		Textfield Genere_textfield = new Textfield("default", Genere);
		Genere_textfield.setBounds(288, 93, 268, 70);
		contentPane.add(Genere_textfield);
		
		String Date = res.getString("date");
		Textfield Date_textfield = new Textfield("default", Date);
		Date_textfield.setBounds(288, 173, 268, 70);
		contentPane.add(Date_textfield);
		

		
		
		String link = res.getString("picture");
		Textfield Link_TextField = new Textfield("default", link);
		GridBagLayout gbl_Link_TextField = (GridBagLayout) Link_TextField.getLayout();
		gbl_Link_TextField.rowWeights = new double[]{0.0, 0.0};
		gbl_Link_TextField.rowHeights = new int[]{0, 0};
		gbl_Link_TextField.columnWeights = new double[]{0.0};
		gbl_Link_TextField.columnWidths = new int[]{0};
		Link_TextField.setBounds(288, 253, 268, 70);
		contentPane.add(Link_TextField);
		
		
		
		JTextArea Description = new JTextArea();
		JLabel lblNewLabel = new JLabel(res.getString("description"));
		lblNewLabel.setForeground(Colors.DTInactive);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 334, 148, 14);
		contentPane.add(lblNewLabel);
		Description.setBounds(10, 359, 546, 152);
		Description.setOpaque(false);
		Description.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Colors.DTInactive));
		Description.setBorder(BorderFactory.createCompoundBorder(Description.getBorder(), BorderFactory.createEmptyBorder(10,10,10,10)));
		contentPane.add(Description);
	
		Description.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Description.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Colors.DTActive));
				lblNewLabel.setForeground(Colors.DTActive);
				Description.setBorder(BorderFactory.createCompoundBorder(Description.getBorder(), BorderFactory.createEmptyBorder(10,10,10,10)));
			}
			@Override
			public void focusLost(FocusEvent e) {
				Description.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Colors.DTInactive));
				lblNewLabel.setForeground(Colors.DTInactive);
				Description.setBorder(BorderFactory.createCompoundBorder(Description.getBorder(), BorderFactory.createEmptyBorder(10,10,10,10)));
			}
		});
		
		Button Save = new Button();
		Save.setBackground(Colors.DTPurple);
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Title_textfield.textfield.getText().equals("") || Nazwa_Albumu.textfield.getText().equals("") || Date_textfield.textfield.getText().equals("") || Author_textfield.textfield.getText().equals("") || Genere_textfield.textfield.getText().equals("")){
					JOptionPane.showMessageDialog(null, res.getString("req_data"));
				     }
				
				
				else{
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
					String sql="INSERT INTO utowory values(?,?,?,?,?,?,?)";
				
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, Title_textfield.textfield.getText());
					stmt.setString(2, Nazwa_Albumu.textfield.getText());
					stmt.setString(3, Date_textfield.textfield.getText());
					stmt.setString(4, Author_textfield.textfield.getText());
					stmt.setString(5, Genere_textfield.textfield.getText());
					stmt.setString(6, Description.getText());
					stmt.setString(7, Link_TextField.textfield.getText());
				
				
				    int rs = stmt.executeUpdate();
					
				
					if(rs!=0) {
						JOptionPane.showMessageDialog(null, res.getString("track_added"));
						final Frame[] frames = Frame.getFrames();
						if (frames != null)
						    for (final Frame f : frames)
						    {
						        f.dispose();
						    }
						MainWindow.main1(GlobalVariables.fullname1, 1);
					}
					else
						JOptionPane.showMessageDialog(null, res.getString("n_track_added"));
					
					con.close();
				} 
				catch(Exception er){System.out.print(er);}
				
				}
				
				
				
				
			}
		});
		Save.setText(res.getString("add"));
		Save.setBounds(415, 523, 141, 40);
		contentPane.add(Save);
		
		
		contentPane.setDarkTheme(this, GlobalVariables.isDark);		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
