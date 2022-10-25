package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import database.RecetaDAO;



public class MenuPrincipal {
	

	static Scanner scINT = new Scanner(System.in);
	
	
	public static int mostrar_menu_principal() throws SQLException {
		
		System.out.println("BIENVENIDO A COMIDA SANA");
		System.out.println("1 - Ver recetas");
		System.out.println("2 - Crear receta");
		System.out.println("3 - Buscar restaurante");
		System.out.println("4 - SALIR");
		System.out.println("Elija una opción: ");
				
		int option= scINT.nextInt();
		
		System.out.println();
		return option;
	}
	
	
	public static void mostrar_Recetas() throws SQLException {
		ResultSet listaRecetas = RecetaDAO.ver_recetas();

//		System.out.printf("%-20s %-20s \n", "Receta", "Restaurante");
//		System.out.println("--------------------------------------------------------------------");
//		while (listaRecetas.next()) {
//			String nombreRestaurante = listaRecetas.getString("RESTAURANTE.NOMBRE");
//			String nombreReceta = listaRecetas.getString("RECETA.NOMBRE");
//
//			System.out.printf("%-20s %-20s \n", nombreReceta, nombreRestaurante);
//		}
//		System.out.println("");
	}

}
