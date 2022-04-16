package GUI;

public class Pojazd implements PrzedmiotORozmiarze{
	String Marka;
	String Model;
	int Rozmiar;
	private static int Count = 1;
	private int NumerID;
	
	public Pojazd(String Marka, String Model, int Rozmiar) {
		
		this.Marka = Marka;
		this.Model = Model;
		this.Rozmiar = Rozmiar;
		NumerID = Count++;
	}

	@Override
	public int GetRozmiar() {
		return Rozmiar;
	}
	
	public void Zaparkuj(Pojazd S, MiejsceParkingowe p) {
		
		p.PojazdNaParkingu = S;
		
	}
	
	public void Odjedz(MiejsceParkingowe p) {
		
		p.PojazdNaParkingu = null;
		
	}
	
	public String toString() {
		
		return NumerID+": "+Marka +" "+Model;
		
	}
	
	public int GetID() {
		
		return NumerID;
		
	}
}
