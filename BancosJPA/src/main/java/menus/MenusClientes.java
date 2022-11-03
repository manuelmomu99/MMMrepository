package menus;

import java.util.Scanner;

public class MenusClientes {

	static Scanner scINT = new Scanner(System.in);
	
	public static int mostrar_menu_princial() {
		System.out.println("Se encuentra usted en el MENÚ DE CLIENTES");
		System.out.println("1 - Crear cliente");
		System.out.println("2 - Mostrar cliente");
		System.out.println("3 - Mostrar cuentas del cliente");
		System.out.println("4 - Modificar cliente");
		System.out.println("5 - Eliminar cliente");
		System.out.println("0 - SALIR");
		System.out.println("Elija una opción: ");
		int opcion = scINT.nextInt();
		System.out.println();
		
		return opcion;
	}
	
	
	
}
