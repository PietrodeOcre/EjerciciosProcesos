package ProgramacionConcurrenteVideo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
 * carrera ciclista 100 ciclistas antes de que comience la siguiente 
 * etapa todos los demas ciclistas deben haber llegado.
 * Medir tiempo de cada ciclista y mostrar quien ha ganado y tal de tiempos
 */


public class Principal15 {

	public static void main(String[] args) {
		
		int participantes = 100;
		
		Runtime runtime = Runtime.getRuntime();
		int nucleos = runtime.availableProcessors();
		
		ExecutorService pool = Executors.newFixedThreadPool(nucleos);
		for (int i = 0; i < participantes; i++) {
			Runnable runnable = new carrera(i, participantes);
			pool.execute(runnable);
		}
		
	}
	
}
