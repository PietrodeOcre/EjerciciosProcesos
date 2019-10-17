package EjercicioHilos1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio1 extends Thread{
	
	private String frase;

	public static void main(String[] args) {
		
		Thread hilo1= new Ejercicio1(pideString());
		
		hilo1.start();
		
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Soy el hilo principal!");

	}
	
	public Ejercicio1(String frase) {
		
		this.frase = frase;
		
	}
	
	public static String pideString() {
		
		String frase;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Escribe una frase: ");
		
		frase = scanner.next();
		
		return frase;
		
	}
	
	public void run() {
		
		char[] caracteres = frase.toCharArray();
		//System.out.println(Arrays.toString(caracteres));
		char[] aux =  new char[caracteres.length];
		int cont = 0;
		for (int i = caracteres.length-1; i >= 0 ; i--){
			aux[cont++] = caracteres[i];
			//System.out.print(caracteres[i]);
		}
		//System.out.println("Soy el hilo!");
		
		
		System.out.println(aux);
		
		
		
	}

}
