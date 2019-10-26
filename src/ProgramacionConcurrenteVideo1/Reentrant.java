package ProgramacionConcurrenteVideo1;

import java.util.concurrent.locks.ReentrantLock;

public class Reentrant implements Runnable{
	
	private static ReentrantLock cerrojo = new ReentrantLock();
	private static int cont = 0;
	
	private boolean condicion = true;
		
	@Override
	public void run() {
		
		cerrojo.lock();
		
		/*if(condicion) {
			cerrojo.unlock();
		}*/
		
		for (int i = 0; i < 100000; i++) {
			cont++;
		}
		
		cerrojo.unlock();
	}

	public static int getCont() {
		return cont;

	}
}
