package miniProject;

public abstract class Student {
	private String studentName;
	private int studentID;
	private String date;
	private String time;
	
	public Student() {
		studentName = "";
		studentID = 0;
		date = "";
		time = "";
	}
	
	public Student (String sN, int ID, String dt, String tm) {
		studentName = sN;
		studentID = ID;
		date = dt;
		time = tm;
	}
	
	public void setstudentName (String sN) {studentName = sN;}
	public void setstudentID (int ID ) {studentID = ID;}
	public void setdate (String dt) {date = dt;}
	public void settime (String tm) {time = tm;}
	
	public String getstudentName () {return studentName;}
	public int getstudentID () {return studentID;}
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
