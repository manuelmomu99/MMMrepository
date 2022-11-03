package menus;

import java.util.Scanner;

public class MenuPrincipal {

	static Scanner scINT = new Scanner(System.in);
	
	public static int mostrar_menu_princial() {
		
		System.out.println("¿A qué información quiere acceder?");
		System.out.println("1 - CLIENTES");
		System.out.println("2 - BANCOS");
		System.out.println("3 - CUENTAS");
		System.out.println("0 - SALIR");
		System.out.println("Elija una opción: ");
		int opcion = scINT.nextInt();
		System.out.println("");
		
		return opcion;
	}
	
	
	
	
}
