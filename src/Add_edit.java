
import Theme.Colors;
import Theme.Theme;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Components.Button;
import Components.Heading;
import Components.PasswordField;
import Components.Textfield;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class Add_edit extends JFrame {
	
	static ResourceBundle res= ResourceBundle.getBundle("lang_PL");
//	static ResourceBundle res= ResourceBundle.getBundle("lang_EN");

	private Theme contentPane;
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
							JOptionPane.showMessageDialog(null, res.getString("edit"));
						
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
		setBounds(100, 100, 780, 620);
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
		Close.setBounds(734, 0, 46, 30);
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
		DragBar.setBounds(0, 0, 716, 30);
		contentPane.add(DragBar);
		
		Heading Edit_text = new Heading(res.getString("edit"), Colors.DTPurple);
//		Edit_text.setHorizontalAlignment(SwingConstants.CENTER);
//		Edit_text.setFont(new Font("Tahoma", Font.BOLD, 17));
		Edit_text.setBounds(10, 21, 208, 40);
		contentPane.add(Edit_text);
		
		String album = res.getString("album_title");
		Textfield Nazwa_Albumu = new Textfield("default", album);
		Nazwa_Albumu.setBounds(10, 70, 350, 70);
		contentPane.add(Nazwa_Albumu);
		
		String title = res.getString("title");
		Textfield Title_textfield = new Textfield("default", title);
		Title_textfield.setBounds(10, 170, 350, 70);
		contentPane.add(Title_textfield);
		
		String Author = res.getString("author");
		Textfield Author_textfield = new Textfield("default", Author);
		Author_textfield.setBounds(416, 70, 350, 70);
		contentPane.add(Author_textfield);
		
		String Genere = res.getString("genere");
		Textfield Genere_textfield = new Textfield("default", Genere);
		Genere_textfield.setBounds(416, 170, 350, 70);
		contentPane.add(Genere_textfield);
		
		String Date = res.getString("date");
		Textfield Date_textfield = new Textfield("default", Date);
		Date_textfield.setBounds(10, 273, 350, 70);
		contentPane.add(Date_textfield);
		
		JTextArea Description = new JTextArea();
		Description.setBounds(10, 379, 756, 108);
		Description.setOpaque(false);
		Description.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Colors.DTInactive));
		contentPane.add(Description);
		Description.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Description.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Colors.DTActive));
				Description.setForeground(Colors.DTText);
				Description.setBorder(BorderFactory.createCompoundBorder(Description.getBorder(), BorderFactory.createEmptyBorder(10,10,10,10)));
			}
			@Override
			public void focusLost(FocusEvent e) {
				Description.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Colors.DTInactive));
				Description.setForeground(Colors.DTInactive);
				Description.setBorder(BorderFactory.createCompoundBorder(Description.getBorder(), BorderFactory.createEmptyBorder(10,10,10,10)));
			}
		});
		
		
		
		
			Button customButton__1 = new Button();
			customButton__1.setBackground(Colors.DTPurple);
			customButton__1.setText(res.getString("remove_album"));
			customButton__1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					
					
					
					
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
						Statement stmt=con.createStatement();
						String sql="delete from utowory where Nazwa_utworu='"+song_name1+"'";
					
						
						stmt.executeUpdate(sql);
						stmt.close();
						JOptionPane.showMessageDialog(null,res.getString("album_removed") );
						
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
			customButton__1.setBounds(439, 517, 153, 46);
			getContentPane().add(customButton__1);
			
		
		
		
		JLabel lblNewLabel = new JLabel(res.getString("a_album_title"));
		lblNewLabel.setForeground(Colors.DTInactive);
		lblNewLabel.setBounds(10, 145, 142, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAktualnyTytulUtworu = new JLabel(res.getString("a_track_title"));
		lblAktualnyTytulUtworu.setForeground(Colors.DTInactive);
		lblAktualnyTytulUtworu.setBounds(10, 251, 128, 14);
		contentPane.add(lblAktualnyTytulUtworu);
		
		JLabel lblAktualnyAutorUtworu = new JLabel(res.getString("a_author"));
		lblAktualnyAutorUtworu.setBounds(416, 145, 128, 14);
		lblAktualnyAutorUtworu.setForeground(Colors.DTInactive);
		contentPane.add(lblAktualnyAutorUtworu);
		
		JLabel lblAktualnyGatunekUtworu = new JLabel(res.getString("a_genere"));
		lblAktualnyGatunekUtworu.setBounds(416, 251, 160, 14);
		lblAktualnyGatunekUtworu.setForeground(Colors.DTInactive);
		contentPane.add(lblAktualnyGatunekUtworu);
		
		JLabel lblAktualnaDataWydania = new JLabel(res.getString("a_date"));
		lblAktualnaDataWydania.setBounds(10, 354, 176, 14);
		lblAktualnaDataWydania.setForeground(Colors.DTInactive);
		contentPane.add(lblAktualnaDataWydania);
		
		JLabel lalbum_name = new JLabel("New label");
		lalbum_name.setForeground(Colors.DTPurple);
		lalbum_name.setText(album_name11);
		lalbum_name.setBounds(162, 145, 110, 14);
		contentPane.add(lalbum_name);
		
		JLabel lsong_name = new JLabel("New label");
		lsong_name.setForeground(Colors.DTPurple);
		lsong_name.setText(song_name1);
		lsong_name.setBounds(148, 251, 91, 14);
		contentPane.add(lsong_name);
		
		JLabel lautor = new JLabel("New label");
		lautor.setText(autor11);
		lautor.setForeground(Colors.DTPurple);
		lautor.setBounds(540, 145, 91, 14);
		contentPane.add(lautor);
		
		JLabel lgatunek = new JLabel("New label");
		lgatunek.setText(gatunek11);
		lgatunek.setForeground(Colors.DTPurple);
		lgatunek.setBounds(554, 251, 80, 14);
		contentPane.add(lgatunek);
		
		JLabel ldata = new JLabel("New label");
		ldata.setText(date11);
		ldata.setForeground(Colors.DTPurple);
		ldata.setBounds(181, 354, 91, 14);
		contentPane.add(ldata);
		
		Textfield image_textfield = new Textfield("default", res.getString("date"));
		image_textfield.label.setText("Nazwa obrazka");
		GridBagLayout gbl_image_textfield = (GridBagLayout) image_textfield.getLayout();
		gbl_image_textfield.rowWeights = new double[]{0.0, 0.0};
		gbl_image_textfield.rowHeights = new int[]{0, 0};
		gbl_image_textfield.columnWeights = new double[]{0.0};
		gbl_image_textfield.columnWidths = new int[]{0};
		image_textfield.setBounds(416, 273, 350, 70);
		contentPane.add(image_textfield);
		
		JLabel lblAktualnaNazwaObrazka = new JLabel(res.getString("a_picture"));
		lblAktualnaNazwaObrazka.setBounds(416, 354, 176, 14);
		lblAktualnaNazwaObrazka.setForeground(Colors.DTInactive);
		contentPane.add(lblAktualnaNazwaObrazka);
		
		JLabel limage = new JLabel((String) null);
		limage.setForeground(Colors.DTPurple);
		limage.setBounds(543, 354, 91, 14);
		contentPane.add(limage);
		
		JLabel labelaktualnyopis = new JLabel(res.getString("a_description"));
		labelaktualnyopis.setForeground(Colors.DTInactive);
		labelaktualnyopis.setBounds(10, 498, 229, 14);
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
			
					JOptionPane.showMessageDialog(null,res.getString("e_album_title") );
				
					}
					if(!Title_textfield.textfield.getText().equals("")) {
						sql="update utowory set Nazwa_utworu='"+Title_textfield.textfield.getText()+"' WHERE Nazwa_utworu='"+song_name1+"'";
						stmt.executeUpdate(sql);	
				        song_name1=Title_textfield.textfield.getText();
						JOptionPane.showMessageDialog(null,res.getString("e_track_title") );
					
						
					}
					if(!Author_textfield.textfield.getText().equals("")) {
						sql="update utowory set Autor='"+Author_textfield.textfield.getText()+"' WHERE Nazwa_utworu='"+song_name1+"'";
						stmt.executeUpdate(sql);	
					
						JOptionPane.showMessageDialog(null,res.getString("e_author") );
					}
					if(!Genere_textfield.textfield.getText().equals("")) {
					
						sql="update utowory set Gatunek='"+Genere_textfield.textfield.getText()+"' WHERE Nazwa_utworu='"+song_name1+"'";
						stmt.executeUpdate(sql);
					
						JOptionPane.showMessageDialog(null,res.getString("e_genere") );
						}
					if(!Date_textfield.textfield.getText().equals("")) {
						
						sql="update utowory set Data='"+Date_textfield.textfield.getText()+"' WHERE Nazwa_utworu='"+song_name1+"'";
						stmt.executeUpdate(sql);
					
						JOptionPane.showMessageDialog(null,res.getString("e_date") );
						}
                    if(!Description.getText().equals("")) {
						
						sql="update utowory set Opis='"+Description.getText()+"' WHERE Nazwa_utworu='"+song_name1+"'";
						stmt.executeUpdate(sql);
			
						JOptionPane.showMessageDialog(null,res.getString("e_description") );
						}
                    if(!image_textfield.getText().equals("")) {
						
						sql="update utowory set Image='"+image_textfield.getText()+"' WHERE Nazwa_utworu='"+song_name1+"'";
						stmt.executeUpdate(sql);
			
						JOptionPane.showMessageDialog(null,res.getString("e_picture") );
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
		Save.setText(res.getString("save_changes"));
		Save.setBounds(613, 519, 153, 43);
		contentPane.add(Save);
		
		
		contentPane.setDarkTheme(this, GlobalVariables.isDark);
		
		
		
		
		
		
		
		
		
		
		
	}
}
