package EjercicioHilos1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 extends Thread{
	
	private String palabra;
	private int num;

	public Ejercicio2(int num) {
		this.num=num;
	}
	
	public Ejercicio2(String palabra) {
		this.palabra=palabra;
	}

	public static String pideCaracteres() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Escribe una palabra: ");
		
		String palabra = scanner.next();

		return palabra;
		
	}
	
	public static int pideNum() {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Escribe un número: ");
		
		int num = scanner.nextInt();
		
		
		return num;
		
	}

	public static void main(String[] args) {
		Thread hilo1= new Ejercicio2(pideCaracteres());
		
		Thread hilo2= new Ejercicio2(pideNum());
		
		
		
		hilo1.start();
		hilo2.start();
		try {
			hilo1.join();
			hilo2.join();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Soy el hilo principal!");

	}
	
	public void run() {
		
		
		
		
		
	}

}
