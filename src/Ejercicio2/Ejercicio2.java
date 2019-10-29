package Ejercicio2;

import java.util.Scanner;

public class Ejercicio2 extends Thread{
	/*
	 * creo una variable statica para guardar la palabra
	 */
	private static String palabra;
	/*
	 * Creo un constructor para poder guardar la palabra desde el nuevo hilo en el 
	 * atributo
	 */
	public Ejercicio2 (String palabra) {
		this.palabra=palabra;
	}

	public static void main(String[] args) {
		System.out.println("Escribe una palabra: ");
		/*
		 * Creo un hilo que inicializa el constructor de la clase padre
		 * con el string que devuelve el metodo pidePalabra()
		 */
		Thread hilo1 = new Ejercicio2(pedirPalabra());
		/*
		 * Ejecuto el hilo1
		 */
		hilo1.start();
		try {
			/*
			 * Lo sinconizo con el proceso padre para que en ningun caso el 
			 * padre termine antes que el hijo.
			 */
			hilo1.join();
		}catch (Exception e) {
			
		}
		/*
		 * Imprimimos el atributo que devuelve el hilo, es decir,
		 * ya en mayusculas desde el padre y termina el proceso padre
		 */
		System.out.println("Palabra cambiada: "+ palabra);
		System.out.println("Hilo padre terminado.");
	}
	/*
	 * Metodo que devuelve un String que se pide por consola 
	 * al usuario
	 */
	public static String pedirPalabra() {
		Scanner sc = new Scanner(System.in);
		String palabra = sc.nextLine();
		return palabra;
	}

	@Override
	public void run() {
		/*
		 * Desde el Run pasamos al atributo el valor del mismo pero 
		 * pasado a mayusculas, puesto que es static se guarda 
		 * el ultimo cambio y queda en mayusculas terminando ahí. 
		 */
		palabra = palabra.toUpperCase();
		System.out.println("Soy el hilo hijo cambiando la palabra y he terminado.");
	}

}
