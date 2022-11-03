package menus;

import java.util.Scanner;

public class MenusCuentas {
static Scanner scINT = new Scanner(System.in);
	
	public static int mostrar_menu_princial() {
		System.out.println("Se encuentra usted en el MENÚ DE CUENTAS");
		System.out.println("1 - Crear cuenta");
		System.out.println("2 - Mostrar cuenta");
		System.out.println("3 - Modificar cuenta");
		System.out.println("4 - Eliminar cuenta");
		System.out.println("0 - SALIR");
		System.out.println("Elija una opción: ");
		int opcion = scINT.nextInt();
		System.out.println();
		
		return opcion;
	}
}
