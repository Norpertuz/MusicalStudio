import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class list_users extends JFrame {

	private JPanel contentPane;
	int posX=0,posY=0;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main22(boolean test) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					list_users frame = new list_users();
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
	public list_users() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel DragBar = new JLabel("");
		DragBar.setBounds(0, 0, 304, 30);
		DragBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		contentPane.setLayout(null);
		contentPane.add(DragBar);
		
		JLabel Close = new JLabel("");
		Close.setBounds(304, 0, 46, 30);
		Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		Close.setHorizontalTextPosition(SwingConstants.CENTER);
		Close.setHorizontalAlignment(SwingConstants.CENTER);
		Close.setIcon(new ImageIcon(list_users.class.getResource("/assets/closeIcon.png")));
		Close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(Close);
		
		JLabel Users_Label = new JLabel("Lista Uzytkownikow");
		Users_Label.setBounds(10, 40, 165, 35);
		Users_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(Users_Label);
		
		JLabel add_users = new JLabel("  Dodaj uzytkownika");
		add_users.setBounds(185, 40, 155, 35);
		add_users.setIcon(new ImageIcon(list_users.class.getResource("/assets/person_add_light.png")));
		contentPane.add(add_users);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 330, 439);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(false);
		table.setDragEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		String[] user = {"Nazwa uzytkownika","Admin"};
		String[][] dane = {{"Jan Kowalski","tak"}};
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setDataVector(dane,user);
		scrollPane.setViewportView(table);
	}
}
