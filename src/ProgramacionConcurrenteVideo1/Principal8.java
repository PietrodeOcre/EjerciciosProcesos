package ProgramacionConcurrenteVideo1;

import org.omg.CORBA.TRANSACTION_MODE;

import com.sun.media.jfxmedia.events.NewFrameEvent;

public class Principal8 implements Runnable{
	
	public static int cont = 0;
	public static Object object = new Object();

	public static void main(String[] args) {
		
		Runtime runtime = Runtime.getRuntime();
		int nucleos = runtime.availableProcessors();
		
		Thread[] hilos = new Thread[nucleos];
		for (int i = 0; i < hilos.length; i++) {
			Runnable runnable = new Principal8();
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
		
		System.out.println(cont);
		
	}

	@Override
	public void run() {
		synchronized (object) {
			for (int i = 0; i < 20000; i++) {
			
				cont++;
			}
			
		}
		
	}

}
