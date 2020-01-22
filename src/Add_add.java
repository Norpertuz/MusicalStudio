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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
@SuppressWarnings("serial")
public class Add_add extends JFrame {

	private Theme contentPane;
	int posX=0,posY=0;
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
		
		Heading Edit_text = new Heading("Dodaj Utwor", Colors.DTPurple);
//		Edit_text.setHorizontalAlignment(SwingConstants.CENTER);
		Edit_text.setFont(new Font("Tahoma", Font.BOLD, 17));
		Edit_text.setBounds(10, 30, 167, 40);
		contentPane.add(Edit_text);
		
		String album = "Nazwa Albumu";
		Textfield Nazwa_Albumu = new Textfield("default", album);
		Nazwa_Albumu.setBounds(10, 93, 268, 70);
		contentPane.add(Nazwa_Albumu);
		
		String title = "Tytu�";
		Textfield Title_textfield = new Textfield("default", title);
		Title_textfield.label.setText("Tytul");
		Title_textfield.setBounds(10, 173, 268, 70);
		contentPane.add(Title_textfield);
		
		String Author = "Autor";
		Textfield Author_textfield = new Textfield("default", Author);
		Author_textfield.setBounds(10, 253, 268, 70);
		contentPane.add(Author_textfield);
		
		String Genere = "Gatunek";
		Textfield Genere_textfield = new Textfield("default", Genere);
		Genere_textfield.setBounds(288, 93, 268, 70);
		contentPane.add(Genere_textfield);
		
		String Date = "Data Wydania";
		Textfield Date_textfield = new Textfield("default", Date);
		Date_textfield.setBounds(288, 173, 268, 70);
		contentPane.add(Date_textfield);
		

		
		
		String link = "Nazwa obrazka";
		Textfield Link_TextField = new Textfield("default", link);
		GridBagLayout gbl_Link_TextField = (GridBagLayout) Link_TextField.getLayout();
		gbl_Link_TextField.rowWeights = new double[]{0.0, 0.0};
		gbl_Link_TextField.rowHeights = new int[]{0, 0};
		gbl_Link_TextField.columnWeights = new double[]{0.0};
		gbl_Link_TextField.columnWidths = new int[]{0};
		Link_TextField.setBounds(288, 253, 268, 70);
		contentPane.add(Link_TextField);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Opis");
		lblNewLabel.setForeground(Colors.DTInactive);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 334, 46, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea Description = new JTextArea();
		Description.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Description.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Colors.DTActive));
				lblNewLabel.setForeground(Colors.DTActive);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Description.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Colors.DTInactive));
				lblNewLabel.setForeground(Colors.DTInactive);
			}
		});
		Description.setBounds(10, 359, 546, 152);
		Description.setOpaque(false);
		Description.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Colors.DTInactive));
		contentPane.add(Description);
		
		Button Save = new Button();
		Save.setBackground(Colors.DTPurple);
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Title_textfield.textfield.getText().equals("") || Nazwa_Albumu.textfield.getText().equals("") || Date_textfield.textfield.getText().equals("") || Author_textfield.textfield.getText().equals("") || Genere_textfield.textfield.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Nie podano wszystkich wymaganych danych.");
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
						JOptionPane.showMessageDialog(null, "Dodano utwor");
						final Frame[] frames = Frame.getFrames();
						if (frames != null)
						    for (final Frame f : frames)
						    {
						        f.dispose();
						    }
						MainWindow.main1(GlobalVariables.fullname1, 1);
					}
					else
						JOptionPane.showMessageDialog(null, "Nie dodano utworu/blad");
					
					con.close();
				} 
				catch(Exception er){System.out.print(er);}
				
				}
				
				
				
				
			}
		});
		Save.setText("Dodaj");
		Save.setBounds(415, 523, 141, 40);
		contentPane.add(Save);
		
		
		contentPane.setDarkTheme(this, GlobalVariables.isDark);		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
