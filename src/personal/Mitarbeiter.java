package personal;

import java.util.GregorianCalendar;

public class Mitarbeiter extends Angestellter {
	
	int vorgesetzterID;

	public Mitarbeiter(String name, double gehalt, GregorianCalendar firstDay, int ID, int vorgesetzterID) {
		super(name, gehalt, firstDay, ID);
		this.vorgesetzterID = vorgesetzterID;
	}
	
	public double auszahlen() {
		return gehalt;
	}
	
	public int getVorgesetzter() {
		return vorgesetzterID;
	}

	@Override
	public String toString() {
		return "Mitarbeiter || ID: " + this.ID + " Name: " + this.name + " Gehalt: " + this.getGehalt();
	}
}
