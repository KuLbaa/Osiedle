package GUI;

import java.util.ArrayList;

public class Osiedle {
	String Nazwa;
	String Miasto;
	ArrayList<Blok> BlokiO = new ArrayList<Blok>(); // Ilosc Blokow na osiedlu
		
		public Osiedle(String Miasto, String Nazwa) {
				
			this.Miasto = Miasto;
			this.Nazwa = Nazwa;
			
		}
		
		public void DodajBlok(Blok B) { // Dodaje Blok do Osiedla
			
			BlokiO.add(B);
			
		}
		
		public String toString() {
			
			return "Osiedle "+Nazwa+" w "+Miasto;
			
		}
		
		public Mieszkanie SzukajMieszkania(int IDmieszkania) {
			
			for(Blok i : BlokiO) {
				
				Mieszkanie s = i.SzukajMieszkania(IDmieszkania);
				
				if(s!=null) {
					
					return s;
					
				}
				
			}
			
			return null;
			
		}
		
		public ArrayList<Blok> GetBloki(){
			
			return BlokiO;
			
		}
		
		public ArrayList<Mieszkanie> SzukajWolnychMieszkan(){
			
			ArrayList<Mieszkanie> WWM = new ArrayList<Mieszkanie>();
			
			for(Blok i : BlokiO) {
				
				ArrayList<Mieszkanie> WM = new ArrayList<Mieszkanie>();
				WM = i.SzukajWolnychMieszkan();
				WWM.addAll(WM);
			}
			return WWM;
		}
}
