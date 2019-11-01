package ProgramacionConcurrenteVideo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.w3c.dom.Element;

public class Aeropuerto implements Runnable{
	
	private Avion avion;
	private static int contDespegar = 0;
	
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition despegar = lock.newCondition();
	private static Condition aparcamiento = lock.newCondition();
	
	public Aeropuerto(Avion avion) {
		this.avion = avion;
	}
	
	public void run() {
		int intencion = avion.getIntencion();
		
		while(true) {
			lock.lock();
			switch (intencion) {
			case 0:
				intencion = avion.nextintencion();
				System.out.println("El avion "+ avion.getId() + " esta volando");
				contDespegar--;
				despegar.signal();
				aparcamiento.signalAll();
				break;
			case 1:
				intencion = avion.nextintencion();
				System.out.println("El avion "+ avion.getId() + " va a aterrizar");
				await(aparcamiento);
				break;
			case 4:
				intencion = avion.nextintencion();
				while(contDespegar>=2) {
					await(aparcamiento);
					System.out.println("El avion "+ avion.getId()+ " ha intentado despegar pero esta llena la cola");
				}
				System.out.println("El avion "+ avion.getId() + " va a pasar a la cola de despegue");
				contDespegar++;
				await(despegar);
				break;

			default:
				intencion = avion.nextintencion();
				System.out.println("El avion "+avion.getId()+" esta en el parking");
				
				break;
			}
			
			try {
				Thread.sleep(5);
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
			
			lock.unlock();

		}

	}
	
	private void await(Condition condition) {
		try {
			condition.await();
		}catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
}
