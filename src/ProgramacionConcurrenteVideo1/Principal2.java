package ProgramacionConcurrenteVideo1;

public class Principal2 extends Thread{
	
	private int id;
	
	public Principal2 ( int id) {
		this.id = id;
	}
	
	public void run(){
		System.out.println("Soy el hilo: "+id);
	}

	//Hilo principal
	public static void main(String[] args) {
		
		Principal2[] vec = new Principal2[5];
		
		for (int i = 0; i<vec.length; i++) {
			vec[i] = new Principal2(i+1);
			vec[i].start();//Ejecuta el hilo
			try {
				vec[i].join();//Ejecuta el hilo antes que el principal
			}catch(Exception e) {
				
			}
		}
		
		System.out.println("Soy el hilo principal");
		
	}

}
