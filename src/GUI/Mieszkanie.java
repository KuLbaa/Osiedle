package GUI;

import java.util.ArrayList;
import java.util.Date;

public class Mieszkanie {
	
	private static int Count = 1;
	private int NumerID;
	double ObjetoscM; // Wyrazona w cm3
	int iloscP; // Ilosc Pokoi
	Blok blok; // Blok w jakim jest mieszkanie
	//Osiedle Osiedle; // Osiedle na jakim jest mieszkanie
	private MiejsceParkingowe MP;
	ArrayList<Osoba> OsobyM = new ArrayList<Osoba>(); // Lista osob mieszkajacych w tym mieszkaniu
	Osoba Najemca; // Osoba która op³aca rachunki
	Wynajem aktualny;
	
	
		public Mieszkanie(double ObjetoscM, int iloscP, Blok Blok) {
			
			this.ObjetoscM = ObjetoscM;
			this.iloscP = iloscP;
			this.blok = Blok;
			OsobyM.add(Najemca);
			NumerID = Count++;
			
			if(Blok.getOsiedle() != null) {
				
				MP = new MiejsceParkingowe();
				
			}
			
		}
		
		public int GetID() {
			
			return NumerID;
			
		}
		
		public void Zamelduj(Osoba osoba) { // Dodaje osobe do mieszakania
			
			OsobyM.add(osoba);
			
		}
		
		public void Wypelduj(Osoba osoba) { // Usuwa osobe z mieszkania
			
			OsobyM.remove(osoba);
			
		}
		
		public void ZmienNajemce(Osoba osoba) { // Zmiana osoby p³acacej/odpowiedzalnej za wynajem
			
			OsobyM.remove(osoba);
			OsobyM.add(0, osoba);
			
		}
		
		public void ZakonczWynajem() { // Koniec wynajmu - czysze liste osob mieszkajacych
			
			OsobyM.clear();
			
		}
		
		public void CzyJestMP() { // Czy jest dostepne miejsce parkingowe
			
			if(MP != null) {
				
				System.out.println("To mieszkanie posiada miejsce parkingowe. Jego rozmiar to "+ MP.Powierzchnia);
				
			}
			else {
				
				System.out.println("To mieszkanie nie posiada miejsca parkingowego");
				
			}
			
		}
		
		public boolean JestMP() {
			
			if(MP != null) {
				
				return true;
			}
			else {
				
				return false;
				
			}
			
		}
		
		public MiejsceParkingowe GetMP() {
			
			return MP;
			
		}
		
		public String toString() {
			
			return "Mieszkanie nr: "+ NumerID;
			
		}
		
		public Wynajem RozpocznijWynajem(Osoba o, Date dz, Date dr) {
			
			Najemca = o;
			aktualny = new Wynajem(this, o, dr, dz);
			System.out.println("Rozpoczal sie wynajem: "+aktualny);
			return aktualny;
		}
		
		public boolean WTrakcieWynajmy() {
			
			if(aktualny!=null) {
				
				return aktualny.aktualny();
				
			}
			
			return false;
			
			
		}

}
