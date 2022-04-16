package GUI;

import java.io.File;
import java.util.Date;

public class Osoba {
	private String imie;
	private String nazwisko;
	private String PESEL;
	private String adres;
	private Date DataUr;
	private int NumerID;
	private File file;
	private static int Count = 1;
	
	public Osoba(String imie, String nazwisko, String PESEL, String adres) {
		
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.PESEL = PESEL;
		this.adres = adres;
		NumerID = Count++;
		
	}
	
	
	public void Schowaj(PrzedmiotORozmiarze t, MiejsceParkingowe p) {
		
		p.Schowek.add(t);
		
	}
	
	public void Wyciagnij(PrzedmiotORozmiarze t, MiejsceParkingowe p) {
		
		p.Schowek.remove(t);
		
	}
	
	public String toString() {
		
		return imie + " " + nazwisko + " PESEL: " + PESEL + " Adres: " + adres;
		
	}
	
	public int GetID() {
		
		return NumerID;
		
	}
	
	

}
