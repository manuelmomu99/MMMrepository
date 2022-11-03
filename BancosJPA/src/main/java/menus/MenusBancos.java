package menus;

import java.util.Scanner;

public class MenusBancos {

	static Scanner scINT = new Scanner(System.in);
	
	public static int mostrar_menu_princial() {
		System.out.println("Se encuentra usted en el MENÚ DE BANCOS");
		System.out.println("1 - Crear banco");
		System.out.println("2 - Mostrar banco");
		System.out.println("3 - Mostrar cuentas banco");
		System.out.println("4 - Modificar banco");
		System.out.println("5 - Eliminar banco");
		System.out.println("0 - SALIR");
		System.out.println("Elija una opción: ");
		int opcion = scINT.nextInt();
		System.out.println();
		
		return opcion;
	}
	
	
	
}
