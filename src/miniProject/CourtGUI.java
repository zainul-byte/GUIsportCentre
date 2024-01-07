package miniProject;
import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourtGUI implements ActionListener{
	//instance members...
	private double courtBill;
	private String sport;
	private String [] court = new String[6];
	private String [] fee = new String[6];
	
	private JLabel message = new JLabel("Fill in the details");
	private JLabel studentName = new JLabel("Student's name:");
	private JLabel studentID = new JLabel("Student's ID:");
	private JLabel time = new JLabel("Time:");
	private JLabel date = new JLabel("Date:");
	private JTextField nameField = new JTextField();
	private JTextField idField = new JTextField();
	private JTextField timeField = new JTextField();
	private JTextField dateField = new JTextField();
	
	private JLabel message1 = new JLabel("Choose court to reserve:");
	private JButton proceed = new JButton("Proceed");
	private JLabel messageHours = new JLabel("Total hours:");
	private JTextField hoursField = new JTextField();
	private JCheckBox [] tick = new JCheckBox[6];
	//private JLabel [] item = new JLabel[6];
	private JFrame frame = new JFrame();
	
	private JFrame frame1 = new JFrame();
	private JLabel messageDetails = new JLabel("Your booking has been recorded!");
	//instance members
	
	//default constructors...
	public CourtGUI() {
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
		messageHours.setBounds(10, 615, 200, 25);
		frame.add(messageHours);
		hoursField.setBounds(85, 615, 100, 25);
		frame.add(hoursField);
		//input hours
		
		//button...
		proceed.setBounds(200, 615, 100, 25);
		proceed.setFocusable(false);
		proceed.addActionListener(this);
		frame.add(proceed);
		//button
		
		   BufferedReader in = null;

		   int j=0;
		   
		   try {
			   in = new BufferedReader(new FileReader("D:\\eclipse-workspace\\Mini Project\\src\\miniProject\\court.txt"));
			   
			   String inData = null;
			   
			   while((inData=in.readLine())!=null) {
				   StringTokenizer sT = new StringTokenizer(inData, ";");
				   court[j] = sT.nextToken();
				   fee[j] = sT.nextToken().trim();
				   j++;
			   }
			   
			   int y=300;
			   for(int i=0; i<j; i++) {
				   y+=45;
				   JCheckBox fromString = new JCheckBox(court[i] + " RM" + fee[i]);
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
		frame.setTitle("Court Reservation");
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
			tick[5].setSelected(false);
		}
		else if(e.getSource()==tick[1]) {
			tick[0].setSelected(false);
			tick[2].setSelected(false);
			tick[3].setSelected(false);
			tick[4].setSelected(false);
			tick[5].setSelected(false);
		}
		else if(e.getSource()==tick[2]) {
			tick[0].setSelected(false);
			tick[1].setSelected(false);
			tick[3].setSelected(false);
			tick[4].setSelected(false);
			tick[5].setSelected(false);
		}
		else if(e.getSource()==tick[3]) {
			tick[0].setSelected(false);
			tick[2].setSelected(false);
			tick[1].setSelected(false);
			tick[4].setSelected(false);
			tick[5].setSelected(false);
		}
		else if(e.getSource()==tick[4]) {
			tick[0].setSelected(false);
			tick[2].setSelected(false);
			tick[3].setSelected(false);
			tick[1].setSelected(false);
			tick[5].setSelected(false);
		}
		else if(e.getSource()==tick[5]) {
			tick[0].setSelected(false);
			tick[2].setSelected(false);
			tick[3].setSelected(false);
			tick[4].setSelected(false);
			tick[1].setSelected(false);
		}
		
		for(int i=0; i<6; i++) {
			if(e.getSource()==tick[i]) {
				sport = court[i];
				courtBill = Double.parseDouble(fee[i]);
			}
		}
		
		if(e.getSource()==proceed) {
			double totalHours = Double.parseDouble(hoursField.getText());
			
			Student [] sT = new Student[1];
			String name = nameField.getText();
			int id = Integer.parseInt(idField.getText());
			String date = dateField.getText();
			String time = timeField.getText();

			sT[0] = new courtReservation(name, id, date, time, sport, courtBill, totalHours);
			
			frame.dispose();
			
			PrintWriter receipt = null;
			try {
				receipt = new PrintWriter(new BufferedWriter(new FileWriter("D:\\eclipse-workspace\\Mini Project\\src\\miniProject\\receipt.txt")));
				
				receipt.println("RECEIPT DETAILS");
				receipt.println("=====================");
				
				receipt.println(sT[0].toString());
				if(sT[0] instanceof courtReservation) {
					courtReservation cR = (courtReservation)sT[0];
					receipt.println("Total: RM" + cR.calctotal());
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
