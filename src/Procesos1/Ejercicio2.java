package Procesos1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import org.w3c.dom.ls.LSException;

//Ejecuta un programa y sale por consola el nombre del proceso ejecutado
//y el resultado del proceso mediante el InputStream enviado 
//al InputStreamReader y de ahi al BuffererReader
public class Ejercicio2 {

	public static void proceso1() {
		
		ProcessBuilder pb = new ProcessBuilder("bash", "-c", "ls -la");
		
		try {
			Process proceso1 = pb.start();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void proceso2() {
		
		ProcessBuilder pb = new ProcessBuilder("bash", "-c", "tr d D");
		
		try {
			Process proceso2 = pb.start();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		
		
	}

}