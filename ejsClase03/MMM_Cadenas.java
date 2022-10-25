package ejsClase03;

import java.util.Scanner;

public class MMM_Cadenas {

	
	
	public static int [] cuenta_letras (String cadena) {
		
		cadena = cadena.toLowerCase();
		cadena = cadena.replace("á", "a");
		cadena = cadena.replace("é", "e");
		cadena = cadena.replace("í", "i");
		cadena = cadena.replace("ó", "o");
		cadena = cadena.replace("í", "u");
		
		char carray[] = cadena.toCharArray();

		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;

		for (char k : carray) {
			switch (k) {
			case 'a':	a++;  break;
			case 'e':	e++;  break;
			case 'i':	i++;  break;
			case 'o':   o++;  break;
			case 'u':   u++;  break;
			};
		}
		
		int [] contadores = {a, e, i, o, u};
		
		return contadores;
	};

	
	public static int menu(Scanner sc){
		
		System.out.println("CADENAS");
		System.out.println("1 - Convertir en mayúsculas");
		System.out.println("2 - Contar Vocales");
		System.out.println("3 - Mostrar Subcadena");
		System.out.println("4 - Cambiar Palabra");
		System.out.println("5 - Visualizar texto");
		System.out.println("6 - SALIR");
		System.out.println("Elige una opción:");
		
		int option = sc.nextInt();
		return option;
	};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// Pedimos una cadena con 30 o mas caracteres
		int car = 0;
		String cadena = "";
		
		do {
			System.out.println("Introduzca una cadena de al menos 30 caracteres.");
			cadena = sc.nextLine();
			car = cadena.length();
		} while ( car < 30 );
		
		
		// El usuario elige como manipular la cadena introducida
		boolean salir = false;
		do {
			int option = menu(sc);
			
			switch (option) {
			case 1:
				System.out.println(cadena.toUpperCase());
				System.out.println("");
				break;
			case 2:
				char[] vocales = { 'a', 'e', 'i', 'o', 'u'};
				
				for (int i = 0; i <= vocales.length -1 ; i++) {
					System.out.println("Número de letras " + vocales[i] + ": " 
				+ cuenta_letras(cadena)[i]);	
				};
				
				System.out.println("");
				break;
			case 3:
				System.out.println("Dime el límite izquierdo: ");
				int a = sc.nextInt();
				System.out.println("Dime el límite derecho: ");
				int b = sc.nextInt();
				System.out.println(cadena.substring(a, b));
				System.out.println("");
				break;
			case 4:
				System.out.println("Dime que palabra quieres quitar: ");
				String quitar = sc.nextLine();
				System.out.println("Dime que palabra quieres poner: ");
				String poner = sc.nextLine();
				System.out.println(cadena.replace(quitar, poner));
				System.out.println("");
				break;
			case 5:
				System.out.println(cadena);
				System.out.println("");
				break;
			case 6:
				salir = true;
				break;
			}
		} while (salir == false);

		sc.close();
		
	}

}
