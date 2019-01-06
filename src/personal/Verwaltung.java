package personal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class Verwaltung {
	static int IDcounter = 0;
	static int genCounter = 0;
	
	private static ArrayList<Angestellter> angestellteList = new ArrayList<Angestellter>();
	private static HashMap<Angestellter, Manager> angestellte = new HashMap<Angestellter, Manager>();
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++)
			addAngestellter(genNewPersonInfo());
		angestellte.keySet().forEach(a->System.out.println(a.toString()));
		Angestellter a = maxGehalt();
		System.out.println("Angestellter mit höchstem Gehalt: " + a.toString());
		a = minGehalt();
		System.out.println("Angestellter mit niedrigstem Gehalt: " + a.toString());
		System.out.println("Sortiert:");
		sortAngestellte();
		angestellteList.forEach(b->System.out.println(b.toString() + b.SpeisentoString()));
		delAngestellter(2);
		System.out.println("Delete ID 2:");
		angestellte.keySet().forEach(b->System.out.println(b.toString() + b.SpeisentoString()));
		System.out.println("");
		Pair<Manager> m = minmaxManager();
		
		System.out.println("ManagerMax: " + m.getFirst().toString() );
		System.out.println("ManagerMin: " + m.getSecond().toString());
	}
	
	private static void addAngestellter(Angestellter a) {
		if (a instanceof Mitarbeiter) {
			Angestellter temp = null;
			int managerID = ((Mitarbeiter)a).getVorgesetzter();
			for(Angestellter m : angestellte.keySet()) {
				if (m.ID == managerID) {
					temp = m;
					break;
				}
			}
			if (temp != null && temp instanceof Manager) {
				angestellte.put(a, (Manager)temp);
			} else {
				System.out.println("Manager does not exist with ID " + ((Mitarbeiter)a).getVorgesetzter());
			}
		} else {
			angestellte.put(a, null);
		}
	}
	
	private static void delAngestellter(int ID) {
		Angestellter del = null;
		for(Angestellter m : angestellte.keySet()) {
			if (m.ID == ID) {
				del = m;
				break;
			}
		}
		angestellte.values().removeAll(Collections.singleton(del));
		angestellte.remove(del);
	}

	private static void sortAngestellte() {
		angestellteList.clear();
		angestellteList.addAll(angestellte.keySet());
		Collections.sort(angestellteList);
	}
	
	private static Angestellter maxGehalt() {
		return Collections.max(angestellte.keySet());
	}
	
	private static Angestellter minGehalt() {
		return Collections.min(angestellte.keySet());
	}
	
	private static Pair<Manager> minmaxManager() {
		ArrayList<Manager> m = new ArrayList<Manager>();
		for(Angestellter i: angestellte.keySet()) {
			if(i instanceof Manager) {
				m.add((Manager)i);
			}
		}
		return new Pair<Manager>((Manager)Collections.max(m), (Manager)Collections.min(m));
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
		System.out.println("Vorgesetzten ID: ");
		int vorgesetzterID = scan.nextInt();
		
		System.out.println("Typ: A = Angestellter, M = Manager");
		scan.nextLine();
		String typ = scan.nextLine();		
		scan.close();
		switch(typ) {
		case "A":
			return (Angestellter)new Mitarbeiter(name, gehalt, datum, genID(), vorgesetzterID);
		case "a":
			return (Angestellter)new Mitarbeiter(name, gehalt, datum, genID(), vorgesetzterID);
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
				return (Angestellter)new Manager("Bob der Baumeister", 4200, new GregorianCalendar(2017, 12, 13), genID());
			case 2:
				return (Angestellter)new Mitarbeiter("Max", 1200, new GregorianCalendar(2018, 1, 1), genID(), 1);
			case 3:
				return (Angestellter)new Mitarbeiter("Blub", 690, new GregorianCalendar(2018, 2, 7), genID(), 2);
		}
		return null;
	}
	
	static int genID() {
		IDcounter++;
		return IDcounter;
	}
}
