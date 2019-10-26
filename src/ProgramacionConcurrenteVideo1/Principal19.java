package ProgramacionConcurrenteVideo1;

import java.util.Random;



public class Principal19 {
	
	public static void main(String[] args) {
		Random random = new Random(System.nanoTime());
		Thread[] vec = new Thread[30];
		for (int i = 0; i < vec.length; i++) {
			int orden = random.nextInt(2);
			Runnable runnable = new OtroBuffer(orden, 1);
			vec[i] =new Thread(runnable);
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
