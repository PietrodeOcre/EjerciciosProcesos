package ProgramacionConcurrenteVideo1;

import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OtroBuffer implements Runnable{
	
	private int orden, valor;
	
	private static Vector<Integer> elementos =new Vector<Integer>();
	
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition restar = lock.newCondition();
	private static Condition sumar = lock.newCondition();
	
	public OtroBuffer(int orden, int valor) {
		this.orden = orden;
		this.valor = valor;
	}
	
	@Override
	public void run() {
		while(true) {
			lock.lock();
			
			if(orden == 0) {
				restarElemento();
			}else {
				sumarElemento();
			}
			
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();	
		}		
	}
	
	private void restarElemento() {
		while(elementos.isEmpty()) {
			await(restar);
		}
		System.out.println("Se ha extraido el elemento: " + elementos.get(0));
		elementos.remove(0);
		sumar.signal();
		await(restar);
	}
	
	private void sumarElemento() {
		while(elementos.size() >20) {
			await(sumar);
		}
		elementos.add(valor);
		System.out.println("Se ha extraido el elemento: " + elementos.get(elementos.size()-1));
		
		restar.signal();
		await(sumar);
	}
	
	private void await(Condition condition) {
		try {
			condition.await();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
