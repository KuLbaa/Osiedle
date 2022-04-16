package GUI;

import java.util.ArrayList;

public class MiejsceParkingowe {
	
	private static int Count = 1;
	private int NumerID;
	int Powierzchnia;
	int WolnaPowierzchnia;
	Pojazd PojazdNaParkingu;
	ArrayList<PrzedmiotORozmiarze> Schowek = new ArrayList<PrzedmiotORozmiarze>();
	
		public MiejsceParkingowe() {
			
			this.Powierzchnia = 150;
			WolnaPowierzchnia=Powierzchnia;
			NumerID = Count++;
			
			
		}
		
		public void ShowID() {
			
			System.out.println(NumerID);
			
		}
		
		public void ZaparkowaneAuto() {
			if(PojazdNaParkingu == null) {
				
				System.out.println("Brak zaparkowanego auta");
				
			}
			else {
				
				System.out.println(PojazdNaParkingu);
				
			}
			
			
		}
		
		public String toString() {
			
			return "Miejsce numer: "+NumerID +Schowek;
			
		}
		
		public boolean WlozPrzedmiot(PrzedmiotORozmiarze s) {
			
			if(s.GetRozmiar() <= WolnaPowierzchnia) {
				
				Schowek.add(s);
				WolnaPowierzchnia -= s.GetRozmiar();
				return true;
			}
			else {
				
				System.out.println("Nie uda³o siê zmieœciæ przedmiotu. Wyjmij jakiœ aby zwolniæ miejsce");
				return false;
			}
			
			
		}
		
		public void WyjmijPrzedmiot(PrzedmiotORozmiarze s) {
			
			Schowek.remove(s);
			WolnaPowierzchnia += s.GetRozmiar();
			
		}
		
		public ArrayList<PrzedmiotORozmiarze> GetSchowek(){
			
			return Schowek;
			
		}
	

}
