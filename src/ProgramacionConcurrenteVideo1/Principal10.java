package ProgramacionConcurrenteVideo1;

import java.util.Random;

public class Principal10 implements Runnable{
	
	private int id;
	private static Random cerrojoA = new Random();
	private static Thread cerrojoB = new Thread();
	
	public Principal10(int id) {
		this.id = id;
	}
	
	public static int cont = 0;
	public static Object object = new Object();

	public static void main(String[] args) {
		
		Runtime runtime = Runtime.getRuntime();
		int nucleos = runtime.availableProcessors();
		
		Thread[] hilos = new Thread[nucleos];
		for (int i = 0; i < hilos.length; i++) {
			Runnable runnable = new Principal10(i);
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
		
		System.out.println("Soy el hilo principal");
		
	}

	@Override
	public void run() {
		
		if(id %2 ==0) {
			
			synchronized (cerrojoA) {
				mostrarA();
			}
		}else {
			synchronized (cerrojoB) {
				mostrarB();
			}	
		}
		/*
		 * Hay que tratar siempre de no cruzar los hilos para 
		 * evitar el interbloqueo.
		 */
	}

	private void mostrarA() {
		
		synchronized (cerrojoB) {
			System.out.println("Soy el hilo: " + id);
		}
		
	}
	
	private void mostrarB() {
		
		synchronized (cerrojoB) {
			System.out.println("Soy el hilo: " + id);
		}
		
	}

}