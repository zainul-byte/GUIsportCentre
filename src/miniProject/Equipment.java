package miniProject;

public class Equipment extends Student{
	private String equipment;
	private double price;
	private int quantity;
	
	public Equipment (){
		super();
		equipment = "";
		price = 0;
	}
	
	public Equipment (String sN, int ID, String dt, String tm, String eqp, double pr, int qt) {
		super(sN,ID,dt,tm);
		equipment = eqp;
		price = pr;
		quantity = qt;
	}
	
	public void setequipment (String eqp) {equipment = eqp;}
	public void setprice (double pr) {price = pr;}
	public void setquantity (int qt) {quantity = qt;}
	
	public String getequipment() {return equipment;}
	public double getprice() {return price;}
	public int getquantity() {return quantity;}
	
	public double calctotal() {
		double total = 0;
		
		total = price*quantity;
		return total;
	}
	public String toString() {
		return super.toString()+ "\nEquipment: "+equipment+
				"\nPrice per piece: RM"+price+
				"\nQuantity# : "+quantity;
	}
	
}

