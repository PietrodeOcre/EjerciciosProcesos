package Procesos1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutput;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//Ejecuta un programa y saa por consola el nombre del proceso ejecutado
//y el resultado del proceso mediante el InputStream enviado 
//al InputStreamReader y de ahi al BuffererReader
public class Ejercicio2 {

	public static void main(String args[]) throws IOException {


		try {
			//Creamos el comando que queremos ejecutar
			String proceso = new String("ls -la");
			String proceso2 = new String("tr D d");
			//mandamos a que se ejecute el comando pasandole como array de string
			//Process process = Runtime.getRuntime().exec(new String[] {"bash","-c",proceso});
			//Este metodo hace lo mismo que todo el Runtime del comentario
			Process process = new ProcessBuilder("bash","-c",proceso).start();


			Process process2 = new ProcessBuilder("bash","-c",proceso2).start();
			//Enviamos la salida del primer proceso a la entrada del segundo

			//Capturamos la salida con el metodo getImputStream
			InputStream is = process.getInputStream();

			//Lo convertimos a UTF-8 para pasarlo al BufferedReader
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");

			BufferedReader br = new BufferedReader(isr);





			String line;

			System.out.println("Salida del proceso " + proceso + ":");

			while ((line = br.readLine()) != null) {
				//imprimimos las lineas que saca el BufferedReader
				//Hasta que la linea siguiente sea null
				System.out.println(line);

			}
		}

	}



}
