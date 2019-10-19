package EjercicioHilos1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 extends Thread{
	
	/*
	 * Defino una variable para guardar los datos 
	 */
	private String palabra;

	public static void main(String[] args) {
		
		/*
		 * defino un hilo y lo pongo en marcha
		 */
		Thread hilo1= new Ejercicio1(pideString());
		
		hilo1.start();
		
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Soy el hilo padre!");

	}
	
	/*
	 * creo un constructor para que el propio hilo
	 * pudea pedir la palabra usando el metodo
	 * pideString() con lo que pido por la entrada
	 * estandar el string que guardo en la variable
	 */
	public Ejercicio1(String palabra) {
		
		this.palabra = palabra;
		
	}
	
	 /*
	  * el metodo pideString nos pide que por la entrada
	  * estandar escribamos una palabra o frase
	  * y devuelve esta misma para poder ser usada por el 
	  * contructor de la clase
	  */
	public static String pideString() {
		
		String palabra;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Escribe una frase: ");
		/*
		 * Si se usa el next() para el scanner al encontrar
		 * un espacio deja de guaradar en el string el 
		 * resto de lo que se escriba, por eso uso el nextLine()
		 */
		palabra = scanner.nextLine();
		
		return palabra;
		
	}
	
	public void run() {
		
		/*
		 * creamos un array de caracteres auxiliar
		 * con el tamaño del valor del string dado por
		 * el metodo anterior
		 */
		char[] aux =  new char[palabra.length()];
		/*
		 * El contador es para poder aumentar
		 *  la posicion del array auxiliar
		 */
		int cont = 0;
		for (int i = palabra.length()-1; i >= 0 ; i--){
			/*
			 * Recorroel array hacia atras y con el 
			 * contador avanzo en las posiciones del array aux
			 * con lo que el string queda guardado alreves
			 */
			aux[cont++] = palabra.charAt(i);

		}
		//Imprimo el array auxiliar y aparece como un string normal
		System.out.println(aux);
		System.out.println("Soy el hilo hijo.");
	}

}
