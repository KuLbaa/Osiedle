package GUI;

public class WatekCzasu2 extends Thread {
	Osiedle os;
	
	public WatekCzasu2(Osiedle os) {
		
		this.os = os;
		
	}
	
	public void run() {
		
		while (true) {
					System.out.println("Wolne mieszkania: \n"+os.SzukajWolnychMieszkan()+"\n");
				try {
					Thread.sleep(10000);
					
				} catch (InterruptedException e1) {
					
					e1.printStackTrace();
				}
		
		}
	}	
}