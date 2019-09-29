package Procesos1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutput;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

//Ejecuta un programa y sale por consola el nombre del proceso ejecutado
//y el resultado del proceso mediante el InputStream enviado 
//al InputStreamReader y de ahi al BuffererReader
public class Ejercicio2 {

	public static void main(String[] args) {
		String line;
		Scanner scan = new Scanner(System.in);

		ProcessBuilder builder = new ProcessBuilder("bash", "-c", "ls -la");
		builder.redirectErrorStream(true);
		Process process;
		try {
			process = builder.start();


			OutputStream stdin = process.getOutputStream ();

			InputStream stdout = process.getInputStream ();

			BufferedReader reader = new BufferedReader (new InputStreamReader(stdout));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));

			String input = "";
			input += "\n";
			try {
				writer.write(input);

				writer.flush();

				input = scan.nextLine();
				input += "\n";
				writer.write(input);
				writer.flush();

				

				input = scan.nextLine();
				input += "\n";
				writer.write(input);
				writer.close();

				while (scan.hasNext()) {
				    input = scan.nextLine();
				    if (input.trim().equals("exit")) {
				        // Putting 'exit' amongst the echo --EOF--s below doesn't work.
				        writer.write("exit\n");
				    } else {
				        writer.write("((" + input + ") && echo --EOF--) || echo --EOF--\n");
				    }
				    writer.flush();

				    line = reader.readLine();
				    while (line != null && ! line.trim().equals("--EOF--")) {
				        System.out.println ("Stdout: " + line);
				        line = reader.readLine();
				    }
				    if (line == null) {
				        break;
				    }
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}


}