package KemalApikkk;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class projectAPP {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		BufferedReader in = null;
		DecimalFormat pr = new DecimalFormat("#.00");
		
		int size = 0;
		System.out.print("\nEntre array size: ");
		size = scan2.nextInt();
		Student stu[] = new Student [size];
		
		for(int i = 0; i<size; i++) {
		System.out.print("\nEnter Student Name: ");
		String name = scan.nextLine();
		System.out.print("Enter Student ID: ");
		String id = scan.nextLine();
		System.out.print("Enter Date: ");
		String date = scan.nextLine();
		System.out.print("Enter Time: ");
		String time = scan.nextLine();
		
		//pilih equipment rental agiteww choice nti
		
		String[] eqptxt = new String[5];
		double[] pricetxt = new double[5];
		int k = 0;
		try {
			in = new BufferedReader(new FileReader("D:\\eclipse-workspace\\Mini Project\\src\\KemalApikkk\\equipments.txt"));
		
			String inData = null;
				System.out.println("LIST OF EQUPMENT AVAILABLE:");
				System.out.println("   Name\t\t Price");
			while((inData = in.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(inData,":");
				eqptxt[k] = st.nextToken();
				pricetxt[k] = Double.parseDouble(st.nextToken().trim());
				k++;
			}
			
			for (int j = 0; j<k ; j++) {
				System.out.println(j+1+". "+eqptxt[j]+"\t RM"+pr.format(pricetxt[j]));
			}
			
			System.out.println("Enter Index of Desired Equipment [1-5]: ");
			int choice = scan2.nextInt();
			String eqp = eqptxt[choice-1];
			double	price = pricetxt[choice-1];
			
			System.out.print("Enter Quantity: ");
			int quantity = scan2.nextInt();
			
			// store onto array sini
			stu[i] = new EquipmentRental (name,id,date,time,eqp, price,quantity);
		
			in.close();
			}
		
		catch(FileNotFoundException fe) {System.out.print(fe.getMessage());}
		catch(NumberFormatException fe) {System.out.print(fe.getMessage());}
		catch(Exception e) 				{System.out.print("problem: "+e.getMessage());}
		
		}
		
		double total = 0, grandtot = 0;
		for (int h = 0;h<size;h++){
			System.out.print(stu[h].toString());
			total = stu[h].calctotal();
			grandtot += stu[h].calctotal();
		}System.out.print("\n\nTotal equipment rental: RM"+pr.format(grandtot));
}}

