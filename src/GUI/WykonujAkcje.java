package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class WykonujAkcje {
	
	private Osiedle os;
	private boolean CzyKoniec;
	private Osoba AktualnaOsoba;
	private Scanner sc;
	private ArrayList<Osoba> WO;
	private ArrayList<PrzedmiotORozmiarze> POR;
	private ArrayList<Wynajem> WW;
	private PrintWriter write;
	private Mieszkanie m;
	private MiejsceParkingowe MP;
	
		public WykonujAkcje(Osiedle os, ArrayList<Osoba> WO, ArrayList<PrzedmiotORozmiarze> POR, ArrayList<Wynajem> WW) {
			
			this.os = os;
			this.WO = WO;
			this.POR = POR;
			this.WW = WW;
		}
		
		public void WykonujPolecenie() throws ParseException, FileNotFoundException {
			System.out.println();
			System.out.println("Wybierz numer polecenia: | \n \t \t \t V");
			System.out.println("0: Zakoñczenie Programu \n1: Wybierz Osobe \n2: Wypisz Dane Osoby \n3: Wyswietla wolne mieszkania \n4: Wynajecie Mieszkania po uprzednim Wybraniu \n5: Wybranie mieszkania ktore wynajmuje wubrana osoba oraz wyswietlenie jego zawartosci \n6: Wlozenie wybranego z listy przedmiotu \n7: Wyjecie wybranego z listy przedmiotu \n8: Zapisanie Osiedla do pliku");
			int numerPolecenia = sc.nextInt();
			
			switch(numerPolecenia) {
			
			case 0: // Zakoniczenie programu
				CzyKoniec = true;
				System.out.println("Koniec dzialania Porgramu");
				break;
			case 1: // Wybranie osoby
				WybierzOsobe();
				break;
			case 2:
				WypiszDane();
				break;
			case 3:
				WolneMieszkania();
				break;
			case 4:
				WynajmijMieszkanie();
				break;
			case 5:
				WyborMieszkania();
				break;
			case 6:
				WlozPrzedmiot();
				break;
			case 7:
				WyjmijPrzedmiot();
				break;
			case 8:
				ZapiszOsiedle();
				break;
			default:
				System.out.println("B³edny numer lub nie podano ¿adnej opcji");
			}
		}
		
		public void WykonujPolecenia() {
			
			sc = new Scanner(System.in);
			
			while(CzyKoniec == false) {
				
				try {
					WykonujPolecenie();
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				
				catch (FileNotFoundException e) {
					
					System.out.println("Brak Pliku");
					
				}
				
			}
			
			
		}
		
		public void WybierzOsobe() {
			
			System.out.println("Podaj ID osoby");
			int s = sc.nextInt();
			
			for(Osoba i : WO) {
				
				if(s==i.GetID()) {
					
					AktualnaOsoba = i;
					
				}
				
				
			}
			
			System.out.println("Aktualna Osoba: "+AktualnaOsoba);
		}
		public void WypiszDane() {
			
			System.out.println(AktualnaOsoba);
			
		}
		public void WolneMieszkania() {
			
			System.out.println(os.SzukajWolnychMieszkan());
			
		}
		public void WynajmijMieszkanie() throws ParseException {
			System.out.println("Podaj ID mieszkania ktore chcesz wynaj¹c");
			int s = sc.nextInt();	
			Mieszkanie m = os.SzukajMieszkania(s);
			
			if(AktualnaOsoba!=null) {
				
				System.out.println("Podaj daty w formacie dd.MM.yyyy");
				System.out.println("Podaj date rozpoczecia wynajmu");
				String d1 = sc.next();
				System.out.println("Podaj date zakonczenia wynajmu");
				String d2 = sc.next();
				
				
				Date dd1 = FormatDaty.fd.parse(d1);
				Date dd2 = FormatDaty.fd.parse(d2);
				Wynajem RW = m.RozpocznijWynajem(AktualnaOsoba, dd2, dd1);
				WW.add(RW);
			}
			else {
				
				System.out.println("Wybierz osobe");
				
			}
		}
		
		public void WyborMieszkania() {
			
			ArrayList<Mieszkanie> mm = new ArrayList<>();
			
			for(Wynajem i : WW) {
				
				if(AktualnaOsoba == i.najemca) {
					
					mm.add(i.m);
					
				}
				
			}
			
			System.out.println(mm);
			
			System.out.println("Wybierz mieszkanie wpisujac jego ID ni¿ej");
			
			int s = sc.nextInt();
			
			for (Mieszkanie i : mm) {
				
				if(s == i.GetID()) {
					
					m = i;
					System.out.println(m.GetMP());
				}
				
			}
			
		}
		
		public void WlozPrzedmiot() {
			
			PrzedmiotORozmiarze o = null;
			
			if (m.JestMP() == true ) {
				
				MP=m.GetMP();
				System.out.println("To mieszkanie ma miejsce parkingowe wiec mozna wlozyc przdmiot");

				System.out.println("Z listy poni¿ej wybierz numer przedmiot ktory chcesz w³o¿yæ");
				System.out.println(POR);
				int s = sc.nextInt();
				
				for(PrzedmiotORozmiarze i: POR) {
					
					if(i.GetID() == s) {
						
						boolean b = MP.WlozPrzedmiot(i);
						if(b == true)
							o=i;
					}
					
				}
				if(o!=null)
				POR.remove(o);
			}
			else {
				
				System.out.println("Mieszkanie nie posiada miejsca Parkingowego wiec nie mozna nic schowaæ");
				
			}
			
		}
		
		public void WyjmijPrzedmiot() {
			
			PrzedmiotORozmiarze o = null;
			
			System.out.println("Wybierz jeden przedmiot/pojazd z listy poni¿ej wpisujac jego nazwe poni¿ej");
			System.out.println(MP);
			int s = sc.nextInt();
			
			for(PrzedmiotORozmiarze i: MP.GetSchowek()) {
				
				if(i.GetID() == s) {
					o=i;
					}
				}
			if(o!=null) {
			POR.add(o);
			MP.WyjmijPrzedmiot(o);
			m.GetMP().WyjmijPrzedmiot(o);;
			}
		}
		
		public void ZapiszOsiedle() throws FileNotFoundException {
			
			System.out.println("Wprowadz nazwe pliku do ktorego ma byæ zapisane Osiedle");
			String s = sc.next();
			write = new PrintWriter(new File(s));
			write.println(os);
			ArrayList<Blok> b = os.GetBloki();
			write.println(b);
			for (Blok i: b) {
				
				ArrayList<Mieszkanie> m = i.GetMieszkania();
				write.println(i);
				write.println(m);
			}
			write.close();
		}
}
