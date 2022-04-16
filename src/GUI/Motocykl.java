package GUI;

public class Motocykl extends Pojazd{
	
	int iloscKol;
	
	public Motocykl(String Marka, String Model, int iloscKol, int Rozmiar) {
		
		super(Marka, Model, Rozmiar);
		this.iloscKol = iloscKol;
		
	}

}
