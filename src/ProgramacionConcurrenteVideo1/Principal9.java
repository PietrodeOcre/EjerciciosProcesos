package ProgramacionConcurrenteVideo1;

import java.io.RandomAccessFile;
import java.util.Random;

public class Principal9 implements Runnable{
	
	private int id;
	private static Random cerrojo = new Random();
	
	public Principal9(int id) {
		this.id = id;
	}
	
	public static int cont = 0;
	public static Object object = new Object();

	public static void main(String[] args) {
		
		Runtime runtime = Runtime.getRuntime();
		int nucleos = runtime.availableProcessors();
		
		Thread[] hilos = new Thread[nucleos];
		for (int i = 0; i < hilos.length; i++) {
			Runnable runnable = new Principal9(i);
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
		
		synchronized(cerrojo) {
			
			try {
				cerrojo.wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			/*while(id !=cont) {
				try {
					cerrojo.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			System.out.println("Soy el hilo: " + id);
			cont++;
			cerrojo.notifyAll();*/
		}
		
		
		
	}

}