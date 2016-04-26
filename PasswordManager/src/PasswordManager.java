import java.awt.*;
import java.awt.Toolkit.*;
import javax.swing.*;

public class PasswordManager extends JFrame {
	
	 PasswordManager() {
		 this.setSize(400,400);
		 		 
		 Toolkit tk = Toolkit.getDefaultToolkit();
		 Dimension dim = tk.getScreenSize();
		 
		 int xPos = (dim.width/2)- (this.getWidth());
		 int yPos = (dim.height/2)-(this.getHeight());
		 
		 this.setLocation(xPos, yPos);
		 this.setResizable(false);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setTitle("Password Manager");
		 
		 JPanel defaultPanel = new JPanel();
		 JLabel lblEnterKey = new JLabel("Please Enter Encryption Key.");
		 JTextField tfKey = new JTextField(20);
		 
		 JTextArea txtAreaPasswords = new JTextArea(15, 20);
		 txtAreaPasswords.setLineWrap(true);
		 txtAreaPasswords.setText(PasswordGenerator.tempPassword);
		 JScrollPane scrollbar1 = new JScrollPane(txtAreaPasswords, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 
		 defaultPanel.add(lblEnterKey);
		 defaultPanel.add(tfKey);
		 defaultPanel.add(scrollbar1);
		 
		 
		 this.add(defaultPanel);
	     this.setVisible(true); 
	}
	
	public static void main(String[] args){

		PasswordGenerator.passwordGen();
		
		System.out.print(PasswordGenerator.tempPassword);
		DataHandler.retrieveData();
		DataHandler.writeData(PasswordGenerator.tempPassword);
		
		new PasswordManager();
	}
	
}
