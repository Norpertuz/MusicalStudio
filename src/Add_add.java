import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
public class Add_add extends JFrame {

	private JPanel contentPane;
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
		setBounds(100, 100, 370, 825);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		Close.setBounds(324, 0, 46, 30);
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
		DragBar.setBounds(0, 0, 324, 30);
		contentPane.add(DragBar);
		
		JLabel Edit_text = new JLabel("Dodaj Utwor");
		Edit_text.setHorizontalAlignment(SwingConstants.CENTER);
		Edit_text.setFont(new Font("Tahoma", Font.BOLD, 17));
		Edit_text.setBounds(30, 30, 131, 40);
		contentPane.add(Edit_text);
		
		String album = "Nazwa Albumu";
		Label_TextField Nazwa_Albumu = new Label_TextField(album,"default");
		Nazwa_Albumu.setBounds(10, 93, 350, 70);
		contentPane.add(Nazwa_Albumu);
		
		String title = "Tytu³";
		Label_TextField Title_textfield = new Label_TextField(title,"default");
		Title_textfield.setBounds(10, 173, 350, 70);
		contentPane.add(Title_textfield);
		
		String Author = "Autor";
		Label_TextField Author_textfield = new Label_TextField(Author,"default");
		Author_textfield.setBounds(10, 253, 350, 70);
		contentPane.add(Author_textfield);
		
		String Genere = "Gatunek";
		Label_TextField Genere_textfield = new Label_TextField(Genere,"default");
		Genere_textfield.setBounds(10, 333, 350, 70);
		contentPane.add(Genere_textfield);
		
		String Date = "Data Wydania";
		Label_TextField Date_textfield = new Label_TextField(Date,"default");
		Date_textfield.setBounds(10, 413, 350, 70);
		contentPane.add(Date_textfield);
		
		JTextArea Description = new JTextArea();
		Description.setBounds(10, 593, 350, 152);
		contentPane.add(Description);
		
		
		
		Label_TextField Link_TextField = new Label_TextField("Link do obrazka", "default");
		GridBagLayout gbl_Link_TextField = (GridBagLayout) Link_TextField.getLayout();
		gbl_Link_TextField.rowWeights = new double[]{0.0, 0.0};
		gbl_Link_TextField.rowHeights = new int[]{0, 0};
		gbl_Link_TextField.columnWeights = new double[]{0.0};
		gbl_Link_TextField.columnWidths = new int[]{0};
		Link_TextField.setBounds(10, 494, 350, 70);
		contentPane.add(Link_TextField);
		
		
		
		
		
		Button Save = new Button(Colors.darkThemeRed);
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Title_textfield.field.getText().equals("") || Nazwa_Albumu.field.getText().equals("") || Date_textfield.field.getText().equals("") || Author_textfield.field.getText().equals("") || Genere_textfield.field.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Nie podano wszystkich wymaganych danych.");
				     }
				
				
				else{
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
					String sql="INSERT INTO utowory values(?,?,?,?,?,?,?)";
				
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, Title_textfield.field.getText());
					stmt.setString(2, Nazwa_Albumu.field.getText());
					stmt.setString(3, Date_textfield.field.getText());
					stmt.setString(4, Author_textfield.field.getText());
					stmt.setString(5, Genere_textfield.field.getText());
					stmt.setString(6, Description.getText());
					stmt.setString(7, Link_TextField.field.getText());
				
				
				    int rs = stmt.executeUpdate();
					
				
					if(rs!=0) {
						JOptionPane.showMessageDialog(null, "Dodano utwor");
					
						dispose();
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
		Save.setBounds(219, 765, 141, 40);
		contentPane.add(Save);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
