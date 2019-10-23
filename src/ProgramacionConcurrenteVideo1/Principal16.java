package ProgramacionConcurrenteVideo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.beans.property.ReadOnlyBooleanWrapper;

public class Principal16 implements Runnable{

	private int id;
	private static BufferClas buf = new BufferClas();
	
	public Principal16(int id) {
		this.id = id;
	}
	
	
	
	@Override
	public void run() {
		
		if(id==0) {
			int elemento;
			while(true) {
				elemento = buf.leer();
				System.out.println("El elemento extraido del buffer es: "+elemento);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			while(true) {
				buf.escribir();
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		int nucleos=runtime.availableProcessors();

		ExecutorService poolLector = Executors.newFixedThreadPool(nucleos);
		for(int i = 0; i<nucleos; i++) {
			Runnable runnable = new Principal16(0);
			poolLector.execute(runnable);
		}
		poolLector.shutdown();
		
		ExecutorService poolEscritor = Executors.newFixedThreadPool(2);
		for(int i = 0; i<2; i++) {
			Runnable runnable = new Principal16(1);
			poolEscritor.execute(runnable);
		}
		poolEscritor.shutdown();
		
		while (!poolLector.isTerminated());

	}
	
	

}
