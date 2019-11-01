package ProgramacionConcurrenteVideo1;

import java.util.Random;

public class Principal20 {

	public static void main(String[] args) {
		
		Random rand = new Random(System.nanoTime());
		Thread[] vec = new Thread[30];
		
		for(int i = 0; i < vec.length; i++) {
			int intencion = rand.nextInt(5);
			Avion avion = new Avion(i, intencion);
			
			Runnable run = new Aeropuerto(avion);
			vec[i] = new Thread(run);
			vec[i].start();
		}
		
		try {
			for (int i = 0; i < vec.length; i++) {
				vec[i].join();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
