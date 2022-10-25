package ejsClase03;


import java.util.Scanner;

import java.lang.Math;

public class MMM_Calculadora {
	
	public static void menu () {

		System.out.println("CALCULADORA");
		System.out.println("1 - Sumar");
		System.out.println("2 - Restar");
		System.out.println("3 - Multiplicar");
		System.out.println("4 - Dividir");
		System.out.println("5 - Valor Absoluto");
		System.out.println("6 - Mostrar PI");
		System.out.println("Elige una opción:");
	};

	
	/*public static void suma () {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame un número: ");
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		sc.close();
		System.out.println("El resultado es "+(a+b));
	};*/
	
	
	public static void main(String[] args) {
		menu();
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		
		switch (input) {
		case "1":
		case "2":
		case "3":
		case "4":
			System.out.println("Dame un número (decimales con coma ','): ");
			double a = sc.nextDouble();
			System.out.println("Dame otro número : ");
			double b = sc.nextDouble();
			sc.close();
			switch (input) {
			case "1":
				System.out.println("El resultado de la suma es: " + (a + b));
				break;
			case "2":
				System.out.println("El resultado de la resta es: " + (a - b));
				break;
			case "3":
				System.out.println("El resultado de la multiplicación es: " + (a*b));
				break;
			case "4":
				System.out.println("El resultado de la división es: " +  (a/b));
			break;
			}
			break;	
		case "5":
			System.out.println("Dame un número: ");
			double c = sc.nextDouble();
			System.out.println("Su valor absoluto es: " + (Math.abs(c)));
			sc.close();
			break;
		case "6":
			System.out.println("El número pi es:" + Math.PI);
			break;
		default:
			System.out.println("Opción no válida.");

		}
		}
		
		
	}


