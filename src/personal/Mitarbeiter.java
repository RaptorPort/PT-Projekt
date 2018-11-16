package personal;

import java.util.GregorianCalendar;

public class Mitarbeiter extends Angestellter {

	public Mitarbeiter(String name, double gehalt, GregorianCalendar firstDay, int ID) {
		super(name, gehalt, firstDay, ID);
	}
	
	public double auszahlen() {
		return gehalt;
	}

}
