package ProgramacionConcurrenteVideo1;

import java.util.Random;

import org.omg.Messaging.SyncScopeHelper;

public class Principal4 extends Thread{
	
	private static int tam = 8;
	private static int[] vec = new int[tam];
	private int ini, fin;
	
	public Principal4(int ini, int fin) {
		this.fin = fin;
		this.ini = ini;
	}
	
	public void run() {
		for (int i = ini; i < fin; i++) {
			vec[i] *= 10;
		}
	}
	
	
	public static void main(String[] args) {
		Random rand = new Random(System.nanoTime());
		
		for(int i = 0; i<vec.length; i++) {
			vec[i] = rand.nextInt(10);
		}
		
		Principal4 h1 = new Principal4(0, 4);
		Principal4 h2 = new Principal4(4, 8);
		
		h1.start();
		h2.start();
		
		try {
			
			h1.join();
			h2.join();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		for (int i = 0; i < vec.length; i++) {
			System.out.print(vec[i]+" ");
		}
		
	}
	
}
