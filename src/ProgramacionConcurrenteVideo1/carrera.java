package ProgramacionConcurrenteVideo1;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class carrera implements Runnable {
	
	private int id;

	
	private double inicio, total;
	private Random rand = new Random(System.nanoTime());

	private static double[][] tiempos;
	private static CyclicBarrier barrera;
	
	public carrera(int i) {
		this.id = i;

	}
	
	public static void setCarrera(int participantes) {
		tiempos = new double[participantes][4];
		barrera = new CyclicBarrier(participantes);
	}

	@Override
	public void run() {
		
		etapa(0);
		etapa(1);
		etapa(2);
		
		tiempos[id][3] = tiempos[id][0] + tiempos[id][1] + tiempos[id][2];
		
	}
	
	private void etapa(int numEtapa) {
		inicio = System.nanoTime();
		
		try {
			Thread.sleep(rand.nextInt(100) + 100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		total = System.nanoTime() - inicio;
		
		tiempos[id][numEtapa] =  total;
		
		try {
			barrera.await();
			barrera.reset();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static double[][] getTiempos(){
		return tiempos;
	}

}
