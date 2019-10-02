package ProgramacionConcurrenteVideo1;

public class Principal3 extends Thread {
	
	private static int cont = 0;
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			cont++;
		}
	}
	
	/*
	 * Indeterminismo es que se acceda a una
	 * variable compartida y que muchos hilos 
	 * accedan a ella cuando quiere.
	 * 
	 * Seccion Critica es donde se encuentra 
	 * indeterminismo
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Principal3[] vec = new Principal3[1000];
		
		for(int i=0; i<vec.length; i++) {
			vec[i]= new Principal3();
			vec[i].start();
			try {
				vec[i].join();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		System.out.println(cont);
		
	}

}
