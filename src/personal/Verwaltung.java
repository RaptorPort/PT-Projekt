package personal;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Verwaltung {
	static int IDcounter = 0;
	private static ArrayList<Angestellter> angestellte = new ArrayList<Angestellter>();
	
	public static void main(String[] args) {
		addAngestellter();
	}
	
	private static void addAngestellter() {
		angestellte.add(getNewPersonInfo());
	}
	
	private static Angestellter getNewPersonInfo() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Name: ");
		String name = scan.nextLine();
		System.out.println("Gehalt: ");
		double gehalt = scan.nextDouble();
		System.out.println("Erster Arbeitstag: ");
		GregorianCalendar datum = new GregorianCalendar(scan.nextInt(), scan.nextInt(), scan.nextInt());
		
		System.out.println("Typ: A = Angestellter, M = Manager");
		scan.nextLine();
		String typ = scan.nextLine();		
		
		switch(typ) {
		case "A":
			System.out.println("Blub? Ficken?");
			return (Angestellter)new Mitarbeiter(name, gehalt, datum, genID());
		case "a":
			return (Angestellter)new Mitarbeiter(name, gehalt, datum, genID());
		case "M":
			return (Angestellter)new Manager(name, gehalt, datum, genID());
		case "m":
			return (Angestellter)new Manager(name, gehalt, datum, genID());
		default:
			System.out.println("\"" + typ + "\" ist kein Valider Typ!");
			return null;
		}	
	}
	
	static int genID() {
		IDcounter++;
		return IDcounter;
	}
}
