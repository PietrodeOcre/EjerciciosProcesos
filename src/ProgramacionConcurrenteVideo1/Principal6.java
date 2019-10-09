package ProgramacionConcurrenteVideo1;

import java.util.Random;

public class Principal6 extends Thread{
	
	private static int tam = 800;
	private static int[][] matriz = new int[tam][tam];
	private int inicio, fin;
	
	public Principal6 (int inicio, int fin) {
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
		
		Random random = new Random(System.nanoTime());
		
		double tiempo_inicio, tiempo_final;
		
		for(int i = 0; i< matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				
				matriz[i][j] = random.nextInt(10);
				
			}
		}
		
		tiempo_inicio = System.nanoTime(); //Hora en nano segundos
		
		Principal6 h1 = new Principal6(0, 199);
		Principal6 h2 = new Principal6(200, 399);
		Principal6 h3 = new Principal6(400, 599);
		Principal6 h4 = new Principal6(600, 800);

		h1.start();
		h2.start();
		h3.start();
		h4.start();
		
		try {
			h1.join();
			h2.join();
			h3.join();
			h4.join();
		}catch(Exception e) {
			
		}
		
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
