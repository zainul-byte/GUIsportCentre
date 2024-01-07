package miniProject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame; //used if extend JFrame
import javax.swing.JButton;

public class mainMenu implements ActionListener{
	//instance members...
	private JFrame frame = new JFrame();
	private JLabel optionMessage = new JLabel("Select an option:");
	private JLabel welcomeLabel = new JLabel();
	private JButton buttonCourt = new JButton("Court Reservation");
	private JButton buttonEquipment = new JButton("Rent Equipments");
	//instance members
	
	//normal contructor...
	public mainMenu(String username) {
		welcomeLabel.setBounds(0, 0, 500, 35);
		welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));
		welcomeLabel.setText("Welcome student, " + username + "!");
		optionMessage.setBounds(125, 50, 150, 50);
		optionMessage.setFont(new Font(null, Font.PLAIN, 15));
		
		//option button...
		buttonCourt.setBounds(125, 100, 150, 50);
		buttonCourt.setFocusable(false);
		buttonCourt.addActionListener(this);
		buttonEquipment.setBounds(125, 200, 150, 50);
		buttonEquipment.setFocusable(false);
		buttonEquipment.addActionListener(this);
		//option button
		
		//add frame...
		frame.add(optionMessage);
		frame.add(buttonCourt);
		frame.add(buttonEquipment);
		frame.add(welcomeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setTitle("Main Menu");
		frame.setLayout(null);
		frame.setVisible(true);
		//add frame
	}
	//normal constructor
	
	//getter and setter...
	public JButton getButtonCourt() {
		return buttonCourt;
	}

	public void setButtonCourt(JButton buttonCourt) {
		this.buttonCourt = buttonCourt;
	}

	public JButton getButtonEquipment() {
		return buttonEquipment;
	}

	public void setButtonEquipment(JButton buttonEquipment) {
		this.buttonEquipment = buttonEquipment;
	}
	//getter and setter
	
	//button action...
	public void actionPerformed(ActionEvent E) {
		if(E.getSource()==buttonCourt) {
			frame.dispose();
			new CourtGUI();
		}
		else if(E.getSource()==buttonEquipment) {
			frame.dispose();
			new EquipmentGUI();
		}
	}
	//button action

}
