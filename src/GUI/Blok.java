package GUI;

import java.util.ArrayList;

public class Blok{
	Osiedle osiedle;
	String Miasto;
	String Ulica;
	int Numer;
	ArrayList<Mieszkanie> MieszkaniaB = new ArrayList<Mieszkanie>(); // Ilosc Mieszkan do wynajmu w bloku
	
		public Blok(Osiedle Osiedle, int Numer, String Miasto, String Ulica) {
			
			this.Numer = Numer;
			this.Miasto = Miasto;
			this.Ulica = Ulica;
			this.osiedle = Osiedle;
			
		}
		
		public void DodajMieszkanie(Mieszkanie M) { // Dodaje Mieszaknie do Bloku
			
			MieszkaniaB.add(M);
			
		}
		
		public Osiedle getOsiedle() {
			
			return osiedle;
			
		}
		
		public Mieszkanie SzukajMieszkania(int IDmieszkania) {
			
			for(Mieszkanie i : MieszkaniaB) {
				
				if(i.GetID() == IDmieszkania) {
					
					return i;
					
				}
				
			}
			return null;
			
		}
		
		public ArrayList<Mieszkanie> SzukajWolnychMieszkan(){
			
			ArrayList<Mieszkanie> WM = new ArrayList<Mieszkanie>();
			
			for(Mieszkanie i : MieszkaniaB) {
				
				if(i.WTrakcieWynajmy()==false) {
					
					WM.add(i);
					
				}
				
			}
			
			return WM;
		}
		
		public String toString() {
			
			return Ulica+Numer;
		}
		
		public ArrayList<Mieszkanie> GetMieszkania(){
			
			return MieszkaniaB;
			
		}
}
