
import Theme.Colors;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Components.Button;
import Components.PasswordField;
import Components.Textfield;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class Add_edit extends JFrame {

	private JPanel contentPane;
	int posX=0,posY=0;
	static String album_name11, date11, autor11, gatunek11, opis11;
	static String song_name1;
    static int admin;
	/**
	 * Launch the application.
	 */
	public static void edit_song(String song_name, int is_Admin) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					song_name1=song_name;
					admin = is_Admin;
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
						Statement stmt=con.createStatement();
						String sql="Select * from utowory WHERE Nazwa_utworu='"+song_name+"'";
						ResultSet rs=stmt.executeQuery(sql);
						if(rs.next()) {
							album_name11=rs.getString("Nazwa_albumu");
							date11 = rs.getString("Data");
							autor11=rs.getString("Autor");
							gatunek11 =rs.getString("Gatunek");
							opis11 =rs.getString("Opis");
					}
						else
							JOptionPane.showMessageDialog(null, "Nie zalogowano");
						
						con.close();
					} 
					catch(Exception e){System.out.print(e);}
					
					
					
					
					
					
					
					
					
					
					
					Add_edit frame = new Add_edit();
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
	public Add_edit() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 800);
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
		
		JLabel Edit_text = new JLabel("EDYTUJ");
		Edit_text.setHorizontalAlignment(SwingConstants.CENTER);
		Edit_text.setFont(new Font("Tahoma", Font.BOLD, 17));
		Edit_text.setBounds(10, 21, 75, 40);
		contentPane.add(Edit_text);
		
		String album = "Nazwa Albumu";
		Textfield Nazwa_Albumu = new Textfield("default", album);
		Nazwa_Albumu.setBounds(10, 70, 350, 70);
		contentPane.add(Nazwa_Albumu);
		
		String title = "Tytul";
		Textfield Title_textfield = new Textfield("default", title);
		Title_textfield.setBounds(10, 170, 350, 70);
		contentPane.add(Title_textfield);
		
		String Author = "Autor";
		Textfield Author_textfield = new Textfield("default", Author);
		Author_textfield.setBounds(10, 280, 350, 70);
		contentPane.add(Author_textfield);
		
		String Genere = "Gatunek";
		Textfield Genere_textfield = new Textfield("default", Genere);
		Genere_textfield.setBounds(10, 390, 350, 70);
		contentPane.add(Genere_textfield);
		
		String Date = "Data Wydania";
		Textfield Date_textfield = new Textfield("default", Date);
		Date_textfield.setBounds(10, 500, 350, 70);
		contentPane.add(Date_textfield);
		
		JTextArea Description = new JTextArea();
		Description.setBounds(10, 601, 350, 108);
		contentPane.add(Description);
		
		
		
		
		
			Button customButton__1 = new Button();
			customButton__1.setText("Usun album");
			customButton__1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					
					
					
					
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
						Statement stmt=con.createStatement();
						String sql="delete from utowory where Nazwa_utworu='"+song_name1+"'";
					
						
						stmt.executeUpdate(sql);
						stmt.close();
						JOptionPane.showMessageDialog(null,"Usunieto album!" );
						
						con.close();
						final Frame[] frames = Frame.getFrames();
						if (frames != null)
						    for (final Frame f : frames)
						    {
						        f.dispose();
						    }
						MainWindow.main1(GlobalVariables.fullname1, admin);
					} 
					catch(Exception e){System.out.print(e);}
					
					
					
					
					
					
					
					
					
					
				}
			});
			customButton__1.setBounds(20, 743, 153, 46);
			getContentPane().add(customButton__1);
			
		
		
		
		JLabel lblNewLabel = new JLabel("Aktualna nazwa albumu:");
		lblNewLabel.setBounds(10, 145, 128, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAktualnyTytulUtworu = new JLabel("Aktualny tytul utworu:");
		lblAktualnyTytulUtworu.setBounds(10, 251, 128, 14);
		contentPane.add(lblAktualnyTytulUtworu);
		
		JLabel lblAktualnyAutorUtworu = new JLabel("Aktualny autor utworu:");
		lblAktualnyAutorUtworu.setBounds(10, 365, 128, 14);
		contentPane.add(lblAktualnyAutorUtworu);
		
		JLabel lblAktualnyGatunekUtworu = new JLabel("Aktualny gatunek utworu:");
		lblAktualnyGatunekUtworu.setBounds(10, 475, 160, 14);
		contentPane.add(lblAktualnyGatunekUtworu);
		
		JLabel lblAktualnaDataWydania = new JLabel("Aktualna data wydania utworu:");
		lblAktualnaDataWydania.setBounds(10, 576, 176, 14);
		contentPane.add(lblAktualnaDataWydania);
		
		JLabel lalbum_name = new JLabel("New label");
		lalbum_name.setText(album_name11);
		lalbum_name.setBounds(148, 145, 110, 14);
		contentPane.add(lalbum_name);
		
		JLabel lsong_name = new JLabel("New label");
		lsong_name.setText(song_name1);
		lsong_name.setBounds(148, 251, 91, 14);
		contentPane.add(lsong_name);
		
		JLabel lautor = new JLabel("New label");
		lautor.setText(autor11);
		lautor.setBounds(148, 365, 91, 14);
		contentPane.add(lautor);
		
		JLabel lgatunek = new JLabel("New label");
		lgatunek.setText(gatunek11);
		lgatunek.setBounds(199, 475, 80, 14);
		contentPane.add(lgatunek);
		
		JLabel ldata = new JLabel("New label");
		ldata.setText(date11);
		ldata.setBounds(199, 576, 91, 14);
		contentPane.add(ldata);
		
		JLabel labelaktualnyopis = new JLabel("Aktualny opis - kliknij by zobaczyc");
		labelaktualnyopis.setBounds(10, 720, 229, 14);
		labelaktualnyopis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelaktualnyopis.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				JOptionPane.showMessageDialog(null,opis11 );
			
				
			}
		});
		contentPane.add(labelaktualnyopis);
		
		
		Button Save = new Button();
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
					Statement stmt=con.createStatement();
					String sql="";
				
					
					
				
					if(!Nazwa_Albumu.textfield.getText().equals("")) {
					sql="update utowory set Nazwa_albumu='"+Nazwa_Albumu.textfield.getText()+"' WHERE Nazwa_utworu='"+song_name1+"'";
					stmt.executeUpdate(sql);
			
					JOptionPane.showMessageDialog(null,"Zedytowano Nazwa_albumu" );
				
					}
					if(!Title_textfield.textfield.getText().equals("")) {
						sql="update utowory set Nazwa_utworu='"+Title_textfield.textfield.getText()+"' WHERE Nazwa_utworu='"+song_name1+"'";
						stmt.executeUpdate(sql);	
				
						JOptionPane.showMessageDialog(null,"Zedytowano Nazwa_utworu" );
					
						
					}
					if(!Author_textfield.textfield.getText().equals("")) {
						sql="update utowory set Autor='"+Author_textfield.textfield.getText()+"' WHERE Nazwa_utworu='"+song_name1+"'";
						stmt.executeUpdate(sql);	
					
						JOptionPane.showMessageDialog(null,"Zedytowano Autor" );
					}
					if(!Genere_textfield.textfield.getText().equals("")) {
					
						sql="update utowory set Gatunek='"+Genere_textfield.textfield.getText()+"' WHERE Nazwa_utworu='"+song_name1+"'";
						stmt.executeUpdate(sql);
					
						JOptionPane.showMessageDialog(null,"Zedytowano Gatunek" );
						}
					if(!Date_textfield.textfield.getText().equals("")) {
						
						sql="update utowory set Data='"+Date_textfield.textfield.getText()+"' WHERE Nazwa_utworu='"+song_name1+"'";
						stmt.executeUpdate(sql);
					
						JOptionPane.showMessageDialog(null,"Zedytowano Data" );
						}
                    if(!Description.getText().equals("")) {
						
						sql="update utowory set Opis='"+Description.getText()+"' WHERE Nazwa_utworu='"+song_name1+"'";
						stmt.executeUpdate(sql);
			
						JOptionPane.showMessageDialog(null,"Zedytowano Opis" );
						}
					
					
					con.close();
					stmt.close();
					
					final Frame[] frames = Frame.getFrames();
					if (frames != null)
					    for (final Frame f : frames)
					    {
					        f.dispose();
					    }
					MainWindow.main1(GlobalVariables.fullname1, admin);
					/*
					JOptionPane.showMessageDialog(null,"Wymagane jest ponowne uruchomienie aplikacji." );
					System.exit(0);
					*/
				} 
				catch(Exception e){System.out.print(e);}
				
				
				
			}
		});
		Save.setBackground(Colors.DTPurple);
		Save.setText("Zapisz Zmiany");
		Save.setBounds(199, 743, 153, 43);
		contentPane.add(Save);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
