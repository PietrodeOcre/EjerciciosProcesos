package ProgramacionConcurrenteVideo1;

public class Principal17 {

	public static void main(String[] args) {
		
		Runtime runtime = Runtime.getRuntime();
		int nucleos = runtime.availableProcessors();
		
		Thread[] vec = new Thread[nucleos];
		
		lanzarSynchro(vec);
		esperarHilos(vec);
		System.out.println(Synchro.getCont());
		
		vec = new Thread[nucleos];
		
		lanzarAtomic(vec);
		esperarHilos(vec);
		System.out.println(Atomic.getCont());
		
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
