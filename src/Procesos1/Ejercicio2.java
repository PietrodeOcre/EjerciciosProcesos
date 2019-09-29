package Procesos1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//Ejecuta un programa y sale por consola el nombre del proceso ejecutado
//y el resultado del proceso mediante el InputStream enviado 
//al InputStreamReader y de ahi al BuffererReader
public class Ejercicio2 {

	public static void main(String[] args) {
		String line;
		Scanner scan = new Scanner(System.in);
		String input;

		ProcessBuilder builder = new ProcessBuilder("bash", "-c", "ls -la");
		builder.redirectErrorStream(true);
		ProcessBuilder builder2 = new ProcessBuilder("bash", "-c", "tr d D ");
		Process process;
		Process process2;
		try {
			process = builder.start();
			process2 = builder2.start();

			OutputStream stdin = process.getOutputStream ();

			InputStream stdout = process.getInputStream ();
			
			OutputStream stdin2 = process2.getOutputStream ();

			InputStream stdout2 = process2.getInputStream ();

			BufferedReader reader = new BufferedReader (new InputStreamReader(stdout));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));
			BufferedReader reader2 = new BufferedReader (new InputStreamReader(stdout2));
			BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(stdin2));
			
			while ((reader.readLine()) != null) {
				line =  reader.readLine();
				writer2.write(line.toCharArray());
				System.out.println(line);
				
			}
			
			while ((reader2.readLine()) != null) {
				line =  reader2.readLine();
				
				System.out.println(line);
			}
			

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}


}