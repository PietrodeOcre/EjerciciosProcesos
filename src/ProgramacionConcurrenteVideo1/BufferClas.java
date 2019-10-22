package ProgramacionConcurrenteVideo1;

import java.util.Random;
import java.util.Vector;
import java.util.PrimitiveIterator.OfDouble;

public class BufferClas {

	private Random random = new Random(System.nanoTime());
	
	private int tam = 10;
	private int pos = -1;
	private Vector<Integer> cola = new Vector();
	
	public synchronized int leer() {
		int elemento = -1;
		if(pos<0) {
			System.out.println("El vector esta vacio y el consumidor se va a dormir.");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			elemento = cola.get(pos);
			cola.remove(pos);
			pos--;
		}
		return elemento;
		
	}
	public synchronized void escribir() {
		pos++;
		
		if(pos>=tam) {			
			try {
				System.out.println("El vector esta lleno");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pos--;
		}else {
			cola.add(generar());
			notifyAll();
		}	
	}
	public synchronized int generar() {
		return random.nextInt(10);
	}
	
	
	
}
