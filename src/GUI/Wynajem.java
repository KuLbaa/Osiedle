package GUI;

import java.util.ArrayList;
import java.util.Date;

public class Wynajem {
	
	Mieszkanie m;
	Osoba najemca;
	Date DataPoczatkowa;
	Date DataZakonczenia;
	
	public Wynajem(Mieszkanie m, Osoba najemca, Date DataPoczatkowa, Date DataZakonczenia) {
		
		this.m = m;
		this.najemca = najemca;
		this.DataPoczatkowa = DataPoczatkowa;
		this.DataZakonczenia = DataZakonczenia;
	}
	
	public boolean aktualny() {
		
		Date n = Data.GetDate();
		
		if(n.after(DataPoczatkowa) && n.before(DataZakonczenia)) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
		
	}
	


	@Override
	public String toString() {
		return "Wynajem [m=" + m + ", najemca=" + najemca + ", DataPoczatkowa=" + DataPoczatkowa + ", DataZakonczenia="
				+ DataZakonczenia + "]";
	}

	
	
}
