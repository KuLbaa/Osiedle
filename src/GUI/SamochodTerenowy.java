package GUI;

public class SamochodTerenowy extends Pojazd{
	
	boolean Fourx4;
	boolean ZapasoweKo�o;

	public SamochodTerenowy(boolean Fourx4, boolean ZapasoweKo�o, String Marka, String Model, String VIN, int KonieMechaniczne, int Przebieg, int Rozmiar) {
		super(Marka, Model, Rozmiar);
		this.Fourx4 = Fourx4;
		this.ZapasoweKo�o = ZapasoweKo�o;
	}
	
	

}
