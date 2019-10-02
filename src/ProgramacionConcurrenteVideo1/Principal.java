package ProgramacionConcurrenteVideo1;



/*
 * Para lanzar hilos se hereda de Thread
 * Los hlos no se tienen que lanzar cuando se lanzan
 * No sabemos el orden de ejecucion de los hilos
 * Los hilos planifican
 */
public class Principal extends Thread{
	
	private int id;
	
	public Principal(int id) {
		this.id = id;
	}
	
	public void run() {
		System.out.println("Soy el hilo: "+id);
	}
	
	/*
	 * El hiloprincipal seria el que ejecuta lo 
	 * que hay en el main
	 * */
	public static void main(String[] args) {
		
		Principal h1 = new Principal(1);
		Principal h2 = new Principal(2);
		
		
		h1.start();//Se crea un nuevo hilo
		h2.start();
		try {
			h2.join();
			h1.join();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Soy el hilo principal!");
		
		

	}
	
	

}
