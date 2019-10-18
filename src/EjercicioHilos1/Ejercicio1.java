package EjercicioHilos1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 extends Thread{
	
	private String palabra;

	public static void main(String[] args) {
		
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
	
	public Ejercicio1(String palabra) {
		
		this.palabra = palabra;
		
	}
	
	public static String pideString() {
		
		String palabra;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Escribe una frase: ");
		
		palabra = scanner.nextLine();
		
		return palabra;
		
	}
	
	public void run() {
		

		char[] aux =  new char[palabra.length()];
		int cont = 0;
		for (int i = palabra.length()-1; i >= 0 ; i--){
			aux[cont++] = palabra.charAt(i);

		}

		System.out.println(aux);
		System.out.println("Soy el hilo hijo.");
	}

}
