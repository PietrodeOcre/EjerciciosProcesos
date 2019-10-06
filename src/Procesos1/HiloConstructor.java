package Procesos1;

public class HiloConstructor extends Thread{
	
	private int id;
	
	public HiloConstructor(HiloConstructor h) {
		
	}

	public HiloConstructor(int id) {
		this.id = id;
	}
	
	public void run() {
		System.out.println("Soy el hilo: "+id);
	}

	public static void main(String[] args) {
		
		HiloConstructor h1 = new HiloConstructor(1);
		HiloConstructor h2 = new HiloConstructor(2);
		
		h2.start();
		h2(h1);
		
		System.out.println("Hilo principal!");
		
	}

	private static void h2(HiloConstructor h1) {
		h1.start();
		
	}

}
