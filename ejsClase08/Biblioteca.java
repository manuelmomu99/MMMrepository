package ejsClase08;

import java.time.LocalDate;
import java.util.Scanner;

public class Biblioteca {

	final static int LISTADO = 1;
	final static int PEDIR = 2;
	final static int DEVOLVER = 3;
	final static int SALIR = 4;

	static Libro libro1 = new Libro("Libro A", "1", LocalDate.ofYearDay(1982, 1));
	static Libro libro2 = new Libro("Libro B", "2", LocalDate.ofYearDay(1997, 1));
	static Libro libro3 = new Libro("Libro C", "3", LocalDate.ofYearDay(2015, 1));
	static Libro libro4 = new Libro("Libro D", "4", LocalDate.ofYearDay(1970, 1));
	static Libro libro5 = new Libro("Libro E", "5", LocalDate.ofYearDay(2021, 1));

	static Revista revista1 = new Revista("Revista A", "6", LocalDate.ofYearDay(1999, 1), "1");
	static Revista revista2 = new Revista("Revista B", "7", LocalDate.ofYearDay(2006, 1), "5");
	static Revista revista3 = new Revista("Revista C", "8", LocalDate.ofYearDay(2011, 1), "150");
	static Revista revista4 = new Revista("Revista D", "9", LocalDate.ofYearDay(1987, 1), "2");
	static Revista revista5 = new Revista("Revista E", "10", LocalDate.ofYearDay(2003, 1), "7");

	static Articulo[] articulos = { libro1, libro2, libro3, libro4, libro5, 
			revista1, revista2, revista3, revista4, revista5 };

	
	static Scanner sc = new Scanner(System.in);
	
	
	public static void pedir_libro() {
		Menu.mostrarArticulos(articulos);
		System.out.println("Elija una opción: ");
		int opcion = sc.nextInt();
		
		if (opcion <= articulos.length + 1) {
			Articulo articulo = articulos[opcion - 1];
			if (articulo instanceof Libro) {
				((Libro) articulo).prestar();
			} else {
				System.out.println("El articulo seleccionado es una revista y las revistas no se pueden prestar. \n");
			}
		} else {
			System.out.println("El articulo seleccionado no existe. \n");
		}
	}

	
	public static void devolver_libro() {
		Menu.mostrarArticulos(articulos);
		System.out.println("Elija una opción: ");
		int opcion = sc.nextInt();
		
		if (opcion <= articulos.length + 1) {
			Articulo articulo = articulos[opcion - 1];
			if (articulo instanceof Libro) {
				((Libro) articulo).devolver();
			} else {
				System.out.println("El articulo seleccionado es una revista y las revistas no se pueden prestar. \n");
			}
		} else {
			System.out.println("El articulo seleccionado no existe. \n");
		}
	}
	
	
	public static void main(String[] args) {
		boolean end = false;

		do {
			int opcion = Menu.menuInicial();
			switch (opcion) {
			case LISTADO:
				Menu.mostrarArticulos(articulos);
				break;
			case PEDIR:
				pedir_libro();
				break;
			case DEVOLVER:
				devolver_libro();
				break;
			case SALIR:
				end = true;
				break;
			default:
				System.out.println("Opción no válida.");

			}
		} while (end == false);

	}

}
