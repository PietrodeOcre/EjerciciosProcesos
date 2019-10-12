package ProgramacionConcurrenteVideo1;

public class Principal13 implements Runnable{
	
	private int id;
	private static Monitor mon = new Monitor();
	
	public Principal13(int id) {
		this.id =id;
	}

	@Override
	public void run() {
		int cont = mon.inc(20000);
		System.out.println(cont);
		mon.ordenar(id);
	}
	
	public static void main(String[] args) {		
		Runtime runtime = Runtime.getRuntime();
		int nucleos = runtime.availableProcessors();		
		Thread[] hilos = new Thread[nucleos];		
		for (int i = 0; i < hilos.length; i++) {
			Runnable runnable = new Principal13(i);
			hilos[i] = new Thread(runnable);
			hilos[i].start();			
		}
		
		for (int i = 0; i < hilos.length; i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
}