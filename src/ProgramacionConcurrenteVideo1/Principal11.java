package ProgramacionConcurrenteVideo1;

import java.util.Random;

public class Principal11 implements Runnable{
	
	private int id;
	private static int cont_private;
	private static Random cerrojoA = new Random();
	private static Thread cerrojoB = new Thread();
	private int cont;
	
	public Principal11(int id) {
		this.id = id;
	}


	public static void main(String[] args) {
		
		
		double tiempo_inicio, tiempo_final;
		
		tiempo_inicio = System.nanoTime(); //Hora en nano segundos
		
		
		Runtime runtime = Runtime.getRuntime();
		int nucleos = runtime.availableProcessors();
		
		Thread[] hilos = new Thread[nucleos];
		for (int i = 0; i < hilos.length; i++) {
			Runnable runnable = new Principal11(i);
			hilos[i] = new Thread(runnable);
			hilos[i].start();
			
		}
		
		
		
		for (int i = 0; i < hilos.length; i++) {
			try {
				hilos[i].join();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		tiempo_final = System.nanoTime() - tiempo_inicio;
		
		System.out.println(tiempo_final/1000000 + " milisegundos");
		
		System.out.println("Soy el hilo principal");
		
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 20000; i++) {
			
			cont_private++;

		}
		
		synchronized (cerrojoA) {
			cont += cont_private;
		}
		
	}

}