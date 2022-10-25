package ejsClase06;

import java.util.concurrent.ThreadLocalRandom;

public class MMM_Euromillones {

	final static int NUMERO_APUESTAS = 5;

	
	public static int[][] combinacion() {

		int[] numeros = { 0, 0, 0, 0, 0 };
		int[] estrellas = { 0, 0 };

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = ThreadLocalRandom.current().nextInt(1, 50 + 1);

			boolean end = false;

			do {
				for (int j = 0; j < numeros.length; j++) {

					if (j != i) {
						if (numeros[j] == numeros[i]) {
							numeros[i] = ThreadLocalRandom.current().nextInt(1, 50 + 1);
						} else {
							end = true;
						}
					}
				}
			} while (end == false);
		}

		for (int i = 0; i < estrellas.length; i++) {
			estrellas[i] = ThreadLocalRandom.current().nextInt(1, 12 + 1);

			boolean end = false;

			do {
				for (int j = 0; j < estrellas.length; j++) {

					if (j != i) {
						if (estrellas[j] == estrellas[i]) {
							estrellas[i] = ThreadLocalRandom.current().nextInt(1, 12 + 1);
						} else {
							end = true;
						}
					}
				}
			} while (end == false);
		}

		int[][] output = { numeros, estrellas };
		return output;
	}

	
	public static int [][][] generar_apuestas (){
		int[][][] apuestas = new int[NUMERO_APUESTAS][][];
		
		for (int i = 0; i < NUMERO_APUESTAS; i++) {
			int[][] apuesta = combinacion();
			apuestas [i] = apuesta;
	}
		return apuestas;
	}
	
	
	
	
	public static double [] calcular_premio_apuesta (int[][] combinacionGanadora, int[][]combinacion) {
		// CALCULAMOS EL NUMERO DE ACIERTOS
		// Compara numeros
		int numeroAciertos = 0;
		
		for (int i = 0; i<combinacion[0].length; i++ ) {
			if (combinacionGanadora[0][i] == combinacion[0][i]) {
				numeroAciertos++;
			}
		}
		

		// Compara estrellas
		
		int estrellaAciertos = 0;
		
		for (int i = 0; i<combinacion[1].length; i++ ) {
			if (combinacionGanadora[1][i] == combinacion[1][i]) {
				estrellaAciertos++;
			}
		}
		
		double premio = 0;
		
		// CALCULAMOS EL PREMIO
		switch(numeroAciertos) {
		case 5:
			premio = 1000000;
			break;
		case 4:
			premio = 10000;
			break;
		case 3:
			premio = 500;
			break;
		case 2:
			premio = 100;
			break;
		case 1:
			premio = 20;
			break;
		}
		
		switch (estrellaAciertos) {
		case 2:
			premio = premio*3.5;
			break;
		case 1:
			premio = premio*2;
			break;
		}
		
		
		double [] salida = {premio, numeroAciertos, estrellaAciertos};
		
		return salida;
	}
	
	
	public static double total_premios (int [][] combinacionGanadora, int [][][] apuestas){
		double premioTotal = 0;
		
		for (int[][] apuesta:apuestas) {
			premioTotal = premioTotal + calcular_premio_apuesta(combinacionGanadora, apuesta)[0];
		}
		
	return premioTotal;
	}
	
	
	
	
	public static void printCombinacion(int[][] combinacion) {

		int[] numeros = combinacion[0];
		int[] estrellas = combinacion[1];

		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] > 9) {
				System.out.print(numeros[i] + "  ");
			} else {
				System.out.print("0" + numeros[i] + "  ");
			}
		}
		
		System.out.print("Estrellas: ");
		for (int i = 0; i < estrellas.length; i++) {
			if (estrellas[i] > 9) {
				System.out.print(estrellas[i] + "  ");
			} else {
				System.out.print("0" + estrellas[i] + "  ");
			}
		}
	}

	
	public static void imprimir_ticket(int [][]combinacionGanadora, int[][][] apuestas) {
		
		
		
		System.out.println("Combinacion ganadora: ");
		printCombinacion(combinacionGanadora);
		System.out.println("\n"); 
		System.out.printf("| %20s Apuesta  %20s |%5s Aciertos %3s | %4s Premio %4s | \n",
				"", "", "", "", "", "");

		
		
		for (int i = 0; i < NUMERO_APUESTAS; i++) {

			int[][] apuesta = apuestas[i];

			double[] valores = calcular_premio_apuesta(combinacionGanadora, apuesta);
			double premio = valores[0];
			double numeroAciertos = valores[1];
			double estrellaAciertos = valores[2];

			System.out.printf("| Apuesta %d : ", (i + 1));
			printCombinacion(apuesta);
			System.out.print("|  ");

			if (estrellaAciertos == 0 || numeroAciertos == 0) {
				System.out.printf("%-6s %.0f %-6s  |", " ", numeroAciertos, " ");
			} else {
				System.out.printf("%.0f + %.0f estrellas  |", numeroAciertos, estrellaAciertos);
			}

			if (premio == 0) {
				System.out.printf("%17s | \n", "Sin premio");

			} else {
				System.out.printf("%15.2f € | \n", premio);
			}

		}
		System.out.printf("%s: %.02f € \n", "Total premios", total_premios(combinacionGanadora, apuestas));
		System.out.println("\n");
	}
		
	

	

	
	public static void main(String[] args) {

		double premio_total = 0;
		int iteraciones = 0;
		
		do {
			int[][] combinacionGanadora = combinacion();
			int[][][] apuestas = generar_apuestas();
			double premio_apuesta = total_premios(combinacionGanadora, apuestas);
			
			//imprimir_ticket(combinacionGanadora, apuestas);
			
			premio_total = premio_total + premio_apuesta;
			iteraciones++;
			//System.out.println(iteraciones);
			System.out.println(premio_total);
		}while (premio_total <= 5000000);
		
		System.out.println("Numero de iteraciones: " + iteraciones);
	}
}
