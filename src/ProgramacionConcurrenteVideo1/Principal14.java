package ProgramacionConcurrenteVideo1;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal14 implements Runnable{
	private int fila;
	private static int tam = 20000;
	private static int[][] matriz = new int[tam][tam];
	private int inicio, fin;
	
	public Principal14(int fila) {
		this.fila = fila;
	}

	public void run() {
		
		for (int i = 0; i < tam; i++) {
			matriz[fila][i] *=10;
		}
		
	}

	public static void main(String[] args) {
		
		
		Random random = new Random(System.nanoTime());

		double tiempo_inicio, tiempo_final;
		
		for(int i = 0; i< matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				
				matriz[i][j] = random.nextInt(10);
				
			}
		}
		
		tiempo_inicio = System.nanoTime(); //Hora en nano segundos
		
		//ExecutorService pool = Executors.newFixedThreadPool(8);
		//ExecutorService pool = Executors.newCachedThreadPool();
		ExecutorService pool = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < tam; i++) {
			Runnable runnable = new Principal14(i);
			pool.execute(runnable);
			
		}
		
		pool.shutdown();
		
		while(!pool.isTerminated());
		
		/*
		
		Thread[] hilos = new Thread[tam];
		
		for (int i = 0; i < hilos.length; i++) {
			
			Runnable runnable = new Principal14(i);
			hilos[i] = new Thread(runnable);
			hilos[i].start();

		}
		
		for (int i = 0; i < hilos.length; i++) {
			try {
				hilos[i].join();
	
			}catch(Exception e) {
				
			}
		}
		*/
		tiempo_final = System.nanoTime() - tiempo_inicio;
		
		System.out.println(tiempo_final/1000000 + " milisegundos");
		
		
		
		/*for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println("");
		}*/
		
	}

}
