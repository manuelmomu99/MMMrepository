package ejsClase08;

import java.util.Scanner;

public class Menu {

static Scanner sc = new Scanner(System.in);
	
	

	public static int menuInicial() {
		System.out.println("BIBLIOTECA");
		System.out.println("1 - Listado de articulos");
		System.out.println("2 - Pedir");
		System.out.println("3 - Devolver");
		System.out.println("4 - SALIR");
		System.out.println("Elija una opción: ");
		int opcion = sc.nextInt();
		
		return opcion;
	}

	public static void mostrarArticulos(Articulo[] articulos) {
		for (int i = 0; i < articulos.length; i++) {
			if (articulos[i] instanceof Libro) {
				System.out.printf("%2d - %s (%tY). Código %s. Estado: %s \n", (i + 1), articulos[i].getTitulo(),
						articulos[i].getYear(), articulos[i].getCodigo(), ((Libro) articulos[i]).prestado());
			} else {
				System.out.printf("%2d - %s (%tY). Número %s . Código %s. \n", (i + 1), articulos[i].getTitulo(),
						articulos[i].getYear(), ((Revista) (articulos[i])).getNumero(), articulos[i].getCodigo());
			}
		}
		System.out.println("");
	}
	
	

	
	
	
	
}