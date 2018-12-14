package personal;

public interface Eigenschaften<T> {
	int kleidergroesse = 36;
	String[] wunschzettel = {"Gehaltserh�hung", "Schnitzel"};
	String haarfarbe = "schwarz";
	String[] speisen = {"1 Reiskorn", "2 Reisk�rner", "3 Reisk�rner", "mehrKorn", "UniCorn"};
	
	default int getKleidergroesse() {
		return kleidergroesse;
	}
	
	default String[] getWunschzettel() {
		return wunschzettel;
	}
	
	default String getHaarfarbe() {
		return haarfarbe;
	}
	
	default String[] getSpeisen() {
		return speisen;
	}
	
	default String SpeisentoString() {
		String out = "";
		for (String i : getSpeisen()) {
			out += i + ", ";
		}
		return out;
	}
	
	boolean setKleidergroesse(int g);
}
