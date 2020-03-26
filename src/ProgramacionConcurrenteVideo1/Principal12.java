package ProgramacionConcurrenteVideo1;



public class Principal12 implements Runnable{
	
	private boolean consumidor;
	private static int tarta = 0;
	private static Object lock = new Object();
	
	public Principal12(boolean consumidor) {
		this.consumidor =  consumidor;
	}

	public static void main(String[] args) {
		
		int numHilos = 11;
		
		Thread[] hilos = new Thread[numHilos];
		
		for (int i = 0; i < hilos.length; i++) {
			
			Runnable runnable = null;
			
			if(i !=0) {
				
				runnable = new Principal12(true);
				
			}else {
				
				runnable = new Principal12(false);
				
			}
			
			hilos[i] = new Thread(runnable);
			
			hilos[i].start();
			
		}
		
		for (int i = 0; i < hilos.length; i++) {
			
			try {
				
				hilos[i].join();
				
			}catch(Exception e) {}
			
		}

	}
	
	

	@Override
	public void run() {
		
		while(true) {
			
			if(consumidor) {
				
				consumir();
				
			}else {
				
				cocinando();
			
			}
			
		}
		
	}

	private void consumir() {
		
		synchronized (lock) {
			if(tarta>0) {
				tarta--; 
				System.out.println("Quedan "+ tarta+ " porciones de la tarta");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				lock.notifyAll();
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	private void cocinando() {
		
		synchronized (lock) {
			
			if(tarta==0) {
				tarta=10;
				System.out.println("Soy el cocinero y quedan mas tartas ");
				lock.notifyAll();
				
			}
			
			try {
				lock.wait();
			}catch ( Exception ex) {}
			
		}
		
	}

}
