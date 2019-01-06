package PT_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Reader {
	
	ArrayList<String> headSet;
	TreeSet<String> baum;
	FileReader fr;
	BufferedReader buffr;
	int[] anz;
	StringBuilder filename;

	public static void main(String[] args) {
		Reader hallo = new Reader();
		hallo.auslesen();
		hallo.anzahl();
		hallo.ausgabeInfo();
		try
		{
		hallo.buffr.close();
		}
		catch( IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public Reader()
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Dateiname eingeben:");
			String name = sc.nextLine();
			filename = new StringBuilder(name);
			baum = new TreeSet<String>();
			headSet = new ArrayList<String>();
		
			fr = new FileReader(filename.toString());
			buffr = new BufferedReader(fr);
		}
		catch( IOException e)
		{
			try
			{
			buffr.close();
			e.printStackTrace();
			}
			catch(IOException ee)
			{
				ee.printStackTrace();
			}
		}
	}
	
	public Reader(String name)
	{
		try
		{
		filename = new StringBuilder(name);
		baum = new TreeSet<String>();
		headSet = new ArrayList<String>();
		
		fr = new FileReader(filename.toString());
		buffr = new BufferedReader(fr);
		}
		catch( IOException e)
		{
			try
			{
			buffr.close();
			e.printStackTrace();
			}
			catch(IOException ee)
			{
				ee.printStackTrace();
			}
		}
	}
	
	public void auslesen()
	{
		try
		{
		StringBuilder line = new StringBuilder();
		while(this.buffr.ready())
			{
				line.append(this.buffr.readLine());
				eintragen(line);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void eintragen(StringBuilder line)
	{
		while(line.length()!=0)
		{
			String wort = split(line);
			wort = this.killZeichen(wort);
			this.baum.add(wort);
			this.headSet.add(wort);
		}
		
	}
	
	public String split(StringBuilder line)
	{
		int anf, end;
		anf = 0;
		end = line.indexOf(" ");
		if(end < 0)
			end = line.length();
		String wort = line.substring(anf, end);
		line.delete(anf, end+1);
		if(line.length() == 0)
		{
			return wort;
		}
		return wort;
	}
	
	public String killZeichen(String wort)
	{
		for(int i = 0; i< wort.length(); i++)
		{
			char hilfe = wort.charAt(i);
			if(!Character.isAlphabetic(hilfe) && !Character.isDigit(hilfe))
			{
				wort = wort.replace("" + hilfe, "");
			}
		}
		return wort.toString();
	}
	
	public void ausgabe()
	{
		for(String wort: this.baum)
		{
				System.out.println(wort);
		}
	}

	public void ausgabeInfo()
	{
		System.out.println("Anzahl Wörter: " + anz[1] + "\nAnzahl unterschiedlicher Wörter: " + anz[0]);
		ausgabe();
	}
	
	public void anzahl()
	{
		anz = new int[2];
		anz[0] = this.baum.size();
		anz[1] = this.headSet.size();
	}
}


