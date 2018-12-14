package personal;

import java.util.GregorianCalendar;

public class Manager extends Angestellter{
	protected double bonus;
	protected String[] speisen = {"Kaviar", "Hummer", "ein ganzes Rind", "Pizza", "Goldbarren, schön knackig heute"};
	
	public Manager(String name, double gehalt, GregorianCalendar firstDay, int ID) {
		super(name, gehalt, firstDay, ID);
	}
	
	public double auszahlen() {
		return super.gehalt + bonus;
	}

	@Override
	public String toString() {
		return "Manager || ID: " + this.ID + " Name: " + this.name + " Gehalt: " + this.getGehalt() + "Bonus: " + this.bonus;
	}
	@Override 
	public String[] getSpeisen() {
		return speisen;
	}
}
