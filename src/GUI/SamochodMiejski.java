package GUI;

public class SamochodMiejski extends Pojazd{
	String VIN;
	int KonieMechaniczne;
	int Przebieg; // W km
		public SamochodMiejski(String Marka, String Model, String VIN, int KonieMechaniczne, int Przebieg, int Rozmiar) {
			
			super(Marka, Model, Rozmiar);
			this.KonieMechaniczne = KonieMechaniczne;
			this.Przebieg = Przebieg;
			this.VIN = VIN;
			
		}
		
		public String ToString() {
			
			return "Zaparkowane auto: "+Marka+""+Model;
			
		}
}
