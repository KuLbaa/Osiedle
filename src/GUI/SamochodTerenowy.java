package GUI;

public class SamochodTerenowy extends Pojazd{
	
	boolean Fourx4;
	boolean ZapasoweKoło;

	public SamochodTerenowy(boolean Fourx4, boolean ZapasoweKoło, String Marka, String Model, String VIN, int KonieMechaniczne, int Przebieg, int Rozmiar) {
		super(Marka, Model, Rozmiar);
		this.Fourx4 = Fourx4;
		this.ZapasoweKoło = ZapasoweKoło;
	}
	
	

}
