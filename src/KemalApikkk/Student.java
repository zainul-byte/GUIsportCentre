package KemalApikkk;

public abstract class Student {
	private String studentName;
	private String studentID;
	private String date;
	private String time;
	
	public Student() {
		studentName = "";
		studentID = "";
		date = "";
		time = "";
	}
	
	public Student (String sN, String ID, String dt, String tm) {
		studentName = sN;
		studentID = ID;
		date = dt;
		time = tm;
	}
	
	public void setstudentName (String sN) {studentName = sN;}
	public void setstudentID (String ID ) {studentID = ID;}
	public void setdate (String dt) {date = dt;}
	public void settime (String tm) {time = tm;}
	
	public String getstudentName () {return studentName;}
	public String getstudentID () {return studentID;}
	public String getdate () {return date;}
	public String gettime () {return time;}
	
	public String toString() {
		return "\n\nName: "+studentName+
				"\nID: "+studentID+
				"\nDate: "+date+
				"\nTime: "+time;
	}
	
	public abstract double calctotal();
}

