 package miniProject;
 import java.util.*;
 import java.io.*;

public class courtReservation extends Student{
	//instance members...
	private String sport;
	private double courtbill;
	private double hour;
	//instance members
	
	//default constructor...
	public courtReservation() {
		super();
		sport = "";
		courtbill = 0;
		hour = 0;
	}
	//default constructor
	
	//normal constructor...
	public courtReservation(String sN, int ID, String dt, String tm, String sp, double cb, double hr){
	   super(sN, ID, dt, tm);
	   sport = sp;
	   courtbill = cb;
	   hour = hr;
	}
	//normal constructor

	   //setter
	   public void setsport(String sp){sport=sp;}
	   public void setcourtbill(double cb){courtbill = cb;}
	   public void sethour(double hr){hour=hr;}
	   
	   //getter
	   public String getsport() {return sport;}
	   public double getcourtbill() {return courtbill;}
	   public double gethour() {return hour;}
	   
	   public double calctotal() {
			double total = 0;
			
			total = courtbill*hour;
			return total;
		}
	   
	   //toString
	   public String toString(){
	      return super.toString()+"\nSport:"+sport+"\nHour: "+hour+"\nCourt Bill: "+courtbill;
	   }
}
