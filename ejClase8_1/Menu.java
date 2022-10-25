package ejClase8_1;

import java.util.Scanner;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	
	static public int menuInicial() {
		System.out.println("CAMPUS VIRTUAL");
		System.out.println("1 - Listado de alumnos");
		System.out.println("2 - Listado de profesores");
		System.out.println("3 - SALIR");
		System.out.println("Elija una opción: ");
		int opcion = sc.nextInt();
		
		return opcion;
	}
	
	
}
