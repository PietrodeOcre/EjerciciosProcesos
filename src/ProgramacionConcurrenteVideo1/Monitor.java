package ProgramacionConcurrenteVideo1;

public class Monitor {
	
	private int cont = 0;
	private int order = 0;
	
	public synchronized int inc(int num) {		
		for (int i = 0; i < num; i++) {
			cont++;
		}
		return cont;
	}
	
	public synchronized void ordenar(int id) {		
		while (id!=order) {			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
		System.out.println("Soy el hilo: "+id);
		order++;
		notifyAll();		
	}	
}