package Aleatorios;

import java.util.Random;

public class NumeroAleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Si ponemos una semilla el ramdom siempre ca el mismo numero para esa semilla
		long seed = 23L;		
		//Pero si quitamos la semilla en cada ocasión aparecerá un número diferente
		Random r = new Random(seed);
		
		int valorDado = r.nextInt(12)+1;
		
		System.out.println(valorDado);
		
	}

}
