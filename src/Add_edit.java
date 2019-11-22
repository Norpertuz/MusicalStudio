import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Add_edit extends JFrame {

	private JPanel contentPane;
	int posX=0,posY=0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		
		JLabel Edit_text = new JLabel("EDYTUJ");
		Edit_text.setHorizontalAlignment(SwingConstants.CENTER);
		Edit_text.setFont(new Font("Tahoma", Font.BOLD, 17));
		Edit_text.setBounds(30, 30, 75, 40);
		contentPane.add(Edit_text);
		
		JLabel Image = new JLabel("OBRAZEK");
		Image.setBackground(Color.YELLOW);
		Image.setOpaque(true);
		Image.setBounds(10, 100, 150, 100);
		contentPane.add(Image);
		
		JButton change = new JButton("Zmien obraz");
		change.setBounds(210, 100, 150, 40);
		contentPane.add(change);
		
		JButton delete = new JButton("Usun obraz");
		delete.setBounds(210, 160, 150, 40);
		contentPane.add(delete);
		
		String album = "Nazwa Albumu";
		Label_TextField Nazwa_Albumu = new Label_TextField(album,"default");
		Nazwa_Albumu.setBounds(10, 220, 350, 70);
		contentPane.add(Nazwa_Albumu);
		
		String title = "Tytu³";
		Label_TextField Title_textfield = new Label_TextField(title,"default");
		Title_textfield.setBounds(10, 300, 350, 70);
		contentPane.add(Title_textfield);
		
		String Author = "Autor";
		Label_TextField Author_textfield = new Label_TextField(Author,"default");
		Author_textfield.setBounds(10, 380, 350, 70);
		contentPane.add(Author_textfield);
		
		JPanel Genere = new JPanel();
		Genere.setBounds(10, 460, 350, 70);
		contentPane.add(Genere);
		
		JPanel Date = new JPanel();
		Date.setBounds(10, 540, 350, 70);
		contentPane.add(Date);
		
		JTextArea Description = new JTextArea();
		Description.setBounds(10, 620, 350, 125);
		contentPane.add(Description);
		
		Button Save = new Button(Colors.darkThemeRed);
		Save.setText("Zapisz Zmiany");
		Save.setBounds(219, 765, 141, 40);
		contentPane.add(Save);
	}
}
