package KemalApikkk;

public class CourtReservation extends Student{
   private String sport;
   private double courtbill;
   private int hour;
   
   //default 
   public CourtReservation(){
   super();
   sport = "";
   courtbill = 0;
   hour = 0;
   }
   
   //normal
   public CourtReservation(String sN, String ID, String dt, String tm, String sp, double cb, int hr){
   super(sN, ID, dt, tm);
   sport = sp;
   courtbill = cb;
   hour = hr;
   }
   
   //setter
   public void setsport(String sp){sport=sp;}
   public void setcourtbill(double cb){courtbill = cb;}
   public void sethour(int hr){hour=hr;}
   
   //getter
   public String getsport() {return sport;}
   public double getcourtbill() {return courtbill;}
   public int gethour() {return hour;}
   
   public double calctotal() {
		double total = 0;
		
		total = courtbill*hour;
		return total;
	}
   
   //toString
   public String toString(){
      return super.toString()+"\nSport:"+sport+"\nHour: "+hour+"\nCourt Bill: RM"+courtbill;
   }
   }
   
