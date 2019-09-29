package Procesos1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class Flujos {

	static String letra2;


	public static void main(String[] args) {
		// TODO Auto-generated method stub



		String comando1 = "ls -la";

		String comando2 = "tr";

		ProcessBuilder proceso1 = new ProcessBuilder(proceso1(comando1));

		ProcessBuilder proceso2 = new ProcessBuilder(proceso2(comando2, args[0]));
		for(int i=0; i > args[0].length();i++){
			System.out.println(proceso2);
		}



	}

	private static String proceso1(String comando) {
		//char[] caract = new char[caracter.length()](caracter.toCharArray());
		ProcessBuilder pBuilder = new ProcessBuilder("bash", "-c", comando);

		try {
			Process procesoProcess = pBuilder.start();

			procesoProcess.waitFor();

			return mostrarResultado(procesoProcess);

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static List<String> proceso2(String comando, String cad) {

		List<String> enteraList = new ArrayList<String>();

		for(int i=0; i > cad.length(); i++) {

			ProcessBuilder pBuilder = new ProcessBuilder("bash", "-c", comando + cad.charAt(i) + "D");

			try {
				Process procesoProcess = pBuilder.start();

				enteraList.add(mostrarResultado(procesoProcess));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return enteraList;


	}

	public static String mostrarResultado(Process p) {

		InputStream is = p.getInputStream();

		InputStreamReader flujo = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(flujo);

		OutputStream os = p.getOutputStream();

		OutputStreamWriter flujo1 = new OutputStreamWriter(os);	
		BufferedWriter bw = new BufferedWriter(flujo1,200000);
		int letra = 0;
		int i=0;

		try {

			while ((letra =  br.read()) != -1) {
				i++;
				//letra = is.read();
				System.out.print((char)letra);
				letra2 =letra2 + (char)letra;
				bw.write(letra2);

			}
			System.out.println(i);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return letra2;



	}

}
