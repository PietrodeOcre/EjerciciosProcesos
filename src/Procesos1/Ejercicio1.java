package Procesos1;

public class Ejercicio1 {
	
	
	//SecurityException crea un metodo que va a ejecutar un proceso
	public void ejecutar(String ruta) {
		
		//La clase ProcessBuilder
		ProcessBuilder pb;
		
		try {
			pb = new ProcessBuilder(ruta);
			System.out.println("Ejecuto la Shell");
			
			pb.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		String ruta =  "/usr/bin/xterm";
		
		Ejercicio1 lp = new Ejercicio1();
		
		lp.ejecutar(ruta);
		
		System.out.println("Hemos cerrado la Shell");
		
	}

}
