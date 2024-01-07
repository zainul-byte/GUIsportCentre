package KemalApikkk;
import java.io.*;
import java.util.*;

public class CourtEquipment {     public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    Scanner scan1 = new Scanner(System.in);
    
    BufferedReader in = null;
    
       int size = 0;
    		System.out.print("\nEnter array size: ");
    		size = scan1.nextInt();
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
          
          String[] sportxt = new String[6];
		      double[] pricetxt = new double[6];
		      int j = 0;
       
       try{
          in = new BufferedReader(new FileReader("D:\\eclipse-workspace\\Mini Project\\src\\KemalApikkk\\court.txt"));
          
          String inData = null;
          System.out.println("--List of Court Available--");
          System.out.println("Court\t\tprice");
          
          while((inData = in.readLine()) != null){
          StringTokenizer st = new StringTokenizer(inData,";");
          sportxt[j] = st.nextToken();
          pricetxt[j] = Double.parseDouble(st.nextToken().trim());
          j++;
          }
          
          for (int k = 0; k<j ; k++) {
				System.out.println(k+1+". "+sportxt[k]+"\t RM"+(pricetxt[k]+" per hour"));
 			}
 			
 			System.out.println("Enter Court choice [1-6]: ");
 			int choice = scan1.nextInt();
 			String sport = sportxt[choice-1];
 			double price = pricetxt[choice-1];
 			
 			System.out.print("Enter Hour: ");
 			int hour = scan1.nextInt();
 			
 			// store onto array
 			stu[i] = new CourtReservation (name,id,date,time,sport,price,hour);
       
          in.close();
          }
          
          catch(FileNotFoundException fe){
          System.out.println(fe.getMessage());
          }
          catch(NumberFormatException fe){
             System.out.println(fe.getMessage());
             }
             catch(Exception e){
             System.out.println("Problem:"+e.getMessage());
             }
             
          }//endMain
          
          double total = 0, grandtot = 0;
       		for (int l = 0; l<size; l++){
       			System.out.print(stu[l].toString());
       			total = stu[l].calctotal();
       			grandtot += stu[l].calctotal();
       		}
             System.out.print("\n\nTotal Court Reservation: RM"+grandtot);
             
             }
}
