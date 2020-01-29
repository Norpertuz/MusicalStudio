import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class optionPane {
	ResourceBundle res= ResourceBundle.getBundle("lang_PL"); 
	JFrame f;  
	optionPane(){  
		if(GlobalVariables.jezyk==1)res = ResourceBundle.getBundle("lang_PL");
		if(GlobalVariables.jezyk==0)res = ResourceBundle.getBundle("lang_EN");
	f=new JFrame();   
	
	GlobalVariables.name=JOptionPane.showInputDialog(f,res.getString("studio_name")); 
	
	
	
}
}