package personal;

import java.util.GregorianCalendar;

public class Manager extends Angestellter{
	protected double bonus;
	
	public Manager(String name, double gehalt, GregorianCalendar firstDay, int ID) {
		super(name, gehalt, firstDay, ID);
	}
	
	public double auszahlen() {
		return super.gehalt + bonus;
	}
}
