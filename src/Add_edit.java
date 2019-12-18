import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Components.Button;
import Components.Textfield;
import Theme.Colors;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
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
		setBounds(100, 100, 370, 700);
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
		
		String album = "Nazwa Albumu";
		Textfield Nazwa_Albumu = new Textfield("default", album);
		Nazwa_Albumu.setBounds(10, 90, 350, 70);
		contentPane.add(Nazwa_Albumu);
		
		String title = "Tytuł";
		Textfield Title_textfield = new Textfield("default", title);
		Title_textfield.setBounds(10, 170, 350, 70);
		contentPane.add(Title_textfield);
		
		String Author = "Autor";
		Textfield Author_textfield = new Textfield("default", Author);
		Author_textfield.setBounds(10, 250, 350, 70);
		contentPane.add(Author_textfield);
		
		String Genere = "Gatunek";
		Textfield Genere_textfield = new Textfield("default", Genere);
		Genere_textfield.setBounds(10, 330, 350, 70);
		contentPane.add(Genere_textfield);
		
		String Date = "Data Wydania";
		Textfield Date_textfield = new Textfield("default", Date);
		Date_textfield.setBounds(10, 410, 350, 70);
		contentPane.add(Date_textfield);
		
		JTextArea Description = new JTextArea();
		Description.setBounds(10, 490, 350, 125);
		contentPane.add(Description);
		
		Button Save = new Button();
		Save.setBackground(Colors.DTPurple);
		Save.setText("Zapisz Zmiany");
		Save.setBounds(219, 635, 141, 40);
		contentPane.add(Save);
	}
}
