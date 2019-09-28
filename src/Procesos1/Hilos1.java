package Procesos1;

public class Hilos1 extends Thread{

	public static void main(String[] args) {
		/*
		 * heredamos de la clase thread y ponemos el metodo run() 
		 * creamos una variable int id privada
		 * creamos un constructor principal con args id
		 * creamos unstancias dela clase en main 
		 * lanzamos hilos en forma de objeto.start()
		 * lanamos los hilos
		 * 
		 * 
		 * */
		
		Hilos1 hilos1 = new Hilos1(1);
		Hilos1 hilos2 = new Hilos1(2);
		Hilos1 hilos3 = new Hilos1(3);
		Hilos1 hilos4 = new Hilos1(4);
		Hilos1 hilos5 = new Hilos1(5);
		Hilos1 hilos6 = new Hilos1(6);
		Hilos1 hilos7 = new Hilos1(7);
		Hilos1 hilos8 = new Hilos1(8);
		Hilos1 hilos9 = new Hilos1(9);
		Hilos1 hilos10 = new Hilos1(10);
		
		System.out.println("Soy el hilo principal ");
		
		hilos1.start();
		hilos2.start();
		hilos3.start();
		hilos4.start();
		hilos5.start();
		hilos6.start();
		hilos7.start();
		hilos8.start();
		hilos9.start();
		hilos10.start();

		
		
	}
	
	public void run() {
		System.out.println("Soy el hilo de ejecución: " + id);
		
	}
	
	private int id;
	
	public Hilos1(int id) {
		this.id = id;
	}
	

}
