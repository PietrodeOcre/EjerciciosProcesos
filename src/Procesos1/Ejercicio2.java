package Procesos1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio2 {

	public static String frase;


	public static void main(String[] args){
		

		proceso1();

		


	}

	public static void proceso1() {

		ProcessBuilder pb = new ProcessBuilder("bash", "-c", "ls -la");

		try {
			Process proceso1 = pb.start();

			InputStream is = proceso1.getInputStream();

			InputStreamReader flujo = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(flujo);
			
			int letra = 0;
			try {

				while ((letra =  br.read()) != -1) {

					//letra = is.read();
					
					//System.out.print((char)letra);
					frase = frase + (char)letra;

				}
				proceso2(frase);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	public static void proceso2(String frase1) {

		ProcessBuilder pb = new ProcessBuilder("bash", "-c", "echo '"+frase1+"' | tr 'd' 'D'");
		//echo '"Juan";"Pepe";' | tr '";' ' \t'
		try {
			Process proceso2 = pb.start();
			
			InputStream is = proceso2.getInputStream();

			InputStreamReader flujo = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(flujo);
			
			int letra = 0;
			try {

				while ((letra =  br.read()) != -1) {

					//letra = is.read();
					System.out.print((char)letra);
					

				}
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
