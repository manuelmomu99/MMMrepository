package ejsClase05_MMM;

import java.util.Scanner;

import java.lang.Math;

public class MMM_Elecciones {

	static Scanner sc = new Scanner(System.in);
	
	
	public static String [] candidatos() {
		String nombresCandidatos [] = new String [2];
		
		System.out.println("Introduce el nombre del primer candidato: ");
		nombresCandidatos[0] = sc.nextLine();
		
		System.out.println("Introduce el nombre del segundo candidato: ");
		nombresCandidatos[1] = sc.nextLine();
		
		System.out.printf("¡Las elecciones entre %s y %s comienzan!\n", 
				nombresCandidatos[0], nombresCandidatos[1]);
		
		return nombresCandidatos;
	};
	
	
	public static boolean elecciones (String [] nombresCandidatos) {
		String candidato1 = nombresCandidatos[0];
		String candidato2 = nombresCandidatos[1];
		
		boolean end = false;
		
		int votosCandidato1 = 0;
		int votosCandidato2 = 0;
		int votosTotales = votosCandidato1 + votosCandidato2;
		
		// Proceso electoral
		do {
			double votoActual = Math.round(Math.random());
			votosTotales++;
			if (votoActual == 0) {
				votosCandidato1++;
			} else {
				votosCandidato2++;
			}
		} while (votosTotales<538);
		
		
		// Resultado
		System.out.printf("- El candidato %s con: %d votos. \n", candidato1, votosCandidato1);
		System.out.printf("- El candidato %s con: %d votos. \n", candidato2, votosCandidato2);
		if (votosCandidato1 > votosCandidato2) {
			System.out.printf("- ¡Gana %s! \n", candidato1);
			end = true;
		} else if (votosCandidato1 < votosCandidato2) {
			System.out.printf("- ¡Gana %s! \n", candidato2);
			end = true;
		} else {
			System.out.println("- Ha habido un empate, se repiten las elecciones.");
		};
		
		
		return end;
	};
	
	public static void main(String[] args) {
		boolean end = false;
		int numeroElecciones = 1;
		String [] nombresCandidatos = candidatos();
		
		do {
			System.out.println("RESULTADO DE LAS ELECCIONES " + numeroElecciones);
			numeroElecciones++;
			end = elecciones(nombresCandidatos);
		} while(end == false);
		
		
		
		sc.close();
	}
}
