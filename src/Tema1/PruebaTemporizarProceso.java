package Tema1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class PruebaTemporizarProceso {



	public static void main(String[] args) {
		try {

			String ruta = "/home/pietrodeocre/eclipse/EjerciciosPSP/src/Tema1/test.txt";
			File archivo = new File(ruta);
			BufferedWriter bw;
			//Comprobamos si el fichero existe
			if(archivo.exists()) {
				bw = new BufferedWriter(new FileWriter(archivo));
				//Si existe, escribimos dentro.
				bw.write("Ya está creado.");
				bw.close();
				System.out.println("Lanzando programa...");
				Process p = Runtime.getRuntime().exec("/home/pietrodeocre/eclipse/EjerciciosPSP/src/Tema1/test.txt");             
				System.out.println("Espera joputa...");
				Thread.sleep(10000);
				p.destroy();

			} else {
				//En caso contrario, creamos el fichero y escribimos en el.
				bw = new BufferedWriter(new FileWriter(archivo));
				bw.write("El ficho acaba de ser creado.");
				bw.close();
				System.out.println("Lanzando programa...");
				Process p = Runtime.getRuntime().exec("/home/pietrodeocre/eclipse/EjerciciosPSP/src/Tema1/test.txt");           
				System.out.println("Espera joputa...");
				Thread.sleep(10000);
				p.destroy();
			}

			System.out.println("Se murio xddd.");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	}