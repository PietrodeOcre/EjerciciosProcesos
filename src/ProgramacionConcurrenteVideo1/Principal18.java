package ProgramacionConcurrenteVideo1;

import java.rmi.server.RemoteObjectInvocationHandler;

public class Principal18 {

	public static void main(String[] args) {
		
		Runtime runtime = Runtime.getRuntime();
		int nucleos = runtime.availableProcessors();
		//Synchro
		Thread[] vec = new Thread[nucleos];
		
		lanzarSynchro(vec);
		esperarHilos(vec);
		System.out.println(Synchro.getCont());
		//Atomic
		vec = new Thread[nucleos];
		
		lanzarAtomic(vec);
		esperarHilos(vec);
		System.out.println(Atomic.getCont());
		//Reentrant
		vec = new Thread[nucleos];
		
		lanzarReentrant(vec);
		esperarHilos(vec);
		System.out.println(Reentrant.getCont());
	}
	
	private static void lanzarReentrant(Thread[] vec) {
		
		for (int i = 0; i < vec.length; i++) {
			Runnable run = new Reentrant();
			vec[i] = new Thread(run);
			vec[i].start();
		}
		
	}

	private static void lanzarSynchro(Thread[] vec) {
		for (int i = 0; i < vec.length; i++) {
			Runnable run = new Synchro();
			vec[i] = new Thread(run);
			vec[i].start();
		}
	}
	
	private static void lanzarAtomic(Thread[] vec) {
		for (int i = 0; i < vec.length; i++) {
			Runnable run = new Atomic();
			vec[i] = new Thread(run);
			vec[i].start();
		}
	}
	
	private static void esperarHilos(Thread[] vec) {
		try {
			for (int i = 0; i < vec.length; i++) {
				vec[i].join();
			}
		}catch(Exception e) {}
	}

}
