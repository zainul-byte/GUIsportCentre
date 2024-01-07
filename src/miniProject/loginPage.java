package miniProject;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class loginPage implements ActionListener{
	//instance members...
	private JFrame frame = new JFrame();
	private JButton loginButton = new JButton("Login");
	private JButton resetButton = new JButton("Reset");
	private JTextField usernameField = new JTextField();
	private JPasswordField userPasswordField = new JPasswordField();
	private JLabel uitmLabel = new JLabel("Welcome to UiTM Perlis Sport Centre!");
	private JLabel usernameLabel = new JLabel("Username:");
	private JLabel userPasswordLabel = new JLabel("Password:");
	private JLabel messageLabel = new JLabel();
	private HashMap<String, String> loginInfo = new HashMap<String, String>();
	//instance members
	
	//normal constructors...
	public loginPage(HashMap<String, String> LI) {
		loginInfo = LI;
		
		//label(x, y, width, height)...
		uitmLabel.setFont(new Font(null, Font.BOLD, 18));
		uitmLabel.setBounds(30, 0, 500, 100);
		usernameLabel.setBounds(50, 100, 75, 25); 
		userPasswordLabel.setBounds(50, 150, 75, 25);
		//label(x, y, length, height)
		
		//popup messages...
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		//popup messages
		
		//input field...
		usernameField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		//input field
		
		//button...
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.setFocusable(false); //clear small box around the text
		loginButton.addActionListener(this); //action performed
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.setFocusable(false); //clear small box around the text
		resetButton.addActionListener(this); //action performed
		//button
		
		//to make the label and button visible...
		frame.add(uitmLabel);
		frame.add(usernameLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(usernameField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setTitle("Login Page");
		frame.setLayout(null);
		frame.setVisible(true);
		//to make the label and button visible
		
	}
	//normal constructors
	
	//user interaction...
	public void actionPerformed(ActionEvent aE) {
		//reset to null...
		if(aE.getSource()==resetButton) {
			usernameField.setText("");
			userPasswordField.setText("");
		}
		//reset to null
		
		if(aE.getSource()==loginButton) {
			String username = usernameField.getText();
			String password = String.valueOf(userPasswordField.getPassword()); //convert JPassword into string
			
			//check info from PasswordID...
			if(loginInfo.containsKey(username)) {
				if(loginInfo.get(username).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login succussful!");
					frame.dispose();
					mainMenu mM = new mainMenu(username);
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password!");
				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found!");
			}
			//check info from PasswordID
		}
	}
	//user interaction

}
