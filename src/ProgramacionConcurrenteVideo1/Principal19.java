package ProgramacionConcurrenteVideo1;

import java.util.Random;



public class Principal19 {
	
	public static void main(String[] args) {
		Random rand = new Random(System.nanoTime());
		Thread[] vec = new Thread[30];
		for (int i = 0; i < vec.length; i++) {
			int orden = rand.nextInt(2);
			Runnable run = new OtroBuffer(orden, i);
			vec[i] =new Thread(run);
			vec[i].start();
		}
		try {
			for (int i = 0; i < vec.length; i++) {
				vec[i].join();
			}
		}catch(Exception e) {
			
		}

		
	}
	
}
