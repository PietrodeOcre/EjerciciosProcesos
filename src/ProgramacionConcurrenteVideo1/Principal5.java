package ProgramacionConcurrenteVideo1;

public class Principal5 extends Thread{
	
	private static int cont = 0;
	
	
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			cont++;
		}
	}
	
	
	public static void main(String[] args) {
		
		Principal5 h1 = new Principal5();
		Principal5 h2 = new Principal5();
		Principal5 h3 = new Principal5();
		Principal5 h4 = new Principal5();
		
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		try {
			h1.join();
			h2.join();
			h3.join();
			h4.join();
		}catch (Exception e) {
			
		}
		
		System.out.println(cont);
		
		

	}

}
