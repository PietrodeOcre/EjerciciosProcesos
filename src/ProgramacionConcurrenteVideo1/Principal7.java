package ProgramacionConcurrenteVideo1;

import java.util.Random;
import java.lang.Math.*;

public class Principal7 extends Thread{

	private static int tam = 15;
	private static int[][] matriz = new int[tam][tam];
	private int inicio, fin;
	
	public Principal7 (int inicio, int fin) {
		this.inicio=inicio;
		this.fin=fin;
		
	}
	
	public void run() {
		
		for (int i = inicio; i < fin; i++) {
			
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] *= 10;
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		Runtime ordena = Runtime.getRuntime();
		
		int nucleos = ordena.availableProcessors();
		
		//System.out.println(nucleos);
		
		Random random = new Random(System.nanoTime());
		
		double tiempo_inicio, tiempo_final;
		
		for(int i = 0; i< matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				
				matriz[i][j] = random.nextInt(10);
				
			}
		}
		
		tiempo_inicio = System.nanoTime(); //Hora en nano segundos
		
		
		Thread[] hilos = new Thread[nucleos];
		
		int rango = tam/nucleos;
		int start = 0;
		int fin = rango;
		
		for (int i = 0; i < nucleos; i++) {
			
			
			if(i!= nucleos-1) {
				hilos[i] = new Principal7(start, fin);
			
				hilos[i].start();
				start = fin;
				fin += Math.ceil(rango);
			}else {
				hilos[i] = new Principal7(start, tam);
				hilos[i].start();
			}
					
			

			try {
				hilos[i].join();
	
			}catch(Exception e) {
				
			}
			
		}
		
		tiempo_final = System.nanoTime() - tiempo_inicio;
		
		System.out.println(tiempo_final/1000000 + " milisegundos");
		
		
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println("");
		}
		
	}

	
}
