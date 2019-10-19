package EjercicioHilos1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 extends Thread{
	
	/*
	 * defino las variables que me hacen falta para
	 * la ejecucion de todos lso hilos
	 */
	private String palabra;
	private int num;
	
	private static int numPalabra;
	
	private int suma;

	/*
	 * Creo un constructor que usara unicamente el hilo 2
	 */
	public Ejercicio2(int numPalabra, int num) {
		this.num=num;
		/*
		 * En este constructor llamamos a un metodo
		 * que suma el numero que ya esta guardado 
		 * desde que se ejecuto el otro constructor
		 * es decir el tamaño de la palabra y el numero 
		 * que le damos desde el metodo pideNum()
		 */
		sumar();
	}
	
	/*
	 * Creo un constructor que usara unicamente el hilo 1
	 */
	public Ejercicio2(String palabra) {
		this.palabra=palabra;
		/*En el propio contructor doy a una variable 
		 * definida anteriormente
		 * el valor de la palabra que recive este 
		 * contructor mediante el metodo pideCaracteres()
		 */
		this.numPalabra = palabra.length();
	}

	/*
	 * Este metodo sera usado por el hilo 1
	 * para pedirnos por la entrada estandar 
	 * un string
	 */
	public static String pideCaracteres() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Escribe una palabra: ");
		
		String palabra = scanner.next();
		//Indico el hilo donde se ejecuta
		System.out.println("Soy el hilo 1");

		return palabra;
		
	}
	
	 /*
	  * Este metodo sera usado por el hilo2
	  * para pedirnos el numero por la entrada
	  * estandar 
	  */
	public static int pideNum() {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Escribe un número: ");
		
		int num = scanner.nextInt();
		
		return num;
		
	}

	public static void main(String[] args) {
		
		/*
		 * Definimos los dos hilos cada uno con un constructor diferente
		 */
		Thread hilo1= new Ejercicio2(pideCaracteres());
		
		Thread hilo2= new Ejercicio2(numPalabra, pideNum());
		
		
		//Los iniciamos
		hilo1.start();
		hilo2.start();
		try {
			/*
			 * queremos que se ejecuten uno detras de otro
			 * por que de lo contrario si llamamos a suma()
			 * sinque el primer hilo termine, uno de las variables
			 * aun estara vacia y valdra cero, con lo que el ejercicio 
			 * no estara correcto
			 */
			hilo1.join();
			hilo2.join();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		System.out.println("Soy el hilo principal!");

	}
	
	public void run() {
		
		/*
		 * Esto se ejecuta en los dos hilos pero como el 
		 * metodo de la suma solo se ejecuta en el hilo 2
		 * siempre sera cero hasta que se ejecute el 
		 * hilo 1 y no le demos el numero al hilo 2
		 */
		if (suma != 0) {
			/*
			 * Asi que esto no se ejecutará hasta que 
			 * suma contenga algo es decir hasta que se ejecute 
			 * en el orden correcto y ocurran todos los pasos
			 */
			System.out.println(String.valueOf(suma));
			System.out.println("Soy el hilo 2");
		}
		
	}

	/*
	 * Este metodo suma dos atributos de la clase que solo tendran valor 
	 * definido cuando se ejecute el hilo2 que tiene en su constructor
	 * la definicion de num mesiente el metodo pideNum() y la ejecucion 
	 * de este metodo. Dando por fin un valor definico a suma.
	 */
	private void sumar() {
		suma = Integer.parseInt(String.valueOf(numPalabra)) + Integer.parseInt(String.valueOf(num));
	}

}
