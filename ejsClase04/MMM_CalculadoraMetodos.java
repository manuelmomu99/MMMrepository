package ejsClase04;

import java.util.Scanner;

import java.lang.Math;

public class MMM_CalculadoraMetodos {

	// Constantes para eliminar numeros magicos
	static final int SUMA = 1;
	static final int RESTA = 2;
	static final int MULT = 3;
	static final int DIV = 4;
	static final int VA = 5;
	static final int MPI = 6;

	
	public static int menu(Scanner sca) {

		System.out.println("CALCULADORA");
		System.out.println("1 - Sumar");
		System.out.println("2 - Restar");
		System.out.println("3 - Multiplicar");
		System.out.println("4 - Dividir");
		System.out.println("5 - Valor Absoluto");
		System.out.println("6 - Mostrar PI");
		System.out.println("Elige una opción:");
		int option = sca.nextInt();
		return option;
	};

	
	public static double[] dame_num(Scanner sca, int option) {

		double a = 0;
		double b = 0;

		if (option < 5 && option > 0) {
			System.out.println("Dame un número (decimales con coma ','): ");
			a = sca.nextDouble();
			System.out.println("Dame otro número (decimales con coma ','): ");
			b = sca.nextDouble();
		} else if (option == 5) {
			System.out.println("Dame un número (decimales con coma ','): ");
			a = sca.nextDouble();
		};

		double ret[] = { a, b };

		return ret;
	};

	
	public static void calculo(int option, double a, double b) {
		// Mostramos lo que el usuario pide

		switch (option) {
		case SUMA:
			System.out.println("El resultado de la suma es: " + (a + b));
			break;
		case RESTA:
			System.out.println("El resultado de la resta es: " + (a - b));
			break;
		case MULT:
			System.out.println("El resultado de la multiplicación " + "es: " + (a * b));
			break;
		case DIV:
			System.out.println("El resultado de la división es: " + (a / b));
			break;
		case VA:
			System.out.println("Su valor absoluto es: " + (Math.abs(a)));
			break;
		case MPI:
			System.out.println("El número pi es:" + Math.PI);
			break;
		default:
			System.out.println("Opción no válida.");
		}
		;
	};
	
	
	public static void main(String[] args) {

		// Abrimos scanner
		Scanner sc = new Scanner(System.in);

		
		// Imprimimos el menu y guardamos la opcion
		int option = menu(sc);

		
		// Pedimos y guardamos los numeros necesarios
		double num[] = new double[2];

		num = dame_num(sc, option);
		double a = num[0];
		double b = num[1];
		
		
		// Calculamos
		calculo(option, a, b);
		
	
		// Cerramos scanner
		sc.close();
	}

}
