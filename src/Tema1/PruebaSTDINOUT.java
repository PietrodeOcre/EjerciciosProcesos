package Tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class PruebaSTDINOUT {
	
	

	public static void main(String[] args) {
		
		try {
			//Process shell=new ProcessBuilder("ls /home/pietrodeocre/").start();
			Process Proceso = new ProcessBuilder("ls").start();
			
			System.out.println("Primer proceso");
			
			InputStream is = Proceso.getInputStream();
			
			InputStreamReader isr= new InputStreamReader(is,"UTF-8");
			
			BufferedReader br = new BufferedReader(isr);

			otroProceso(br);
			is.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("Proceso padre");
	}
	
	public static void otroProceso(BufferedReader archivos) {
		
		Thread nuevoProcesoThread = new Thread() {
			public void run() {
				String line ="";
				String cadenaString="";
				try {
					while((line=archivos.readLine()) !=null) {

						cadenaString += line + "\n";
					}
				} catch (IOException e) {

					e.printStackTrace();
				}
				System.out.println(cadenaString.toUpperCase());
				System.out.println("Otro proceso");
			}
		};
		
		nuevoProcesoThread.run();
		
	}

}
