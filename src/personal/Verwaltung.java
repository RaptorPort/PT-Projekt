package personal;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Verwaltung {
	static int IDcounter = 0;
	static int genCounter = 0;
	
	private static ArrayList<Angestellter> angestellte = new ArrayList<Angestellter>();
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++)
			addAngestellter(genNewPersonInfo());
		delAngestellter(1);
		angestellte.forEach(a->System.out.println("ID: " + a.ID + " Name: " + a.name + " Gehalt : " + a.getGehalt()));
		Angestellter a = maxGehalt();
		System.out.println("Angestellter mit h�chstem Gehalt: ID: " + a.ID + " Name: " + a.name + " Gehalt : " + a.getGehalt());
		a = minGehalt();
		System.out.println("Angestellter mit niedrigstem Gehalt: ID: " + a.ID + " Name: " + a.name + " Gehalt : " + a.getGehalt());
	}
	
	private static void addAngestellter(Angestellter a) {
		angestellte.add(a);
	}
	
	private static void delAngestellter(int ID) {
		angestellte.removeIf(a-> a.ID == ID);
	}
	
	private static Angestellter maxGehalt() {
		return Collections.max(angestellte);
	}
	
	private static Angestellter minGehalt() {
		return Collections.min(angestellte);
	}
	
	private static boolean doppeltVorhanden() {
		return false;
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
	
	private static Angestellter genNewPersonInfo() {
		genCounter++;
		switch (genCounter) {
			case 1:
				return (Angestellter)new Mitarbeiter("Max", 1200, new GregorianCalendar(2018, 1, 1), genID());
			case 2:
				return (Angestellter)new Manager("Bob der Baumeister", 4200, new GregorianCalendar(2017, 12, 13), genID());
			case 3:
				return (Angestellter)new Mitarbeiter("Blub", 690, new GregorianCalendar(2018, 2, 7), genID());
		}
		return null;
	}
	
	static int genID() {
		IDcounter++;
		return IDcounter;
	}
}
