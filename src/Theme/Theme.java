package Theme;
import java.awt.Button;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Components.Heading;
import Components.PasswordField;
import Components.Table;
import Components.Textfield;

@SuppressWarnings("serial")
public class Theme extends JPanel{
	
//	admin_panel.setForeground(Color.BLACK);
//	user_list.setForeground(Color.BLACK);
//	albumedit.setForeground(Color.BLACK);
//	textArea.setForeground(Color.BLACK);
//	listPanel.setBackground(Colors.LTBackground);
//	panelH.line.setBackground(Colors.LTBlue);
//	panelH.label.setForeground(Color.BLACK);
//	searchBar.setBackground(Colors.LTBackground);
//	table.setForeground(Color.BLACK);
//	table.setBackground(Colors.LTBackground);
//	table.getTableHeader().setBackground(Colors.LTBackground);
//	table.setSelectionBackground(Color.decode("#F6F6F6"));
//	table.setSelectionForeground(Color.BLACK);
	
	public void MainWindow(boolean dark, String Parent) {
		if (dark == true) {
			if (Parent == "MainWindow") {
				this.setBackground(Colors.DTBackground);
				this.getComponent(1).setBackground(Colors.DTPurple);
				JPanel topPanel = (JPanel) this.getComponent(2);
				topPanel.setBackground(Colors.DTPanel);
				topPanel.getComponent(0).setForeground(Colors.DTText);
				topPanel.getComponent(2).setForeground(Colors.DTText);
				topPanel.getComponent(3).setForeground(Colors.DTText);
				topPanel.getComponent(4).setForeground(Colors.DTText);
				
				JPanel listPanel = (JPanel) this.getComponent(3);
				listPanel.setBackground(Colors.DTPanel);
				Heading listPanelH = (Heading) listPanel.getComponent(1);
				listPanelH.line.setBackground(Colors.DTPurple);
				listPanelH.label.setForeground(Colors.DTText);
				
				JScrollPane listPanelScroll = (JScrollPane) listPanel.getComponent(0);
				Table listPanelTable = (Table) listPanelScroll.getViewport().getComponent(0);
				listPanelTable.setForeground(Colors.DTText);
				listPanelTable.setBackground(Colors.DTPanel);
				listPanelTable.setSelectionBackground(Colors.DTisSelected);
				listPanelTable.setSelectionForeground(Colors.DTText);
				listPanelTable.getTableHeader().setBackground(Colors.DTPanel);
				
				this.getComponent(4).setBackground(Colors.DTPanel);
				this.getComponent(5).setBackground(Colors.DTPanel);
			}
		} else {
				if (Parent == "MainWindow") {
					this.setBackground(Color.decode("#F6F6F6"));
					this.getComponent(1).setBackground(Colors.LTBlue);
					JPanel topPanel = (JPanel) this.getComponent(2);
					topPanel.setBackground(Colors.LTBackground);
					topPanel.getComponent(0).setForeground(Color.BLACK); //username (toppanel)
					topPanel.getComponent(2).setForeground(Color.BLACK);
					topPanel.getComponent(3).setForeground(Color.BLACK);
					topPanel.getComponent(4).setForeground(Color.BLACK);
					JPanel listPanel = (JPanel) this.getComponent(3);
					listPanel.setBackground(Colors.LTBackground);
					Heading listPanelH = (Heading) listPanel.getComponent(1);
					listPanelH.line.setBackground(Colors.LTBlue);
					listPanelH.label.setForeground(Color.BLACK);

					JScrollPane listPanelScroll = (JScrollPane) listPanel.getComponent(0);
					Table listPanelTable = (Table) listPanelScroll.getViewport().getComponent(0);
					listPanelTable.setForeground(Color.BLACK);
					listPanelTable.setBackground(Colors.LTBackground);
					listPanelTable.setSelectionBackground(Color.decode("#F6F6F6"));
					listPanelTable.setSelectionForeground(Color.BLACK);
					listPanelTable.getTableHeader().setBackground(Colors.LTBackground);
					
					this.getComponent(4).setBackground(Colors.LTBackground);
					this.getComponent(5).setBackground(Colors.LTBackground); //searchbar foreground?
				}
		}
	}
	
	public void Login(boolean dark, String Parent) {
		if (dark == true) {
			if (Parent == "Login") {
				//DARK THEME
				this.setBackground(Colors.DTBackground);
				Textfield username = (Textfield) this.getComponent(0);
				username.handleFocus(true, username.type, username.name);
				PasswordField password = (PasswordField) this.getComponent(1);
				password.handleFocus(true, password.name);
				this.getComponent(2).setBackground(Colors.DTPurple);
				this.getComponent(3).setForeground(Colors.DTPurple); 
				this.getComponent(6).setForeground(Colors.DTInactive);
				this.getComponent(7).setForeground(Colors.DTInactive);
				this.getComponent(8).setForeground(Colors.DTPurple);
			}
		} else {
			if (Parent == "Login") {
				//LIGHT THEME
				this.setBackground(Colors.LTBackground);
				Textfield username = (Textfield) this.getComponent(0);
				username.handleFocus(false, username.type, username.name);
				PasswordField password = (PasswordField) this.getComponent(1);
				password.handleFocus(false, password.name);
				this.getComponent(2).setBackground(Colors.LTBlue);
				this.getComponent(3).setForeground(Colors.LTBlue);
				this.getComponent(6).setForeground(Colors.LTGray);
				this.getComponent(7).setForeground(Colors.LTGray);
				this.getComponent(8).setForeground(Colors.LTBlue);
			}
		}
	}
	
	public void Register(boolean dark, String Parent) {
		if (dark == true) {
			if (Parent == "Register") {
				//DARK THEME
				this.setBackground(Colors.DTBackground);
				Textfield nickname = (Textfield) this.getComponent(2);
				nickname.handleFocus(true, nickname.type, nickname.name);
				Textfield fullname = (Textfield) this.getComponent(3);
				fullname.handleFocus(true, fullname.type, fullname.name);
				Textfield email = (Textfield) this.getComponent(4);
				email.handleFocus(true, email.type, email.name);
				PasswordField password = (PasswordField) this.getComponent(5);
				password.handleFocus(true, password.name);
				PasswordField rpassword = (PasswordField) this.getComponent(6);
				rpassword.handleFocus(true, rpassword.name);
				this.getComponent(9).setBackground(Colors.DTPurple);
			}
		} else {
			if (Parent == "Register") {
				//LIGHT THEME
				this.setBackground(Colors.LTBackground);
				Textfield nickname = (Textfield) this.getComponent(2);
				nickname.handleFocus(false, nickname.type, nickname.name);
				Textfield fullname = (Textfield) this.getComponent(3);
				fullname.handleFocus(false, fullname.type, fullname.name);
				Textfield email = (Textfield) this.getComponent(4);
				email.handleFocus(false, email.type, email.name);
				PasswordField password = (PasswordField) this.getComponent(5);
				password.handleFocus(false, password.name);
				PasswordField rpassword = (PasswordField) this.getComponent(6);
				rpassword.handleFocus(false, rpassword.name);
				this.getComponent(9).setBackground(Colors.LTBlue);
			}
		}
	}
	
	public void setDarkTheme(JFrame frame, boolean dark) {
		String Parent = frame.getClass().getName();
		Login(dark, Parent);
		Register(dark, Parent);
		MainWindow(dark,Parent);
	}
	public Theme() {
		//nothing
	}
}
