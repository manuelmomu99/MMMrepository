package app;

import java.sql.SQLException;

import database.RecetaDAO;
import view.MenuPrincipal;

public class MiApp {

	final static int VER_RECETAS = 1;
	final static int CREAR_RECETAS = 2;
	final static int BUSCAR_RESTAURANTE = 3;
	final static int SALIR = 4;
	
	
	public static void main(String[] args) {

		try {
			boolean salir = false;
		
			do {
			int opcion = MenuPrincipal.mostrar_menu_principal();
			switch(opcion) {
			case VER_RECETAS:
				RecetaDAO.ver_recetas();
				break;
			case CREAR_RECETAS:
				break;
			case BUSCAR_RESTAURANTE:
				break;
			case SALIR:
				salir = true;
				break;
			default:
				System.out.println("Opción no válida.");				
			}
			} while (salir == false);

		} catch (SQLException e) {
			e.printStackTrace();
			main(args);
		}

	}

}
