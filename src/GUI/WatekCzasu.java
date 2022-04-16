package GUI;

public class WatekCzasu extends Thread {
	Osiedle os;
	
	public WatekCzasu(Osiedle os) {
		
		this.os = os;
		
	}
	
	public void run() {
		
		while (true) {
				System.out.println();
					Data.DodajJedenDzien();
				try {
					Thread.sleep(5000);
					
				} catch (InterruptedException e1) {
					
					e1.printStackTrace();
				}
		
		}
	}	
}