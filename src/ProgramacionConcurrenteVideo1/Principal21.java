package ProgramacionConcurrenteVideo1;


import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Principal21 {

	public static void main(String[] args) {
		
		Runtime runtime = Runtime.getRuntime();
		int nucleos = runtime.availableProcessors();
		int cont = 0;
		
		ExecutorService executor = Executors.newFixedThreadPool(nucleos);
		Vector<Future<Integer>> vec = new Vector();
		
		for (int i = 0; i < nucleos; i++) {
			Future<Integer> future = executor.submit(new Hilo());
			vec.add(future);
			
 		}
		
		executor.shutdown();
		
		for (int i = 0; i < nucleos; i++) {
			Future<Integer> future = vec.get(i);
			try {
				cont += future.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("El resultado de cont es: " + cont);
		
	}

}
