package GUI;

import java.util.Date;

public class Data {

		private static Date data = new Date();
		
		public static Date GetDate() {
			
			return data;
			
		}
		
		public static void DodajJedenDzien() {
			
			long l = data.getTime();
			long d = l+24*3600*1000;
			data = new Date(d);
			System.out.println("Data zosta³a zmienona o jeden dzien: "+data+"\n");
		}
}
