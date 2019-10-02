package Procesos1;



public class Ejercicio3 extends Thread {


	private int id;

	public Ejercicio3(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("Soy el hilo: "+id);
	
	}

	/*
	 * El hilo 2 siempre se ejecuta antes que el hilo 1
	 * y el hilo principal se ejecuta el ultimo
	 * */
	public static void main(String[] args) {

		Ejercicio3 h2 = new Ejercicio3(2);
		Ejercicio3 h1 = new Ejercicio3(1);
		
		h2.start();

		try {
			
			h2.join();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		h1.start();
		
		try {
			
			h1.join();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		

		System.out.println("Soy el hilo principal!");



	}
}
