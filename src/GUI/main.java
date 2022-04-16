package GUI;

import java.io.PrintWriter;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		
		
		ArrayList<Osoba> WszystkieOsoby = new ArrayList<Osoba>();
		ArrayList<PrzedmiotORozmiarze> WszystkiePrzedmioty = new ArrayList<PrzedmiotORozmiarze>();
		ArrayList<Wynajem> WszystkieWynajmy = new ArrayList<>();

		
		Osoba person = new Osoba("Jakub", "Nowak", "87021786351", "Chopina 2");
		Osoba person1 = new Osoba("Maciej", "Grzyb", "99121734376", "Asnyka 65");
		Osoba person2 = new Osoba("Natalia", "Kochan", "99031386452", "Chopina 2");
		Osoba person3 = new Osoba("Antek", "Pustelnik", "67123787519", "Okrezna 322");
		Osoba person4 = new Osoba("Janek", "Fabianski", "76023681936", "Litewska 87");
		
		Motocykl motor = new Motocykl("BMW", "1000SR", 30, 60);
		SamochodMiejski samochod = new SamochodMiejski("Toyota", "Supra", "12738678423", 350, 7000, 100);
		Lodz lodka = new Lodz("BMW", "250XSR", 6, 140);
		WszystkiePrzedmioty.add(motor);
		WszystkiePrzedmioty.add(samochod);
		WszystkiePrzedmioty.add(lodka);
		
		WszystkieOsoby.add(person);
		WszystkieOsoby.add(person1);
		WszystkieOsoby.add(person2);
		WszystkieOsoby.add(person3);
		WszystkieOsoby.add(person4);
		
		Osiedle osiedle = new Osiedle("Warszawa", "Kabackie");
		
		WykonujAkcje WK = new WykonujAkcje(osiedle, WszystkieOsoby, WszystkiePrzedmioty, WszystkieWynajmy);
		
		Blok blok = new Blok(osiedle, 23, "Warszawa", "Chopina 2");
		Blok blok1 = new Blok(osiedle, 24, "Warszawa", "Chopina 2");
		Blok blok2 = new Blok(null, 1, "Warszawa", "Okrezna 322");
		
		Mieszkanie m = new Mieszkanie(180, 6, blok);
		Mieszkanie m3 = new Mieszkanie(190, 6, blok);
		Mieszkanie m4 = new Mieszkanie(280, 26, blok);
		Mieszkanie m1 = new Mieszkanie(90, 4, blok1);
		Mieszkanie m2 = new Mieszkanie(60, 3, blok2);
		
		osiedle.DodajBlok(blok);
		osiedle.DodajBlok(blok1);
		osiedle.DodajBlok(blok2);
		
		blok.DodajMieszkanie(m);
		blok.DodajMieszkanie(m3);
		blok.DodajMieszkanie(m4);
		blok1.DodajMieszkanie(m1);
		blok2.DodajMieszkanie(m2);
	
		WatekCzasu WC = new WatekCzasu(osiedle);
		WatekCzasu2 WC2 = new WatekCzasu2(osiedle);
		WC.start();
		WC2.start();
		WK.WykonujPolecenia();
	}

}
