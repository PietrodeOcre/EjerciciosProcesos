package Tema1;

public class ArranqueHilos{
	
	public static void main(String args[]) {
		new ArranqueHilos2(); // Crea un nuevo hilo de ejecución
		System.out.println("Hola desde el hilo principal!");
		System.out.println("Proceso acabando.");
	}
	
}	
	
	
class ArranqueHilos2 implements Runnable {

	Thread t;
	ArranqueHilos2() {
		t = new Thread(this, "Nuevo Thread");
		System.out.println("Creado hilo: " + t);
		t.start(); // Arranca el nuevo hilo de ejecución. Ejecuta run
	}
	public void run() {
		System.out.println("Hola desde el hilo creado!");
		System.out.println("Hilo finalizando.");
	}
}
