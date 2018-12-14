package personal;
import java.util.GregorianCalendar;

public abstract class Angestellter implements Comparable<Angestellter>, Eigenschaften<Angestellter>{
	
	protected String name;
	protected double gehalt;
	protected GregorianCalendar firstDay;
	protected int ID;
	protected int kleidergroesse = 36;
	
	public Angestellter (String name, double gehalt, GregorianCalendar firstDay, int ID) {
		this.firstDay = firstDay;
		this.gehalt = gehalt;
		this.name = name;
		this.ID = ID;
	}
	
	public void gehaltserhoeung (double prozent) {
		gehalt = gehalt * (prozent/100 + 1);
	}
	
	public abstract double auszahlen();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGehalt() {
		return gehalt;
	}

	public int getID() {
		return ID;
	}
	
	public boolean setKleidergroesse(int g) {
		if (30 <= g && g <= 80) {
			kleidergroesse = g;
			return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Angestellter other) {
	    return Double.compare(this.getGehalt(), other.getGehalt());
	}
	
	@Override
	public abstract String toString();
}
