package miniProject;
import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipmentGUI implements ActionListener{
	//instance members...
	private double price;
	private String equipment;
	private String [] tool = new String[5];
	private String [] fee = new String[5];
	
	private JLabel message = new JLabel("Fill in the details");
	private JLabel studentName = new JLabel("Student's name:");
	private JLabel studentID = new JLabel("Student's ID:");
	private JLabel time = new JLabel("Time:");
	private JLabel date = new JLabel("Date:");
	private JTextField nameField = new JTextField();
	private JTextField idField = new JTextField();
	private JTextField timeField = new JTextField();
	private JTextField dateField = new JTextField();
	
	private JLabel message1 = new JLabel("Choose equipment to reserve:");
	private JButton proceed = new JButton("Proceed");
	private JLabel messageTotal = new JLabel("Total equipments:");
	private JTextField totalField = new JTextField();
	private JCheckBox [] tick = new JCheckBox[5];
	private JFrame frame = new JFrame();
	
	private JFrame frame1 = new JFrame();
	private JLabel messageDetails = new JLabel("Your booking has been recorded!");
	//instance members
	
	//default constructor...
	public EquipmentGUI() {
		//message...
		message.setBounds(50, 25, 200, 25);
		message.setFont(new Font(null, Font.BOLD, 18));
		frame.add(message);
		//message
		
		//fill in the blanks...
		studentName.setBounds(10, 75, 200, 25);
		frame.add(studentName);
		studentID.setBounds(10, 125, 200, 25);
		frame.add(studentID);
		date.setBounds(10, 225, 200, 25);
		frame.add(date);
		time.setBounds(10, 175, 200, 25);
		frame.add(time);
		
		nameField.setBounds(105, 75, 200, 25);
		frame.add(nameField);
		idField.setBounds(105, 125, 200, 25);
		frame.add(idField);
		timeField.setBounds(105, 175, 200, 25);
		frame.add(timeField);
		dateField.setBounds(105, 225, 200, 25);
		frame.add(dateField);
		//fill in the blanks
		
		//message...
		message1.setBounds(10, 280, 300, 45);
		message1.setFont(new Font(null, Font.BOLD, 20));
		frame.add(message1);
		//message
		
		//input hours...
		messageTotal.setBounds(10, 575, 200, 25);
		frame.add(messageTotal);
		totalField.setBounds(115, 575, 100, 25);
		frame.add(totalField);
		//input hours
		
		//button...
		proceed.setBounds(230, 575, 100, 25);
		proceed.setFocusable(false);
		proceed.addActionListener(this);
		frame.add(proceed);
		//button
		
		   BufferedReader in = null;

		   int j=0;
		   
		   try {
			   in = new BufferedReader(new FileReader("D:\\eclipse-workspace\\Mini Project\\src\\miniProject\\equipments.txt"));
			   
			   String inData = null;
			   
			   while((inData=in.readLine())!=null) {
				   StringTokenizer sT = new StringTokenizer(inData, ":");
				   tool[j] = sT.nextToken();
				   fee[j] = sT.nextToken().trim();
				   j++;
			   }
			   
			   int y=300;
			   for(int i=0; i<j; i++) {
				   y+=45;
				   JCheckBox fromString = new JCheckBox(tool[i] + " RM" + fee[i]);
				   tick[i] = fromString;
				   tick[i].setBounds(10, y, 300, 25);
				   tick[i].addActionListener(this);
				   tick[i].setFocusable(false);
				   frame.add(tick[i]);
			   }
			   in.close();
		   }
		   
		   catch(FileNotFoundException fe) {
			   System.out.print(fe.getMessage());
		   }
		   catch(NumberFormatException fe) {
			   System.out.print(fe.getMessage());
		   }
		   catch(Exception e) {
			   System.out.print("Problem: " + e.getMessage());
		   }
		   
		//add frame...
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 700);
		frame.setTitle("Equipment Reservation");
		frame.setLayout(null);
		frame.setVisible(true);
		//add frame
		
	}
	//default constructor
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tick[0]) {
			tick[1].setSelected(false);
			tick[2].setSelected(false);
			tick[3].setSelected(false);
			tick[4].setSelected(false);
		}
		else if(e.getSource()==tick[1]) {
			tick[0].setSelected(false);
			tick[2].setSelected(false);
			tick[3].setSelected(false);
			tick[4].setSelected(false);
		}
		else if(e.getSource()==tick[2]) {
			tick[0].setSelected(false);
			tick[1].setSelected(false);
			tick[3].setSelected(false);
			tick[4].setSelected(false);
		}
		else if(e.getSource()==tick[3]) {
			tick[0].setSelected(false);
			tick[2].setSelected(false);
			tick[1].setSelected(false);
			tick[4].setSelected(false);
		}
		else if(e.getSource()==tick[4]) {
			tick[0].setSelected(false);
			tick[2].setSelected(false);
			tick[3].setSelected(false);
			tick[1].setSelected(false);
		}
		
		for(int i=0; i<5; i++) {
			if(e.getSource()==tick[i]) {
				equipment = tool[i];
				price = Double.parseDouble(fee[i]);
			}
		}
		
		if(e.getSource()==proceed) {
			int totalEQ = Integer.parseInt(totalField.getText());
			
			Student [] sT = new Student[1];
			String name = nameField.getText();
			int id = Integer.parseInt(idField.getText());
			String date = dateField.getText();
			String time = timeField.getText();

			sT[0] = new Equipment(name, id, date, time, equipment, price, totalEQ);
			
			frame.dispose();
			
			PrintWriter receipt = null;
			try {
				receipt = new PrintWriter(new BufferedWriter(new FileWriter("D:\\eclipse-workspace\\Mini Project\\src\\miniProject\\receipt.txt")));
				
				receipt.println("RECEIPT DETAILS");
				receipt.println("=====================");
				
				receipt.println(sT[0].toString());
				if(sT[0] instanceof Equipment) {
					Equipment eQ = (Equipment)sT[0];
					receipt.println("Total: RM" + eQ.calctotal());
					}

				receipt.close();
			}
			catch(FileNotFoundException fe) {
				System.out.println(fe.getMessage());
			}
			catch(NumberFormatException fe) {
				System.out.println(fe.getMessage());
			}
			catch(Exception ex) {
				System.out.println("Problem: " + ex.getMessage());
			}
			
			messageDetails.setBounds(10, 50, 300, 25);
			frame1.add(messageDetails);
			
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setSize(300, 200);
			frame1.setTitle("Receipt");
			frame1.setLayout(null);
			frame1.setVisible(true);
	}
	}
}
